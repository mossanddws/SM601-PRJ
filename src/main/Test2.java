package main;

import algorithm.BellmanAlgorithm;
import file.TextFile;
import graph.Graph;
import graph.Vertex;

public class Test2 {
    public Test2() {
        String filePath = "res/graph2.txt";
        TextFile file = new TextFile(filePath);
        Graph graph = new Graph(file.read());

        boolean[][] values = graph.generateAdjacencyMatrix();
        for (boolean[] line : values) {
            for (boolean value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        int[][] values2 = graph.generatedValueMatrix();
        for (int[] line : values2) {
            for (int value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        BellmanAlgorithm.computeShortestPath(graph, new Vertex("0"));
    }
}
