package br.com.mhbp.datastructure.disjointset;

import java.util.stream.IntStream;
//TODO review https://www.geeksforgeeks.org/union-find/
public class DetectCycleUndirectedGraph {


    static class Graph {
        int nVertices, nEdges;
        Edge[] edges;

        public Graph(int nVertices, int nEdges) {
            this.nVertices = nVertices;
            this.nEdges = nEdges;
            edges = new Edge[nEdges];
            for (int i = 0; i < edges.length; i++) {
                edges[i] = new Edge();
            }
        }


    }

    public static boolean hasCycle(Graph g) {
//        int[] parents = IntStream.generate(() -> -1).limit(g.nVertices - 1).toArray();
        int[] parents = IntStream.range(0, g.nVertices - 1).toArray();

        //for each edge check if its vertices belongs to the same subsets, if so there is a cycle
        for (Edge edge : g.edges) {
            int srcRoot = find(edge.src, parents);
            int destRoot = find(edge.dest, parents);

            if (srcRoot == destRoot) return true;
            union(parents, srcRoot, destRoot);
        }

        return false;
    }

    private static void union(int[] parents, int srcRoot, int destRoot) {
        parents[srcRoot] = destRoot;
    }

    private static int find(int vertex, int[] parents) {

        if (parents[vertex] != vertex) parents[vertex] = find(parents[vertex], parents);
        return parents[vertex];
    }

    static class Edge {
        int src, dest;
        public Edge(){}
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main (String[] args)
    {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        // add edge 0-2
        graph.edges[2].src = 0;
        graph.edges[2].dest = 2;

        if (hasCycle(graph))
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
