package graph;

public class Arc {
    private Vertex initialVertex;
    private int value;
    private Vertex terminalVertex;

    public Arc(Vertex initialVertex, int value, Vertex terminalVertex) {
        this.value = value;
        this.initialVertex = initialVertex;
        this.terminalVertex = terminalVertex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vertex getInitialVertex() {
        return initialVertex;
    }

    public void setInitialVertex(Vertex initialVertex) {
        this.initialVertex = initialVertex;
    }

    public Vertex getTerminalVertex() {
        return terminalVertex;
    }

    public void setTerminalVertex(Vertex terminalVertex) {
        this.terminalVertex = terminalVertex;
    }

    @Override
    public boolean equals(Object obj) {
        Arc arc = (Arc) obj;
        if (getInitialVertex().equals(arc.getInitialVertex()) && getValue() == arc.getValue() && getTerminalVertex().equals(arc.getTerminalVertex())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Arc{" +
                "initialVertex=" + initialVertex +
                ", value=" + value +
                ", terminalVertex=" + terminalVertex +
                '}';
    }
}
