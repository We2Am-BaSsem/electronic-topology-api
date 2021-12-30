package com.electronic_topology_api.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NMOS extends Component {
    private String ID, type;
    private ArrayList<String> netList = new ArrayList<String>();
    private Map<String, Object> properties = new HashMap<>();

    public NMOS(String _ID, String _type, Map<String, Object> _properties, ArrayList<String> _netList) {
        // TODO Auto-generated constructor stub
        this.ID = _ID;
        this.type = _type;
        this.properties = _properties;
        this.netList = _netList;
    }

    /**
     * @return String Returns The NMOS ID
     */
    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return this.ID;
    }

    /**
     * @return String Returns "nmos" As A Device Type
     */
    @Override
    public String gettype() {
        // TODO Auto-generated method stub
        return this.type;
    }

    /**
     * @return Map(String, Object) Returns The NMOS's characteristics
     */
    @Override
    public Map<String, Object> getproperties() {
        // TODO Auto-generated method stub
        return this.properties;
    }

    /**
     * @return ArrayList(String) Returns The NMOS's netList
     */
    @Override
    public ArrayList<String> getnetList() {
        // TODO Auto-generated method stub
        return this.netList;
    }

}
