package br.com.mhbp.graph.dfs;

import java.util.List;

public class DeadlockDetection {
    enum Color { WHITE, GRAY, BLACK }
    static class Vertex {
        Color color;
        List<Vertex> neighbours;
    }

    static boolean isDeadlocked(List<Vertex> graph) {
        return graph.stream().anyMatch(
                v -> v.color == Color.WHITE && hasCycle(v)
        );
    }

    private static boolean hasCycle(Vertex v) {
        if (v.color == Color.GRAY)
            return true;//gray == discovered

        v.color = Color.GRAY;//mark as discovered

        //for all neighbours that is not processed check if has cycle
        if (v.neighbours.stream().anyMatch( n -> n.color != Color.BLACK && hasCycle(n)))
            return true;

        v.color = Color.BLACK;//already processed
        return false;
    }
}
