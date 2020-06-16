package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 3, 4);
        graph.addEdge(1, 5, 5);
        graph.addEdge(3, 5, 7);
        graph.addEdge(4, 5, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(2, 6, 10);
        graph.addEdge(4, 6, 8);
        graph.addEdge(1, 2, 6);
        List list = graph.findN(5);
        System.out.println(list);
    }
}
