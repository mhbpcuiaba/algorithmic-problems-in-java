package br.com.mhbp.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchWithStack {

    static Stack<Vertex> stack = new Stack();
    static Stack<Vertex> stack2 = new Stack();

    public static void main(String[] args) {

        System.out.println("With stack");
        Vertex rootVertex = createGraph();
        solveWithStack(rootVertex);
        System.out.println("Recursive now");
        Vertex rootVertex2 = createGraph();
        solveWithRecursion(rootVertex2);
    }

    private static void solveWithStack(Vertex rootVertex) {
        stack2.add(rootVertex);

        while (!stack2.empty()) {
            Vertex v = stack2.pop();
            System.out.println(v.value);

            for (Vertex neighbour : v.neighbours)
                if (!v.visited) {
                    neighbour.visited = true;
                    stack2.push(neighbour);

                }
        }
    }

    private static void solveWithRecursion(Vertex v) {
        System.out.println(v.value);

        for (Vertex neighbour : v.neighbours)
            if (!v.visited) {
                neighbour.visited = true;
                solveWithRecursion(neighbour);
            }
    }

    static class Vertex {
        List<Vertex> neighbours;
        int value;
        boolean visited;

        public Vertex(int value) {
            this.neighbours = new ArrayList();
            this.value = value;
        }
    }

    static void dfs(Vertex v) {

        for (Vertex neighbour : v.neighbours) {
            System.out.println(v.value);
            stack.push(neighbour);
        }
    }

    static Vertex createGraph() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        v1.neighbours.add(v2);
        v1.neighbours.add(v3);
        v1.neighbours.add(v4);

        v2.neighbours.add(v1);
        v2.neighbours.add(v3);
        v2.neighbours.add(v4);

        v3.neighbours.add(v1);
        v3.neighbours.add(v2);
        v3.neighbours.add(v4);

        v4.neighbours.add(v1);
        v4.neighbours.add(v2);
        v4.neighbours.add(v3);

        return v1;
    }
}
