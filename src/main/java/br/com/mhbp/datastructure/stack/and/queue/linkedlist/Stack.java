package br.com.mhbp.datastructure.stack.and.queue.linkedlist;

//it has a better time complexity, but we have a greater space complexity
public class Stack<T extends Comparable<T>> {

    Node<T> root;
    int count;

    void push(T newData) {
        count++;
        Node<T> tNode = new Node<>(newData);

        if (root != null) {
            tNode.next = root;
        }
        root = tNode;
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return root == null;
    }

    T peek() {
        return root == null ? null : root.data;
    }

    T pop() {
        Node<T> poped = root;
        root = root.next;
        count--;
        return poped.data;
    }
}
