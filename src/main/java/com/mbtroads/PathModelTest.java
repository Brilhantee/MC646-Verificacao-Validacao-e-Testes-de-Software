package com.mbtroads;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.machine.ExecutionContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathModelTest extends ExecutionContext implements PathModel {
    Path path = null;
    Graph graph = null;
    int number_of_nodes = 0;
    int number_of_edges = 0;

    @Override
    public void empty_estate(){
        System.out.println("\nEmpty Path Estate");
        path = new Path();
        graph = new SingleGraph("Graph 1");

        Stream<Node> nodes = path.nodes();
        Stream<Edge> edges = path.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_edges == 0);
        assert(count_of_nodes == 0);

        System.out.println("Number of Node is: " + count_of_nodes);
        System.out.println("Number of Edges is: " + count_of_edges);
    }

    @Override
    public void normal_estate(){
        System.out.println("\nNormal Path Estate");

        Stream<Node> nodes = path.nodes();
        Stream<Edge> edges = path.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_nodes  == number_of_nodes);
        assert(count_of_edges  == number_of_edges);

        System.out.println("Number of Node is: " + count_of_nodes);
        System.out.println("Number of Edges is: " + count_of_edges);
    }
    @Override
    public void set_root(){
        System.out.println("\nSet Root");
        number_of_nodes ++;
        String node_id = "Node " + number_of_nodes;
        Node node = graph.addNode(node_id);

        path.setRoot(node);
    }
    @Override
    public void add_the_first_node(){
        System.out.println("\nAdd The First Note");
        number_of_nodes =+ 2;
        number_of_edges ++;

        String node_source_id = "Node " + (number_of_nodes - 1);
        String node_target_id = "Node " + number_of_nodes;
        String edge_id = "Edge " + number_of_edges;

        Node node = graph.addNode(node_source_id);
        graph.addNode(node_target_id);

        Edge edge = graph.addEdge(edge_id,node_source_id, node_target_id);

        path.add(node, edge);
    }
    @Override
    public void add_node(){
        System.out.println("\nAdd Note");

        number_of_nodes ++;
        number_of_edges ++;

        String node_source_id = "Node " + (number_of_nodes - 1);
        String node_target_id = "Node " + number_of_nodes;
        String edge_id = "Edge " + number_of_edges;

        graph.addNode(node_target_id);
        Node node = graph.getNode(node_source_id);

        Edge edge = graph.addEdge(edge_id,node_source_id, node_target_id);

        path.add(node, edge);
    }

    @Override
    public void clear(){
        System.out.println("\nClear");
        path.clear();
        graph.clear();

        number_of_edges = 0;
        number_of_nodes = 0;
    }

    @Override
    public void pop_edge(){
        System.out.println("\nPopEdge");
        if (number_of_edges >= 1){
            path.popEdge();
            graph.removeEdge("Edge " + number_of_edges);
            graph.removeNode("Node " + number_of_nodes);
            number_of_edges --;
            number_of_nodes --;
        }
    }

    @Override
    public void pop_node(){
        System.out.println("\nPopNode");
        if (number_of_nodes > 1) {
            path.popNode();
            graph.removeEdge("Edge " + number_of_edges);
            graph.removeNode("Node " + number_of_nodes);
            number_of_edges --;
            number_of_nodes --;
        }
    }

    @Override
    public void add_edge(){
        System.out.println("\nAdd Edge");
        Stream<Node> nodes = path.nodes();
        Stream<Edge> edges = path.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        System.out.println(count_of_nodes);
        System.out.println(count_of_edges);

        number_of_nodes ++;
        number_of_edges ++;

        String node_source_id = "Node " + (number_of_nodes - 1);
        String node_target_id = "Node " + number_of_nodes;
        String edge_id = "Edge " + number_of_edges;

        graph.addNode(node_target_id);

        Edge edge = graph.addEdge(edge_id,node_source_id, node_target_id);

        path.add(edge);
    }
}
