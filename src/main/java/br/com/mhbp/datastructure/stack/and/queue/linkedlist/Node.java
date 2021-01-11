package br.com.mhbp.datastructure.stack.and.queue.linkedlist;

public class Node<T extends Comparable<T>> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

}
