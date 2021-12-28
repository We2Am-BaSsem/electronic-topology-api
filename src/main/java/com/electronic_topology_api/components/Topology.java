package com.electronic_topology_api.components;

import java.util.ArrayList;

public class Topology {
    private String ID;
    private ArrayList<Component> components = new ArrayList<Component>();

    public Topology(String _ID, ArrayList<Component> _components) {
        ID = _ID;
        components = _components;
    }

    public String GetID() {
        return this.ID;
    }

    public ArrayList<Component> getComponents() {
        return this.components;
    }

    public void PrintTopology() {
        for (Component component : this.components) {
            if (component.gettype().compareTo("resistor") == 0) {
                System.out.println("\t\t\t*************   Resistor    *************");
                System.out.println("\t\t\t" + component.getID());
                System.out.println("\t\t\t" + component.getID());
                System.out.println("\t\t\t" + component.getnetList());
                System.out.println("\t\t\t" + component.getproperties());
                System.out.println("\t\t\t" + "*************   Resistor    *************");
            } else if (component.gettype().compareTo("nmos") == 0) {
                System.out.println("\t\t\t" + "*************   NMOS    *************");
                System.out.println("\t\t\t" + component.getID());
                System.out.println("\t\t\t" + component.getnetList());
                System.out.println("\t\t\t" + component.getproperties());
                System.out.println("\t\t\t" + "*************   NMOS    *************");
            }
        }
    }
}
