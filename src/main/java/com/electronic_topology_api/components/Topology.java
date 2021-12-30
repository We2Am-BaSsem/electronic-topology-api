package com.electronic_topology_api.components;

import java.util.ArrayList;
import java.util.List;

public class Topology {
    private String ID;
    private ArrayList<Component> components = new ArrayList<>();

    public Topology(String _ID, ArrayList<Component> _components) {
        this.ID = _ID;
        this.components = _components;
    }

    /**
     * @return String Returns The Topology ID
     */
    public String GetID() {
        return this.ID;
    }

    /**
     * @return ArrayList(Component) Returns The Topology Entire Devices
     */
    public List<Component> getComponents() {
        return this.components;
    }

    public void PrintTopology() {
        for (Component component : this.components) {
            if (component.gettype().compareTo("resistor") == 0) {
                System.out.println("\t\t\t*************   Resistor    *************");
                System.out.println("\t\t\t" + component.getID());
                System.out.println("\t\t\t" + component.gettype());
                System.out.println("\t\t\t" + component.getnetList());
                System.out.println("\t\t\t" + component.getproperties());
                System.out.println("\t\t\t" + "*************   Resistor    *************");
            } else if (component.gettype().compareTo("nmos") == 0) {
                System.out.println("\t\t\t" + "*************   NMOS    *************");
                System.out.println("\t\t\t" + component.getID());
                System.out.println("\t\t\t" + component.gettype());
                System.out.println("\t\t\t" + component.getnetList());
                System.out.println("\t\t\t" + component.getproperties());
                System.out.println("\t\t\t" + "*************   NMOS    *************");
            }
        }
    }
}
