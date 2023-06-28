package org.example;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Graph;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Graph graph = new SingleGraph("Graph 1", true, true);

        graph.addNode("Node 1");
        graph.addNode("Node 2");
        graph.addNode("Node 3");


        graph.display();

    }
}