package br.com.mhbp.graph.dfs;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {
}

class Node {
    int value;
    Set<Node> neighbours;
    boolean visited =false;

    public Node(int value) {
        this.value = value;
        neighbours =new HashSet<Node>();
    }
}