package com.electronic_topology_api;

import static org.junit.Assert.*;

import java.io.IOException;

import com.electronic_topology_api.components.Topology;

import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setup() throws IOException {
        assertEquals("Did not read topology because of duplicate id", 1, API.ReadTopology("topology.json"));
        assertEquals("Read Topology with duplicate id", 0, API.ReadTopology("topology.json"));
    }

    
    /** 
     * @throws IOException
     */
    @After
    public void teardown() throws IOException {
        API.GetAllTopology().clear();
    }

    
    /** 
     * @throws IOException
     */
    @Test
    @DisplayName("Read A Topology From Json")
    @Description("Make An Instance From Topology And Assure It's Filled With Data From \"topology.json\"")
    public void a_read_topology() throws IOException {
        assertNotEquals("Topology is empty", null, API.GetTopologyByID("top1"));
        assertEquals("Topolgy ID is not correct", "top1", API.GetTopologyByID("top1").GetID());
        assertNotEquals("Topology is empty", 0, API.GetTopologyByID("top1").getComponents().size());
    }

    
    /** 
     * @throws IOException
     */
    @Test
    @DisplayName("Delete A Topology From The Memory")
    @Description("Delete An Instance From TopologyList Stored On The API Given Its ID And Assure That Function Return 1 And When Tring To Retrive It Again It Returns null")
    public void b_delete_topology() throws IOException {
        assertEquals("Topology is not deleted", 1, API.DeleteTopologyByID("top1"));
        assertNull("Topolgy is still exist in the memory", API.GetTopologyByID("top1"));
        assertEquals("Topology is not deleted", 0, API.DeleteTopologyByID("top1"));
    }

    
    /** 
     * @throws IOException
     */
    @Test
    @DisplayName("Read Another Topology And Add It To The Memory")
    @Description("Read \"topology.json\" And Assure That Memeory Size Is Increased By One")
    public void c_add_another_topology() throws IOException {
        int prevSize = API.GetAllTopology().size();
        assertEquals("Did not read topology because of duplicate id", 1, API.ReadTopology("topology2.json"));
        assertEquals("Read Topology with duplicate id", 0, API.ReadTopology("topology2.json"));

        assertEquals("Memory still have one topology", prevSize + 1, API.GetAllTopology().size());

        assertEquals("Memory still have one topology", "top1", ((Topology) API.GetAllTopology().toArray()[0]).GetID());
        assertEquals("Memory still have one topology", "top2", ((Topology) API.GetAllTopology().toArray()[1]).GetID());
    }
}