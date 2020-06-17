package br.com.mhbp.graph.cycledetection;

import java.util.List;
import java.util.Stack;

public class Main {

    static Stack<Vertex> cycle;
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v4 = new Vertex("v4");

        Vertex v5 = new Vertex("v5");
        Vertex v8 = new Vertex("v8");
        Vertex v9 = new Vertex("v9");

        v1.neibhours.add(v2);

        v2.neibhours.add(v4);
        v2.neibhours.add(v5);

        v4.neibhours.add(v8);
        v4.neibhours.add(v9);

        v5.neibhours.add(v1);
        cycle = new Stack<>();
        dfs(v1);
        System.out.println("Game Over");


    }

    public static void dfs(Vertex v) {

        v.beingVisited = true;
        cycle.push(v);
        for (Vertex neibhour : v.neibhours) {

            if(neibhour.beingVisited) {
                System.out.println("There is a cycle!");
                System.out.println(cycle);
                return;
            }

            if (!neibhour.visited) {
                dfs(neibhour);
            }
        }

        cycle.pop();
        v.beingVisited = false;
        v.visited = true;
    }

    //use for graphs disconnected
    static void detecCycle(List<Vertex> vertexes) {
        for (Vertex vertex : vertexes) {
            if(!vertex.visited)
                dfs(vertex);
        }
    }
}
