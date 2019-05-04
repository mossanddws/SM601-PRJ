package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private List<Arc> arcs;

    public Graph(String[][] strings) {
        vertices = new ArrayList<>();
        arcs = new ArrayList<>();
        inputProcessing(strings);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Arc> getArcs() {
        return arcs;
    }

    public void inputProcessing(String[][] strings) {
        for (String[] strs : strings) {
            if (strs[2] != null) {
                Vertex initialVertex = new Vertex(strs[0]);
                int value = Integer.parseInt(strs[1]);
                Vertex terminalVertex = new Vertex(strs[2]);
                Arc arc = new Arc(initialVertex, value, terminalVertex);
                addVertex(initialVertex);
                addVertex(terminalVertex);
                addArc(arc);
            }
        }
    }

    public boolean[][] generateAdjacencyMatrix() {
        getVertices().sort((vertex1, vertex2) -> Integer.compare(vertex1.getName().compareTo(vertex2.getName()), 0));
        boolean[][] adjacencyMatrix = new boolean[getVertices().size()][getVertices().size()];
        for (int i = 0; i < adjacencyMatrix.length; ++i) {
            for (int j = 0; j < adjacencyMatrix[i].length; ++j) {
                adjacencyMatrix[i][j] = false;
                for (Arc arc : getArcs()) {
                    if (arc.getInitialVertex().getName().equals(getVertices().get(i).getName())
                            && arc.getTerminalVertex().getName().equals(getVertices().get(j).getName())) {
                        adjacencyMatrix[i][j] = true;
                    }
                }
            }
        }
        return adjacencyMatrix;
    }

    public int[][] generatedValueMatrix() {
        getVertices().sort((vertex1, vertex2) -> Integer.compare(vertex1.getName().compareTo(vertex2.getName()), 0));
        int[][] valueMatrix = new int[getVertices().size()][getVertices().size()];
        for (int i = 0; i < valueMatrix.length; ++i) {
            for (int j = 0; j < valueMatrix[i].length; ++j) {
                valueMatrix[i][j] = 0;
                for (Arc arc : getArcs()) {
                    if (arc.getInitialVertex().getName().equals(getVertices().get(i).getName())
                            && arc.getTerminalVertex().getName().equals(getVertices().get(j).getName())) {
                        valueMatrix[i][j] = arc.getValue();
                    }
                }
            }
        }
        return valueMatrix;
    }

    public void addVertex(Vertex vertex) {
        if (!getVertices().contains(vertex)) {
            getVertices().add(vertex);
        }
    }

    public void addArc(Arc arc) {
        if (!getArcs().contains(arc)) {
            getArcs().add(arc);
        }
    }

    public void addLoop(Loop loop) {
        addArc(loop);
    }


}
