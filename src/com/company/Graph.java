package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private Vertex[] vertexes = new Vertex[10];
    private Edge[][] adjMatrix = new Edge[10][10];
    private int counter = 0;

    public Graph() {
    }

    public void loadChecker() {
        if (counter == vertexes.length) {
            vertexes = Arrays.copyOf(vertexes, (int) (vertexes.length * 1.5 + 1));
            adjMatrix = Arrays.copyOf(adjMatrix, (int) (vertexes.length * 1.5 + 1));
            for (int i = 0; i < counter; i++) {
                adjMatrix[i] = i < counter ? Arrays.copyOf(adjMatrix[i], counter) : new Edge[counter];
            }
        }
    }

    public void addVertex(String name) {
        loadChecker();
        vertexes[counter] = new Vertex(name);
        counter++;
    }

    public void addEdge(int vertex1, int vertex2, int distance) {
        adjMatrix[vertex1][vertex2] = new Edge(vertex1, vertex2, distance);
        adjMatrix[vertex2][vertex1] = new Edge(vertex2, vertex1, distance);
    }

    public void removeEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = null;
        adjMatrix[vertex2][vertex1] = null;
    }

    public List findN(int N) {
        List list = new ArrayList();
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < counter; j++) {
                if (adjMatrix[i][j] != null) {
                    if (adjMatrix[i][j].getWeight() < N) {
                        boolean checker = true;
                        if (!list.isEmpty()) {
                            for (int k = 0; k < list.size(); k++) {
                                if (list.get(k) == vertexes[i].getName()) {
                                    checker = false;
                                    break;
                                }
                            }
                        }
                        if (checker) {
                            list.add(vertexes[i].getName());
                        }
                    }
                }
            }
        }
        return list;
    }
}
