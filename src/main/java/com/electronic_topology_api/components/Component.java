package com.electronic_topology_api.components;

import java.util.List;
import java.util.Map;

public abstract class Component {

    public abstract String getID();

    public abstract String gettype();

    public abstract Map<String, Object> getproperties();

    public abstract List<String> getnetList();
}
