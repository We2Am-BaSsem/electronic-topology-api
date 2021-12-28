package com.electronic_topology_api.components;

import java.util.ArrayList;

public abstract class Component {

    abstract public String getID();

    abstract public String gettype();

    abstract public ArrayList<String> getproperties();

    abstract public ArrayList<String> getnetList();
}
