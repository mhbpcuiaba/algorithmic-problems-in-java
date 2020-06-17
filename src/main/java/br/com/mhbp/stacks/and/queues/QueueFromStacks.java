package br.com.mhbp.stacks.and.queues;

import java.util.ArrayDeque;

public class QueueFromStacks {

    ArrayDeque<Integer> enqueue = new ArrayDeque();
    ArrayDeque<Integer> dequeue = new ArrayDeque();

    void enqueue(Integer x) {
        enqueue.addFirst(x);
    }

    Integer dequeue() {

        if (dequeue.isEmpty()) {
            //transfers the elements from enqueue to dequeue

            while (!enqueue.isEmpty()) {
                dequeue.addFirst(enqueue.removeFirst());
            }
        }
        return dequeue.removeFirst();
    }
}
