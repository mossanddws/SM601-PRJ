package main;

import algorithm.BellmanAlgorithm;
import algorithm.DijkstraAlgorithm;
import file.TextFile;
import graph.Graph;
import graph.Vertex;

public class Main {
    public static void main(String[] args) {
//        String filePath = "res/test1.txt";
        String filePath = "res/graph4.txt";
//        String filePath = "res/graph9.txt";
        TextFile file = new TextFile(filePath);
        Graph graph = new Graph(file.read());

        boolean[][] values = graph.generateAdjacencyMatrix();
        for (boolean[] line : values) {
            for (boolean value : line) {
                System.out.print(value+"\t");
            }
            System.out.println();
        }

        int[][] values2 = graph.generatedValueMatrix();
        for (int[] line : values2) {
            for (int value : line) {
                System.out.print(value+"\t");
            }
            System.out.println();
        }

        BellmanAlgorithm.computeShortestPath(graph, new Vertex("0"));
        DijkstraAlgorithm.computeShortestPath(graph, new Vertex("0"));
//        System.out.println("____________");
    }
}
