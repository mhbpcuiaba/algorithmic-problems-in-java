package br.com.mhbp.graph.topological;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public String value;
    public List<Vertex> neighbours = new ArrayList<>();
    public boolean visited;

    public Vertex(String data) {
        this.value = data;
    }

    public void addNeighbours(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {

        return value;
    }
}
