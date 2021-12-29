package com.electronic_topology_api.components;

import java.util.ArrayList;
import java.util.Map;

public abstract class Component {

    abstract public String getID();

    abstract public String gettype();

    abstract public Map<String, Object> getproperties();

    abstract public ArrayList<String> getnetList();
}
