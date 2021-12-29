<h1 align="center">
  <strong>electronic-topology-api</strong>
</h1>

# Description
<p>
  A simple API for elecronic typology,a set of electronic components that are
  connected together.
</p>
<p>API Methods:</p>
<ol>
  <li>
    <p>
      Read a topology from A Json file in the data directory given file name
    </p>
    <p>API.ReadTopology(fileName);</p>
  </li>

  <li>
    <p>Write a topology to A Json file in the out directory given its ID</p>
    <p>API.WriteTopology(topologyID);</p>
  </li>

  <li>
    <p>Get All Topologies in the memory</p>
    <p>API.GetAllTopology();</p>
  </li>

  <li>
    <p>Delete a topology from the memory given its ID</p>
    <p>API.DeleteTopologyByID(topologyID);</p>
  </li>

  <li>
    <p>Get all devices in a specific topology given topology's ID</p>
    <p>API.GetDevices(topologyID);</p>
  </li>

  <li>
    <p>
      Get all devices in a specific topology and connected to a specific node
      given topology's ID and node's ID
    </p>
    <p>API.GetTopologyByConnectedNodes(topologyID,nodeID)</p>
  </li>
</ol>

# Test Report 
> [Report](https://rawcdn.githack.com/We2Am-BaSsem/electronic-topology-api/ff3e8f8e8a2b1611911a9195e9fb6dd2beb021f3/allure-report/index.html)


# Dependencies
<ol>
  <li>Java</li>
  <li>Junit</li>
  <li>Allure-Reporter</li>
</ol>

<div>
  <p align="center">
    <img
      style="width: 50px; height: 50px"
      src="https://user-images.githubusercontent.com/58189568/147677414-60bb9073-f1ba-4730-b67c-ba3dfd025d81.png"
      alt="logo"
    />
    <img
      style="width: 50px; height: 50px"
      src="https://user-images.githubusercontent.com/58189568/147677617-bddcacde-ac2f-4c3b-8e3a-28a09f6c73bc.png"
      alt="logo"
    />
    <img
      style="width: 50px; height: 50px"
      src="https://user-images.githubusercontent.com/58189568/147626016-f6d25de4-e275-4bb0-aea9-d99933303f46.png"
      alt="logo"
    />
  </p>
</div>


