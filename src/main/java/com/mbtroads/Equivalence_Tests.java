package com.mbtroads;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Equivalence_Tests {
    @Test
    @DisplayName("SingleGraph TC1")
    public void SingleGraph_TC1(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = true;
        int initialEdgeCapacity = 12;
        int initialNodeCapacity = 13;

        Graph graph = new SingleGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }
    @Test
    @DisplayName("SingleGraph TC2")
    public void SingleGraph_T2(){
        String graphId = "";
        boolean isAutoCreationEnabled = true;
        boolean isStrictModeEnabled = false;
        int initialEdgeCapacity = 50;
        int initialNodeCapacity = 100;

        Graph graph = new SingleGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }
    @Test
    @DisplayName("SingleGraph TC3")
    public void SingleGraph_TC3(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = true;
        int initialEdgeCapacity = -10;
        int initialNodeCapacity = 13;

        Graph graph = new SingleGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }
    @Test
    @DisplayName("SingleGraph TC4")
    public void SingleGraph_TC4(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = false;
        int initialEdgeCapacity = 50;
        int initialNodeCapacity = -10;

        Graph graph = new SingleGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }

    @Test
    @DisplayName("AddNote TC1")
    public void AddNote_TC1(){
        String graphId = "Graph 1";
        String nodeId = "Node 1";

        Graph graph = new SingleGraph(graphId);

        graph.addNode(nodeId);
        assertEquals(1,graph.nodes().count());
    }
    @Test
    @DisplayName("AddNote TC2")
    public void AddNote_TC2(){
        String graphId = "Graph 1";
        String nodeId = "";

        Graph graph = new SingleGraph(graphId);

        graph.addNode(nodeId);

        assertEquals(1,graph.nodes().count());
    }
    @Test
    @DisplayName("AddNote TC3")
    public void AddNote_TC3(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);

        assertEquals(1,graph.nodes().count());
    }
    @Test
    @DisplayName("AddEdge TC1")
    public void AddEdge_TC1(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String edge = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);
        graph.addEdge(edge,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("AddEdge TC2")
    public void AddEdge_TC2(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String edge = "";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);
        graph.addEdge(edge,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("AddEdge TC3")
    public void AddEdge_TC3(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String nodeId3 = "Node 3";
        String nodeId4 = "Node 4";
        String edge1 = "Edge 1";
        String edge2 = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);
        graph.addNode(nodeId3);
        graph.addNode(nodeId4);
        graph.addEdge(edge1,nodeId1, nodeId2);
        graph.addEdge(edge2,nodeId3, nodeId4);
        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("AddEdge TC4")
    public void AddEdge_TC4(){
        String graphId = "Graph 1";
        String nodeId1 = "";
        String nodeId2 = "Node 2";

        String edge1 = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("AddEdge TC5")
    public void AddEdge_TC5(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";

        String edge1 = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(0,graph.edges().count());
    }
    @Test
    @DisplayName("AddEdge TC6")
    public void AddEdge_TC6(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "";

        String edge1 = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("AddEdge TC7")
    public void AddEdge_TC7(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";

        String edge1 = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId1);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(0,graph.edges().count());
    }

    @Test
    @DisplayName("RemoveEdge TC1")
    public void RemoveEdge_TC1(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String edge1 = "Edge 1";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());

        graph.removeEdge(edge1);

        assertEquals(0,graph.edges().count());
    }
    @Test
    @DisplayName("RemoveEdge TC2")
    public void RemoveEdge_TC2(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String edge1 = "Edge 1";
        String edge2 = "";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());

        graph.removeEdge(edge2);

        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("RemoveEdge TC3")
    public void RemoveEdge_TC3(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String edge1 = "Edge 1";
        String edge2 = "Edge 2";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId2);
        graph.addNode(nodeId1);

        graph.addEdge(edge1,nodeId1, nodeId2);

        assertEquals(1,graph.edges().count());

        graph.removeEdge(edge2);

        assertEquals(1,graph.edges().count());
    }
    @Test
    @DisplayName("RemoveNode TC1")
    public void RemoveNode_TC1(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId1);
        graph.addNode(nodeId2);

        assertEquals(2,graph.nodes().count());

        graph.removeNode(nodeId1);

        assertEquals(1,graph.nodes().count());
    }
    @Test
    @DisplayName("RemoveNode TC2")
    public void RemoveNode_TC2(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId1);

        assertEquals(1,graph.nodes().count());

        graph.removeNode(nodeId2);

        assertEquals(1,graph.nodes().count());
    }
    @Test
    @DisplayName("RemoveNode TC3")
    public void RemoveNode_TC3(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";

        Graph graph = new SingleGraph(graphId, false, false);

        graph.addNode(nodeId1);
        graph.addNode(nodeId2);

        assertEquals(2,graph.nodes().count());

        graph.removeNode(nodeId1);
        graph.removeNode(nodeId1);

        assertEquals(1,graph.nodes().count());
    }
    @Test
    @DisplayName("MultiGraph TC1")
    public void MultiGraph_TC1(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = true;
        int initialEdgeCapacity = 12;
        int initialNodeCapacity = 13;

        Graph graph = new MultiGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }
    @Test
    @DisplayName("MultiGraph TC2")
    public void MultiGraph_TC2(){
        String graphId = "";
        boolean isAutoCreationEnabled = true;
        boolean isStrictModeEnabled = false;
        int initialEdgeCapacity = 50;
        int initialNodeCapacity = 100;

        Graph graph = new MultiGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }
    @Test
    @DisplayName("MultiGraph TC3")
    public void MultiGraph_TC3(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = true;
        int initialEdgeCapacity = -10;
        int initialNodeCapacity = 13;

        Graph graph = new MultiGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }
    @Test
    @DisplayName("MultiGraph TC4")
    public void MultiGraph_TC4(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = false;
        int initialEdgeCapacity = 50;
        int initialNodeCapacity = -10;

        Graph graph = new MultiGraph(graphId, isStrictModeEnabled, isAutoCreationEnabled, initialNodeCapacity, initialEdgeCapacity);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }

    @Test
    @DisplayName("add TC1")
    public void add_TC1(){
        String graphId = "Graph 1";
        String nodeId1 = "Node 1";
        String nodeId2 = "Node 2";
        String edge1 = "Edge 1";
        String edge2 = "Edge 2";

        Graph graph = new SingleGraph(graphId, false, false);

        Node node1 = graph.addNode(nodeId2);
        Node node2= graph.addNode(nodeId1);

        Edge edge = graph.addEdge(edge1,nodeId1, nodeId2);

        Path path = new Path();

        path.add(node1, edge);

        assertEquals(1,path.edges().count());
    }
}
