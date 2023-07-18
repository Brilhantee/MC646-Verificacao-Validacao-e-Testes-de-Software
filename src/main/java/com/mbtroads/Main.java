package com.mbtroads;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.*;

public class Main {
    public static void main(final String[] args) {
        Path path = new Path();
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Graph 1");
        Node node = graph.addNode("Node 1");
        Node node2 = graph.addNode("Node 2");
        Node node3 = graph.addNode("Node 3");
        Node node4 = graph.addNode("Node 4");
        Node node5 = graph.addNode("Node 5");
        Edge edge = graph.addEdge("Edge 1", "Node 1", "Node 2");
        Edge edge2 = graph.addEdge("Edge 2", "Node 2", "Node 3");
        Edge edge3 = graph.addEdge("Edge 3", "Node 3", "Node 4");
        Edge edge4 = graph.addEdge("Edge 4", "Node 4", "Node 5");


        path.add(node2,edge);
        System.out.println(path.toString());

    }
}
