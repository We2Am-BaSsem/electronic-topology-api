package com.electronic_topology_api;

import java.io.IOException;

import com.electronic_topology_api.components.Topology;

public class App {
    public static void main(String[] args) throws IOException {
        Topology topology = API.ReadTopology("topology.json");

        System.out.println("*************   Topology    *************");
        topology.PrintTopology();
        System.out.println("*************   Topology    *************");
    }
}
