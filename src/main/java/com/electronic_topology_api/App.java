package com.electronic_topology_api;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        API.ReadTopology("topology.json");
        API.ReadTopology("topology2.json");

        API.GetTopologyByID("top1").PrintTopology();

        API.WriteTopology("top1");

        // System.out.println( ((Topology) API.GetAllTopology().toArray()[0]).GetID() );
        // System.out.println(((Topology) API.GetAllTopology().toArray()[1]).GetID());
        // System.out.println(API.GetTopologyByID("top1"));
        // System.out.println(API.DeleteTopologyByID("top1"));
        // System.out.println(API.GetTopologyByID("top1"));
        // System.out.println(API.DeleteTopologyByID("top1"));
        // System.out.println(API.GetDevices("top1"));
        // System.out.println(API.GetTopologyByConnectedNodes("top1","n1"));
        // System.out.println(API.GetTopologyByConnectedNodes("top1","vdd"));
        // System.out.println(API.GetTopologyByConnectedNodes("top1","vss"));
        // System.out.println(API.GetTopologyByConnectedNodes("top1","vin"));

    }
}
