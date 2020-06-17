package br.com.mhbp.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphClone {

    static class Vertex {
        int label;
        List<Vertex> neighbours;

        public Vertex(int label) {
            this.label = label;
            neighbours = new ArrayList<>();
        }
    }

    static Vertex cloneGraph(Vertex v) {
        if (v == null) return null;

        HashMap<Vertex, Vertex> vertexMap = new HashMap<>();

        ArrayDeque<Vertex> q = new ArrayDeque<>();
        vertexMap.put(v, new Vertex(v.label));

        q.add(v);

        while (!q.isEmpty()) {
            Vertex cv = q.removeFirst();
            for (Vertex n : cv.neighbours) {

                //if map does not cointain so add current neighbour to the queue
                if (vertexMap.putIfAbsent(n, new Vertex(n.label)) == null)
                    q.add(n);

                vertexMap.get(v).neighbours.add(vertexMap.get(n));
            }

        }

        return vertexMap.get(v);
    }
}
