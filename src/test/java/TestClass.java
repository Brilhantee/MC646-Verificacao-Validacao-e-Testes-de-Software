import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.AdjacencyListGraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.graphstream.graph.implementations.SingleGraph;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
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
    @DisplayName("Testing AdjacencyListGraph third constructor")
    public void AdjacencyListGraph_test_tree(){
        String graphId = "Graph 1";
        boolean isAutoCreationEnabled = false;
        boolean isStrictModeEnabled = false;

        Graph graph = new AdjacencyListGraph("Graph 1", false, false, 10, 20);

        assertEquals(graphId, graph.getId());
        assertEquals(isAutoCreationEnabled, graph.isAutoCreationEnabled());
        assertEquals(isStrictModeEnabled, graph.isStrict());
        //assertEquals(graphId, NÃO SEI);
        //assertEquals(graphId, NÃO SEI);
    }
}
