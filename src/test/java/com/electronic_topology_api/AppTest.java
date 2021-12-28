package com.electronic_topology_api;

import static org.junit.Assert.*;

import java.io.IOException;

import com.electronic_topology_api.components.Topology;

import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     * 
     * @throws IOException
     */
    @Test
    @DisplayName("Human-readable test name")
    @Description("Some detailed test description")
    public void read_topology() throws IOException {
        Topology topology = API.ReadTopology("topology.json");
        assertEquals("Topolgy ID is not correct", "top1", topology.GetID());
        assertNotEquals("Topology is empty", 0, topology.getComponents().size());
    }
}
