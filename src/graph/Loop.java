package graph;

public class Loop extends Arc {

    public Loop(int value, Vertex vertex) {
        super(vertex, value, vertex);
    }

}
