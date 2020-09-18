package br.com.mhbp.datastructure.hashtable.lrucache;

public class Node {
    String data;
    Node previous, next;
    Integer id;

    public Node(String data) {
        this.data = data;
    }
}
