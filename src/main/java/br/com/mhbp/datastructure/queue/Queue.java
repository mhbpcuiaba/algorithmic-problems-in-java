package br.com.mhbp.datastructure.queue;

public class Queue<T extends Comparable<T>> {
    Node<T> firstNode;
    Node<T> lastNode;
    int counts;

    public boolean isEmpty() {
        return counts == 0;
    }

    public int size() {
        return counts;
    }

    public void enqueue(T data) {
        Node<T> oldLastNode = lastNode;
        lastNode = new Node(data);

        if (isEmpty()) {
            firstNode = lastNode;
        } else {
            oldLastNode.next = lastNode;
        }
        counts++;
    }

    public T dequeue() {
        if(counts== 0) throw new IllegalStateException("Queue is empty");
        counts--;
        T data = firstNode.data;
        firstNode = firstNode.next;

        if(isEmpty()) {
            lastNode = null;
        }
        return data;
    }
}
