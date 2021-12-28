package com.electronic_topology_api.components;

import java.util.ArrayList;

public class NMOS extends Component {
    private String ID, type;
    private ArrayList<String> properties, netList = new ArrayList<String>();

    public NMOS(String _ID, String _type, ArrayList<String> _properties, ArrayList<String> _netList) {
        // TODO Auto-generated constructor stub
        this.ID = _ID;
        this.type = _type;
        this.properties = _properties;
        this.netList = _netList;
        System.out.println(this.ID);
        System.out.println(this.type);
        System.out.println(this.netList);
        System.out.println(this.properties);
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
    public ArrayList<String> getproperties() {
        // TODO Auto-generated method stub
        return this.properties;
    }

    @Override
    public ArrayList<String> getnetList() {
        // TODO Auto-generated method stub
        return this.netList;
    }

}
