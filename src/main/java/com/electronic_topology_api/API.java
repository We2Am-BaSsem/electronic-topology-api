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

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    API() {

    }

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        return mapper;
    }

    private static JsonNode parse(String json) throws IOException {
        return objectMapper.readTree(json);
    }

    public static Topology ReadTopology(String fileName) throws IOException {
        Path filePath = Paths.get(Paths.get(System.getProperty("user.dir")).toString(), "data", fileName);
        // String data = Files.readString(filePath);
        String data = new String(Files.readAllBytes(filePath));

        JsonNode obj = parse(data);
        Iterator<JsonNode> iterable = obj.get("components").iterator();
        ArrayList<Component> components = new ArrayList<Component>();
        while (iterable.hasNext()) {
            JsonNode component = (JsonNode) iterable.next();
            if (component.get("type").asText().compareTo("resistor") == 0) {
                JsonNode properties = (JsonNode) component.get("resistance");
                JsonNode nets = (JsonNode) component.get("netlist");

                ArrayList<String> propertiesList = new ArrayList<String>();
                for (JsonNode property : properties) {
                    propertiesList.add(property.toString());
                }
                ArrayList<String> netList = new ArrayList<String>();
                for (JsonNode net : nets) {
                    netList.add(net.toString());
                }
                Resistor resistor = new Resistor(component.get("id").asText(), component.get("type").asText(),
                        propertiesList, netList);
                components.add(resistor);
            } else if (component.get("type").asText().compareTo("nmos") == 0) {
                JsonNode properties = (JsonNode) component.get("m(l)");
                JsonNode nets = (JsonNode) component.get("netlist");

                ArrayList<String> propertiesList = new ArrayList<String>();
                for (JsonNode property : properties) {
                    propertiesList.add(property.toString());
                }
                ArrayList<String> netList = new ArrayList<String>();
                for (JsonNode net : nets) {
                    netList.add(net.toString());
                }

                NMOS nmos = new NMOS(component.get("id").asText(), component.get("type").asText(),
                        propertiesList, netList);
                components.add(nmos);
            }
        }

        return new Topology(obj.get("id").asText(), components);

    }
}
