import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.AdjacencyListGraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.graphstream.graph.implementations.SingleGraph;
import static org.junit.jupiter.api.Assertions.*;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import java.util.stream.Stream;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.ElementNotFoundException;
public class AdjacencyListGraph_Test_Class {
    @Test
    @DisplayName("Testing AdjacencyListGraph first constructor")
    public void AdjacencyListGraph_test_one(){
        String graphId = "Graph 1";

        Graph graph = new AdjacencyListGraph("Graph 1");

        assertEquals(graphId, graph.getId());
    }

    @Test
    @DisplayName("Testing  AdjacencyListGraph second constructor")
    public void AdjacencyListGraph_test_two(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = false;

        Graph graph = new AdjacencyListGraph("Graph 1", false, false);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
    }

    @Test
    @DisplayName("Testing test method")
    public void nodes_test() {
        Graph graph = new SingleGraph("Graph 1", true, false, 5, 3);

        // Testing zero nodes
        Stream<Node> nodeStream = graph.nodes();
        assertEquals(0, nodeStream.count());

        // Testing adding nodes
        graph.addNode("Node 1");
        graph.addNode("Node 2");
        graph.addNode("Node 3");

        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 1")));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 2")));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 3")));
        nodeStream = graph.nodes();
        assertEquals(3, nodeStream.count());

        // Testing adding a duplicated node
        assertThrows(IdAlreadyInUseException.class, () -> {
            graph.addNode("Node 3");
        });

        // Testing removing a non-existence node
        assertThrows(ElementNotFoundException.class, () -> {
            graph.removeNode("Node 7");
        });

        // Testing removing a node
        graph.removeNode("Node 3");

        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 1")));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 2")));
        nodeStream = graph.nodes();
        assertFalse(nodeStream.anyMatch(node -> node.getId().equals("Node 3")));
        nodeStream = graph.nodes();
        assertEquals(2, nodeStream.count());

        // Testing removing two nodes in a row
        graph.removeNode("Node 1");

        nodeStream = graph.nodes();
        assertFalse(nodeStream.anyMatch(node -> node.getId().equals("Node 1")));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 2")));
        nodeStream = graph.nodes();
        assertFalse(nodeStream.anyMatch(node -> node.getId().equals("Node 3")));
        nodeStream = graph.nodes();
        assertEquals(1, nodeStream.count());

        // Testing adding a node after removed one
        graph.addNode("Node 3");

        nodeStream = graph.nodes();
        assertFalse(nodeStream.anyMatch(node -> node.getId().equals("Node 1")));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 2")));
        nodeStream = graph.nodes();
        assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node 3")));
        nodeStream = graph.nodes();
        assertEquals(2, nodeStream.count());

        // Testing limit valor of initial node's capacity
        graph.addNode("Node 1");
        graph.addNode("Node 4");
        graph.addNode("Node 5");

        for (int i = 1; i <= 5; i ++){
            int index = i;
            nodeStream = graph.nodes();
            assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node " + Integer.toString(index))));
        }
        nodeStream = graph.nodes();
        assertEquals(5, nodeStream.count());

        // Testing adding a node after initial node's capacity
        graph.addNode("Node 6");

        for (int i = 1; i <= 6; i ++){
            int index = i;
            nodeStream = graph.nodes();
            assertTrue(nodeStream.anyMatch(node -> node.getId().equals("Node " + Integer.toString(index))));
        }

        nodeStream = graph.nodes();
        assertEquals(6, nodeStream.count());
    }

    @Test
    @DisplayName("Testing edges method when adding and removing")
    public void edges_test() {
        Graph graph = new SingleGraph("Graph 1", true, false, 5, 3);

        // Testing edges method when there are zero edges
        Stream<Edge> edgeStream = graph.edges();
        assertEquals(0, edgeStream.count());

        // Testing  edges method when there are tree edges
        graph.addNode("Node 1");
        graph.addNode("Node 2");
        graph.addNode("Node 3");

        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 1")));
        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 2")));
        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 3")));
        edgeStream = graph.edges();
        assertEquals(3, edgeStream.count());

        // Testing adding a duplicated node
        assertThrows(IdAlreadyInUseException.class, () -> {
            graph.addNode("Node 3");
        });

        // Testing removing a non-existence node
        assertThrows(ElementNotFoundException.class, () -> {
            graph.removeNode("Node 7");
        });

        // Testing removing a node
        graph.removeNode("Node 3");

        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 1")));
        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 2")));
        edgeStream = graph.edges();
        assertFalse(edgeStream.anyMatch(node -> node.getId().equals("Node 3")));
        edgeStream = graph.edges();
        assertEquals(2, edgeStream.count());

        // Testing removing two nodes in a row
        graph.removeNode("Node 1");

        edgeStream = graph.edges();
        assertFalse(edgeStream.anyMatch(node -> node.getId().equals("Node 1")));
        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 2")));
        edgeStream = graph.edges();
        assertFalse(edgeStream.anyMatch(node -> node.getId().equals("Node 3")));
        edgeStream = graph.edges();
        assertEquals(1, edgeStream.count());

        // Testing adding a node after removed one
        graph.addNode("Node 3");

        edgeStream = graph.edges();
        assertFalse(edgeStream.anyMatch(node -> node.getId().equals("Node 1")));
        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 2")));
        edgeStream = graph.edges();
        assertTrue(edgeStream.anyMatch(node -> node.getId().equals("Node 3")));
        edgeStream = graph.edges();
        assertEquals(2, edgeStream.count());
    }



}
