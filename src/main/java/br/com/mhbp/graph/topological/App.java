package br.com.mhbp.graph.topological;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");


        v3.addNeighbours(v4);

        v4.addNeighbours(v2);

        v5.addNeighbours(v1);
        v5.addNeighbours(v2);


        v6.addNeighbours(v1);
        v6.addNeighbours(v3);



//      List<Vertex> graph = Stream.of(v1, v2, v3, v4, v5, v6, v7).collect(Collectors.toList());
        List<Vertex> graph = Arrays.asList(v1, v2, v3, v4, v5, v6, v7);

        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
        for (Vertex vertex : graph) {

            if (!vertex.visited) {
                topologicalOrdering.dfs(vertex);
            }
        }


        Stack<Vertex> stack = topologicalOrdering.getStack();
        while(!stack.empty()) {
            Vertex v = stack.pop();
            System.out.println("Vertx: " + v.value);
        }


    }
}

/*
*
*
*   1 -> a (right)
*   2 -> a(wrong)**, c(wrong), B(right)
*   3- > a(wrong), e(wrong), b(right)
*   4 -> c(wrong), a(wrong), d(right)
*   5 ->  a & b, wrong, all, (wrong), abcd
*   6 -> a,b,c,d (right)
*   7 -> false (wrong) *, true
*   8 ->  c,d (right)
*   9 -> a(right)
*  10 -> a(right)
*
* */