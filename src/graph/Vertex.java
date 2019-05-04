package graph;

public class Vertex {
    private String name;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Vertex) obj).getName());
    }

    @Override
    public String toString() {
//        return "Vertex{" +
//                "name='" + name + '\'' +
//                '}';
        return getName();
    }
}
