package br.com.mhbp.datastructure.stack.and.queue;

import java.util.Stack;

public class QueueWithOneStackUnderHood {
    Stack<Integer> stack = new Stack<>();

    void enqueue(Integer item) {
        stack.add(item);
    }

    // using the call method stack
    Integer denqueue() {
        if (stack.size() == 0) throw new IllegalStateException("it is empty");

        if (stack.size() == 1) return stack.pop();

        Integer item = stack.pop();
        int lastDequeueItem = denqueue();
        enqueue(item);
        return lastDequeueItem;
    }
}
