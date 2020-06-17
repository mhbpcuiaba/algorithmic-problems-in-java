package br.com.mhbp.graph.cycledetection;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    boolean visited;
    boolean beingVisited;
    String value;
    Set<Vertex> neibhours;

    public Vertex(String value) {
        this.value = value;
        neibhours = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "visited=" + visited +
                ", beingVisited=" + beingVisited +
                ", value='" + value + '\'' +
                '}';
    }
}
