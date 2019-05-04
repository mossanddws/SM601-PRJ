package main;

import algorithm.BellmanAlgorithm;
import algorithm.DijkstraAlgorithm;
import file.TextFile;
import graph.Graph;
import graph.Vertex;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------Test--------------------");
        String filePath = "res/test1.txt";
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

        System.out.println("--------------------Graph 1--------------------");
        Test1 test1 = new Test1();
        System.out.println("--------------------Graph 2--------------------");
        Test2 test2 = new Test2();
        System.out.println("--------------------Graph 3--------------------");
        Test3 test3 = new Test3();
        System.out.println("--------------------Graph 4--------------------");
        Test4 test4 = new Test4();
        System.out.println("--------------------Graph 5--------------------");
        Test5 test5 = new Test5();
        System.out.println("--------------------Graph 6--------------------");
        Test6 test6 = new Test6();
        System.out.println("--------------------Graph 7--------------------");
        Test7 test7 = new Test7();
        System.out.println("--------------------Graph 8--------------------");
        Test8 test8 = new Test8();
        System.out.println("--------------------Graph 9--------------------");
        Test9 test9 = new Test9();
        System.out.println("--------------------Graph 10--------------------");
        Test10 test10 = new Test10();

    }
}
