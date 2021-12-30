package com.electronic_topology_api;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        API.readTopology("topology.json");
        API.readTopology("topology2.json");

        API.getTopologyByID("top1").PrintTopology();

        API.writeTopology("top1");

        // System.out.println(((Topology) API.getAllTopology().toArray()[0]).GetID());
        // System.out.println(((Topology) API.getAllTopology().toArray()[1]).GetID());
        // System.out.println(API.getTopologyByID("top1"));
        // System.out.println(API.deleteTopologyByID("top1"));
        // System.out.println(API.getTopologyByID("top1"));
        // System.out.println(API.deleteTopologyByID("top1"));
        // System.out.println(API.getDevices("top1"));
        // System.out.println(API.getTopologyByConnectedNodes("top1", "n1"));
        // System.out.println(API.getTopologyByConnectedNodes("top1", "vdd"));
        // System.out.println(API.getTopologyByConnectedNodes("top1", "vss"));
        // System.out.println(API.getTopologyByConnectedNodes("top1", "vin"));

    }
}
