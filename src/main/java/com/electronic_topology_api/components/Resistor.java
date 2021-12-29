package com.electronic_topology_api.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resistor extends Component {
    private String ID, type;
    private ArrayList<String> netList = new ArrayList<String>();
    private Map<String, Object> properties = new HashMap<>();

    public Resistor(String _ID, String _type, Map<String, Object> _properties, ArrayList<String> _netList) {
        // TODO Auto-generated constructor stub
        this.ID = _ID;
        this.type = _type;
        this.properties = _properties;
        this.netList = _netList;
    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return this.ID;
    }

    @Override
    public String gettype() {
        // TODO Auto-generated method stub
        return this.type;
    }

    @Override
    public Map<String, Object> getproperties() {
        // TODO Auto-generated method stub
        return this.properties;
    }

    @Override
    public ArrayList<String> getnetList() {
        // TODO Auto-generated method stub
        return this.netList;
    }

}
