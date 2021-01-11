package br.com.mhbp.datastructure.stack.and.queue;

import java.util.ArrayDeque;

public class QueueWithMax {
    ArrayDeque<Integer> array = new ArrayDeque();
    ArrayDeque<Integer> candidatesForMax = new ArrayDeque();

    void enqueue(Integer x) {
        array.addLast(x);

        while (!candidatesForMax.isEmpty() && candidatesForMax.peekLast() < x) candidatesForMax.removeLast();
        candidatesForMax.addLast(x);
    }

    Integer dequeue() {
        Integer result = array.removeFirst();

        if (result.equals(candidatesForMax.peekFirst())) {
            candidatesForMax.removeLast();
        }
        return result;
    }
}
