package com.example;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int[][] matrix;

    private List<Node> nodes;

    public Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(int src, int dest) {
        return matrix[src][dest] == 1;
    }

    public void print() {
        System.out.print("  ");

        for (Node node : nodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {

            System.out.print(nodes.get(i).data + " ");

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
