package com.electronic_topology_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.electronic_topology_api.components.Component;
import com.electronic_topology_api.components.NMOS;
import com.electronic_topology_api.components.Resistor;
import com.electronic_topology_api.components.Topology;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class API {

    // private JSONParser jsonParser = new JSONParser();
    // private ArrayList<JSONObject> Topologies = new ArrayList<JSONObject>();
    // private JSONArray Topologies = new JSONArray();
    // private static ArrayList<Topology> topologyList = new ArrayList<Topology>();
    private static HashMap<String, Topology> topologyList = new HashMap<String, Topology>();
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    public API() {

    }

    /**
     * @return ObjectMapper
     */
    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        return mapper;
    }

    /**
     * @param json
     * @return JsonNode
     * @throws IOException N/A
     */
    private static JsonNode parse(String json) throws IOException {
        return objectMapper.readTree(json);
    }

    /**
     * @param fileName The file name for the targeted json file to read topology
     *                 from.
     * @return int indicates if the process is successful.
     *         0 : if try to read a topology that is already in the memory.
     *         1 : successful process.
     * @throws IOException N/A
     */
    public static int ReadTopology(String fileName) throws IOException {
        Path filePath = Paths.get(Paths.get(System.getProperty("user.dir")).toString(), "data", fileName);
        // String data = Files.readString(filePath);
        String data = new String(Files.readAllBytes(filePath));

        JsonNode obj = parse(data);
        String id = obj.get("id").toString().replaceAll("\"", "");
        if (topologyList.containsKey(id))
            return 0;
        Iterator<JsonNode> iterable = obj.get("components").iterator();
        ArrayList<Component> components = new ArrayList<Component>();
        while (iterable.hasNext()) {
            JsonNode component = (JsonNode) iterable.next();
            Map<String, Object> propertiesList = new HashMap<>();
            ArrayList<String> netList = new ArrayList<String>();
            if (component.get("type").asText().compareTo("resistor") == 0) {
                JsonNode properties = (JsonNode) component.get("resistance");
                JsonNode nets = (JsonNode) component.get("netlist");

                propertiesList.put("resistance", properties);

                // for (JsonNode property : properties) {
                // propertiesList.add(property.toString());
                // }
                for (JsonNode net : nets) {
                    netList.add(net.toString().replaceAll("\"", ""));
                }
                Resistor resistor = new Resistor(component.get("id").asText(), component.get("type").asText(),
                        propertiesList, netList);
                components.add(resistor);
            } else if (component.get("type").asText().compareTo("nmos") == 0) {
                JsonNode properties = (JsonNode) component.get("m(l)");
                JsonNode nets = (JsonNode) component.get("netlist");

                propertiesList.put("m(l)", properties);
                // for (JsonNode property : properties) {
                // propertiesList.add(property.toString());
                // }
                for (JsonNode net : nets) {
                    netList.add(net.toString().replaceAll("\"", ""));
                }

                NMOS nmos = new NMOS(component.get("id").asText(), component.get("type").asText(),
                        propertiesList, netList);
                components.add(nmos);
            }
        }
        // topologyList.add(new Topology(obj.get("id").asText(), components));
        topologyList.put(id, new Topology(id, components));
        return 1;
    }

    /**
     * @param ID The Topology ID To Write Its Data Into A Json File
     * @return int indicates if the process is successful.
     *         0 : If No Topology With The Given ID Exist.
     *         1 : successful process.
     * @throws IOException N/A
     */
    public static int WriteTopology(String ID) throws IOException {
        if (topologyList.containsKey(ID)) {
            Topology topology = topologyList.get(ID);
            Map<String, Object> map = new HashMap<>();
            ArrayList<Object> components = new ArrayList<>();

            map.put("id", topology.GetID());
            for (Component component : topology.getComponents()) {
                Map<String, Object> componentMap = new HashMap<>();
                if (component.gettype().compareTo("resistor") == 0) {
                    componentMap.put("type", component.gettype());
                    componentMap.put("id", component.getID());
                    componentMap.put("resistance", component.getproperties().get("resistance"));
                    componentMap.put("netlist", (Object) component.getnetList());
                } else if (component.gettype().compareTo("nmos") == 0) {
                    componentMap.put("type", component.gettype());
                    componentMap.put("id", component.getID());
                    componentMap.put("m(l)", component.getproperties().get("m(l)"));
                    componentMap.put("netlist", (Object) component.getnetList());
                }
                components.add(componentMap);
            }
            map.put("components", components);

            ObjectMapper mapper = new ObjectMapper();

            Path filePath = Paths.get(Paths.get(System.getProperty("user.dir")).toString(), "out",
                    topology.GetID() + ".json");
            mapper.writeValue(filePath.toFile(), map);
            return 1;
        }
        return 0;

    }

    /**
     * @param ID The Topology ID To Retrieve
     * @return Topology Returns The Desired Topology If Exist
     *         And If Not Returns null
     */
    public static Topology GetTopologyByID(String ID) {
        if (topologyList.containsKey(ID))
            return topologyList.get(ID);
        else
            return null;
        // for (Topology topology : topologyList) {
        // if (topology.GetID().compareTo(ID) == 0)
        // return topology;
        // }
        // return null;
    }

    /**
     * @return Collection(Topology) Returns The Whole Set of Topologies Stored In
     *         The Memory.
     */
    public static Collection<Topology> GetAllTopology() {
        // ArrayList<Topology> result = new ArrayList<Topology>();
        // for (Topology topology : topologyList.values()) {

        // }
        return topologyList.values();
    }

    /**
     * @param ID The Topology ID To Delete
     * @return int indicates if the process is successful.
     *         0 : If No Topology With The Given ID Exist.
     *         1 : successful process.
     */
    public static int DeleteTopologyByID(String ID) {
        if (topologyList.containsKey(ID)) {
            topologyList.remove(ID);
            return 1;
        } else
            return 0;
        // for (Topology topology : topologyList) {
        // if (topology.GetID().compareTo(ID) == 0) {
        // topologyList.remove(topology);
        // return 1;
        // }
        // }
        // return 0;
    }

    /**
     * @param ID The Topology ID To Retrieve its Devices
     * @return ArrayList(Component) Returns An ArrayList of The Desired Topology's
     *         Devices
     */
    public static ArrayList<Component> GetDevices(String ID) {
        if (topologyList.containsKey(ID))
            return topologyList.get(ID).getComponents();
        else
            return null;
        // for (Topology topology : topologyList) {
        // if (topology.GetID().compareTo(ID) == 0) {
        // return topology.getComponents();
        // }
        // }
        // return null;
    }

    /**
     * @param topologyID The Topology ID To Retrieve its Devices
     * @param nodeID     The Node ID To Get Devices Connected To It
     * @return ArrayList(Component) Returns An ArrayList of The Desired Topology's
     *         Devices And Connected With A Specific Node
     */
    public static ArrayList<Component> GetTopologyByConnectedNodes(String topologyID, String nodeID) {
        ArrayList<Component> result = new ArrayList<Component>();
        if (topologyList.containsKey(topologyID))
            for (Component component : topologyList.get(topologyID).getComponents()) {
                if (component.getnetList().contains(nodeID))
                    result.add(component);
            }

        // for (Topology topology : topologyList) {
        // if (topology.GetID().compareTo(topologyID) == 0)
        // for (Component component : topology.getComponents()) {
        // for (String node : component.getnetList()) {
        // if (node.replaceAll("\"", "").compareTo(nodeID) == 0) {
        // result.add(component);
        // }
        // }
        // }
        // }
        return result.size() == 0 ? null : result;
    }
}
