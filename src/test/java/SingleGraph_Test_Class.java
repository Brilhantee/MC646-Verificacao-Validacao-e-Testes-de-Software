import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleGraph_Test_Class {
    @Test
    @DisplayName("Testing SingleGraph first constructor")
    public void SingleGraph_test_one(){
        String graphId = "Graph 1";

        Graph graph = new SingleGraph("Graph 1");

        assertEquals(graphId, graph.getId());
    }

    @Test
    @DisplayName("Testing SingleGraph second constructor")
    public void SingleGraph_test_two(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = false;

        Graph graph = new SingleGraph("Graph 1", false, false);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }

    @Test
    @DisplayName("Testing SingleGraph third constructor")
    public void SingleGraph_test_tree(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = false;

        Graph graph = new SingleGraph("Graph 1", false, false, 10, 20);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
        //assertEquals(graphId, NÃO SEI);
        //assertEquals(graphId, NÃO SEI);
    }

    @Test
    @DisplayName("Testing add a note in initial estate.")
    public void testing_add_a_note_in_initial_estate(){
        String graphId = "Graph 1";
        String node1Id = "Node 1";

        Graph graph = new SingleGraph(graphId);

        Stream<Node> nodeStream = graph.nodes();
        assertEquals(0, nodeStream.count());

        graph.addNode(node1Id);

        nodeStream = graph.nodes();
        assertEquals(1, nodeStream.count());

        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals(node1Id)));
    }

    @Test
    @DisplayName("Testing add a edge in initial estate.")
    public void testing_add_a_edge_in_initial_estate(){
        String graphId = "Graph 1";
        String node1Id = "Node 1";
        String node2Id = "Node 2";
        String edgeId = "Edge 1";

        Graph graph = new SingleGraph(graphId);

        Node node1 = graph.addNode(node1Id);
        Node node2 = graph.addNode(node2Id);

        graph.addEdge(edgeId, node1, node2);

        Stream<Node> nodeStream = graph.nodes();
        assertEquals(2, nodeStream.count());

        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals(node1Id)));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals(node2Id)));

        Stream<Edge> edgeStream = graph.edges();
        assertEquals(1, edgeStream.count());

        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals(edgeId)));
    }
}
