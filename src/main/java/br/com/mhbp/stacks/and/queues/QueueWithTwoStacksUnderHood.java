package br.com.mhbp.stacks.and.queues;

import java.util.Stack;

public class QueueWithTwoStacksUnderHood {

    Stack<Integer> stackEnqueue = new Stack<>();
    Stack<Integer> stackDenqueue = new Stack<>();

    void enqueue(Integer value) {
        stackEnqueue.push(value);
    }

    Integer dequeue() {

        if (stackEnqueue.isEmpty() && stackDenqueue.isEmpty()) {
            throw new IllegalStateException("Stacks are empty...");
        }

        if (stackDenqueue.isEmpty()) {
            while (stackEnqueue.isEmpty()) {
                stackDenqueue.push(stackEnqueue.pop());
            }
        }
        return stackDenqueue.pop();
    }
}
