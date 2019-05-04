package algorithm;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;

public class DijkstraAlgorithm {

    private static final int INFINITY = Integer.MAX_VALUE;

    public static void computeShortestPath(Graph graph, Vertex sourceVertex) {
        graph.getVertices().sort((vertex1, vertex2) -> Integer.compare(vertex1.getName().compareTo(vertex2.getName()), 0));
        int min = 0;
        int[] distance = new int[graph.getVertices().size()];
        Vertex[] initialVertices = new Vertex[graph.getVertices().size()];
        for (int i = 0; i < graph.getVertices().size(); ++i) {
            if (graph.getVertices().get(i).equals(sourceVertex)) {
                min = i;
                distance[i] = 0;
                initialVertices[i] = graph.getVertices().get(i);
            } else {
                distance[i] = INFINITY;
            }
        }

        boolean hasChanged;
        ArrayList<Integer> passed = new ArrayList<>();
        do {
            hasChanged = false;
            for (Arc arc : graph.getArcs()) {
                if (arc.getInitialVertex().equals(graph.getVertices().get(min))) {
                    for (int i = 0; i < graph.getVertices().size(); ++i) {
                        if (graph.getVertices().get(i).equals(arc.getTerminalVertex())) {
                            if (arc.getValue() + distance[min] < distance[i]) {
                                distance[i] = arc.getValue() + distance[min];
                                initialVertices[i] = graph.getVertices().get(min);
                                hasChanged = true;
//                                if (!passed.contains(min)) {
//                                    passed.add(min);
//                                }
                            }
                        }
                    }
                }
            }
            if (!passed.contains(min)) {
                passed.add(min);
            }

            for (int i = 0; i < graph.getVertices().size(); ++i) {
                if (!passed.contains(i)) {
//                    boolean flagA = false;
//                    boolean flagB = false;
//                    for (Arc arc : graph.getArcs()) {
//                        if (arc.getInitialVertex().equals(graph.getVertices().get(i))) {
//                            flagA = true;
//                            for (int j : passed) {
//                                if (arc.getTerminalVertex().equals(graph.getVertices().get(j))) {
//                                    flagB = true;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                    if (flagA && !flagB) {
                    min = i;
                    break;
//                    }
                }
            }

            for (int i = 0; i < graph.getVertices().size(); ++i) {
                if (passed.size() < graph.getVertices().size() - 1) {
                    if (passed.contains(i)) {
                        continue;
                    }
//                    System.out.println("-------------------------------");
//                    System.out.println(min+" "+i);
//                    System.out.println(distance[min] +" "+ distance[i]);
                    if (distance[min] > distance[i]) {
                        min = i;
                        hasChanged = true;
                    }
                }
            }
        } while (hasChanged);

        for (Vertex vertex : graph.getVertices()) {
            System.out.print("  " + vertex + "   ");
        }
        System.out.println();
        for (int k = 0; k < graph.getVertices().size(); ++k) {
            System.out.print(distance[k] + "(" + initialVertices[k] + ")  ");
        }
        System.out.println();
    }

}
