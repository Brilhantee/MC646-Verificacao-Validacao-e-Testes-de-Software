package com.mbtroads;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.machine.ExecutionContext;

import java.util.stream.Stream;

public class MultiGraphModelTest extends ExecutionContext implements MultiGraphModel {
    Graph graph = null;
    int number_of_nodes = 0;
    int number_of_edges = 0;
    int max_node_capacity = 128;
    int max_edge_capacity = 1024;
    @Override
    public void add_the_last_edge(){
        System.out.println("\nAdd The Last Edge");
        Stream<Edge> edges = graph.edges();
        for (int i = 1; edges.count() <= max_edge_capacity; i ++){
            for (int j = 1; j <= number_of_nodes; j ++){
                if (i != j){
                    String node_source = "Node " + Integer.toString(i);
                    String node_target = "Node " + Integer.toString(j);
                    String edge = "Edge " + Integer.toString(number_of_edges);

                    graph.addEdge(edge, node_source, node_target);

                    edges = graph.edges();
                    if (number_of_edges + 1 == (edges.count())){
                        number_of_edges ++;
                    }
                }
            }
            edges = graph.edges();
        }
        number_of_nodes = 128;
    }

    @Override
    public void add_the_last_node(){
        System.out.println("\nAdd The Last Node");
        for (int i = number_of_nodes + 1; i <= 128; i ++){
            String node = "Node " + Integer.toString(i);
            graph.addNode(node);
        }
        number_of_nodes = 128;
    }

    @Override
    public void empty_estate(){
        System.out.println("\nEmpty Estate");

        graph = new MultiGraph("Graph 1", false, false);

        Stream<Node> nodes = graph.nodes();
        Stream<Edge> edges = graph.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_edges == 0);
        assert(count_of_nodes == 0);

        System.out.println(count_of_nodes);
        System.out.println(count_of_edges);
    }

    @Override
    public void full_graph_estate(){
        System.out.println("\nFull Graph Estate");

        Stream<Node> nodes = graph.nodes();
        Stream<Edge> edges = graph.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_nodes  == 128);
        assert(count_of_edges == 1024);

        System.out.println(count_of_nodes);
        System.out.println(count_of_edges);
    }

    @Override
    public void full_node_estate(){
        System.out.println("\nFull Node Graph Estate");

        Stream<Node> nodes = graph.nodes();
        Stream<Edge> edges = graph.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_nodes  == max_node_capacity);
        assert(count_of_edges  < max_edge_capacity);

        System.out.println(count_of_nodes);
        System.out.println(count_of_edges);
    }

    @Override
    public void full_edge_estate(){
        System.out.println("\nFull Edge Graph Estate");

        Stream<Node> nodes = graph.nodes();
        Stream<Edge> edges = graph.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_nodes  < max_node_capacity);
        assert(count_of_edges  == max_edge_capacity);

        System.out.println(count_of_nodes);
        System.out.println(count_of_edges);
    }

    @Override
    public void normal_estate(){
        System.out.println("\nNormal Graph Estate");

        Stream<Node> nodes = graph.nodes();
        Stream<Edge> edges = graph.edges();

        long count_of_edges = edges.count();
        long count_of_nodes = nodes.count();

        assert(count_of_nodes  < 128);
        assert(count_of_edges  < 1024);

        System.out.println(count_of_nodes);
        System.out.println(count_of_edges);
    }

    @Override
    public void remove_a_node(){
        System.out.println("\nRemove a Node");
        if (number_of_nodes > 1){
            String node_name = "Node " + Integer.toString(number_of_nodes);
            graph.removeNode(node_name);
            number_of_nodes --;
        }
    }

    @Override
    public void add_a_node(){
        System.out.println("\nAdd A Node");
        number_of_nodes ++;
        String node = "Node " + Integer.toString(number_of_nodes);
        graph.addNode(node);
    }

    @Override
    public void clear(){
        System.out.println("\nClear");
        number_of_edges = 0;
        number_of_nodes = 0;
        graph.clear();
    }

    @Override
    public void add_a_edge() {
        System.out.println("\nAdd A Edge");
        if (number_of_nodes > 2) {
            Stream<Edge> edges = graph.edges();
            Boolean fauld = false;

            for (int i = 1; i <= number_of_nodes; i++) {
                for (int j = 1; j <= number_of_nodes; j++) {
                    if (i != j){
                        String node_source = "Node " + i;
                        String node_target = "Node " + j;
                        String edge = "Edge " + number_of_edges;
                        graph.addEdge(edge, node_source, node_target);
                        edges = graph.edges();
                        if (number_of_edges + 1 == edges.count()) {
                            fauld = true;
                            break;
                        }
                    }
                }
                if (fauld) {
                    break;
                }
            }
            number_of_edges ++;
        }
    }
    @Override
    public void remove_a_edge() {
        System.out.println("\nRemove A Edge");
        if (number_of_edges > 1) {
            String edge = "Edge " + Integer.toString(number_of_edges);
            graph.removeEdge(edge);
            number_of_edges--;
        }
    }

    @Override
    public void remove_the_last_node(){
        System.out.println("\nThe Last Node");
        number_of_edges = 0;
        number_of_nodes = 0;
        graph.clear();
    }
}
