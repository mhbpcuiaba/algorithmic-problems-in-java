package br.com.mhbp.graph.topological;

import java.util.Stack;

//dfs uses recursion gracefully
public class TopologicalOrdering {

    Stack<Vertex> stack;

    public TopologicalOrdering() {
        stack = new Stack<>();
    }


    public void dfs(Vertex v) {
        v.visited = true;

        for (int i = 0; i < v.neighbours.size(); i++) {

            if (!v.visited) {
                dfs(v);
            }
        }
        stack.push(v);
    }

    public Stack<Vertex> getStack() {
        return stack;
    }
}
