package com.electronic_topology_api.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resistor extends Component {
    private String ID;
    private String type;
    private ArrayList<String> netList = new ArrayList<>();
    private Map<String, Object> properties = new HashMap<>();

    public Resistor(String _ID, String _type, Map<String, Object> _properties, ArrayList<String> _netList) {
        this.ID = _ID;
        this.type = _type;
        this.properties = _properties;
        this.netList = _netList;
    }

    /**
     * @return String Returns The Resistor ID
     */
    @Override
    public String getID() {
        return this.ID;
    }

    /**
     * @return String Returns "resistor" As A Device Type
     */
    @Override
    public String gettype() {
        return this.type;
    }

    /**
     * @return Map(String, Object) Returns The Resistor's characteristics
     */
    @Override
    public Map<String, Object> getproperties() {
        return this.properties;
    }

    /**
     * @return ArrayList(String) Returns The Resistor's netList
     */
    @Override
    public ArrayList<String> getnetList() {
        return this.netList;
    }

}
