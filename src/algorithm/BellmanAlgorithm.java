package algorithm;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;

public class BellmanAlgorithm {

    private static final int INFINITY = Integer.MAX_VALUE;

    public static void computeShortestPath(Graph graph, Vertex sourceVertex) {
        System.out.println("Bellman Algorithm: ");
        graph.getVertices().sort((vertex1, vertex2) -> Integer.compare(vertex1.getName().compareTo(vertex2.getName()), 0));
        int[] distance = new int[graph.getVertices().size()];
        Vertex[] initialVertices = new Vertex[graph.getVertices().size()];
        for (int i = 0; i < graph.getVertices().size(); ++i) {
            if (graph.getVertices().get(i).equals(sourceVertex)) {
                distance[i] = 0;
                initialVertices[i] = graph.getVertices().get(i);
            } else {
                distance[i] = INFINITY;
            }
        }

        int allNegativeArc = 0;
        for (Arc arc : graph.getArcs()) {
            if (arc.getValue() < 0) {
                allNegativeArc += arc.getValue();
            }
        }

        boolean hasChanged;
        boolean hasNegativeWeightCycle = false;
        do {
            hasChanged = false;
            for (int i = 0; i < graph.getVertices().size(); ++i) {
                if (distance[i] != INFINITY) {
                    for (Arc arc : graph.getArcs()) {
                        if (arc.getInitialVertex().equals(graph.getVertices().get(i))) {
                            for (int j = 0; j < graph.getVertices().size(); ++j) {
                                if (graph.getVertices().get(j).equals(arc.getTerminalVertex())) {
                                    if (distance[j] == INFINITY) {
                                        distance[j] = distance[i] + arc.getValue();
                                        initialVertices[j] = graph.getVertices().get(i);
                                        hasChanged = true;
                                    } else {
                                        if (distance[j] > distance[i] + arc.getValue()) {
                                            distance[j] = distance[i] + arc.getValue();
                                            initialVertices[j] = graph.getVertices().get(i);
                                            hasChanged = true;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            for (int d : distance) {
                if (d < allNegativeArc) {
                    hasNegativeWeightCycle = true;
                    break;
                }
            }
        } while (hasChanged && !hasNegativeWeightCycle);

        if (hasNegativeWeightCycle) {
            System.out.println("Has negative cycle !");
            return;
        }

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
