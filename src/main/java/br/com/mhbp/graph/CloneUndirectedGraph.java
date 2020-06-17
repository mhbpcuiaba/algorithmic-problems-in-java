package br.com.mhbp.graph;

import java.util.*;

//https://github.com/bephrem1/backtobackswe/tree/master/Graphs
public class CloneUndirectedGraph {

    public static void main(String[] args) {

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        v1.neighbours.add(v2);
        v1.neighbours.add(v3);

        v2.neighbours.add(v4);
        v2.neighbours.add(v5);
        v4.neighbours.add(v5);

        Vertex rootVertexCloned = cloneUndirectedGraph(v1);
    }

    private static Vertex cloneUndirectedGraph(Vertex originalRootVertex) {

        LinkedList<Vertex> visitedVertices = new LinkedList<>();
//        LinkedList<Vertex> clonedVertices = new LinkedList<>();
        Map<Vertex, Vertex> vertexMap = new HashMap<>();//???? why Map????

        visitedVertices.add(originalRootVertex);
        Vertex rootVertexCloned = cloneVertex(originalRootVertex);
//        clonedVertices.add(rootVertexCloned);
        vertexMap.put(originalRootVertex, rootVertexCloned);

        while (!visitedVertices.isEmpty()) {
//            Vertex visited = visitedVertices.pop();
            Vertex visited = visitedVertices.remove();// why remove instead of pop????

            if (!visited.neighbours.isEmpty()) {
                visited.neighbours.forEach( neighbour -> {

                    if (!vertexMap.containsKey(neighbour)) {
                        visitedVertices.add(neighbour);
                        vertexMap.put(visited, neighbour);
//                        clonedVertices.add(cloneVertex(neighbour));
                    }

                });
            }
        }

        return vertexMap.get(originalRootVertex);
    }

    private static Vertex cloneVertex(Vertex v) {
        Vertex cloned = new Vertex(v.value);
        return cloned;
    }

    static class Vertex {
        int value;
        List<Vertex> neighbours;

        public Vertex(int value) {
            this.value = value;
            this.neighbours = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "value=" + value +
                    ", neighbours=" + neighbours +
                    '}';
        }
    }
}
