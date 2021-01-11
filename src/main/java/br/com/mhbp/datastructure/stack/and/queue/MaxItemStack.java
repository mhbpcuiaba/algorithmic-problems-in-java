package br.com.mhbp.datastructure.stack.and.queue;

import java.util.LinkedList;

public class MaxItemStack {

    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> maxStack = new LinkedList<>();

    public void push(Integer value) {

        stack.push(value);
        if (maxStack.size() == 0 || maxStack.peek() < value) {
            maxStack.push(value);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int max() {
        return maxStack.peek();
    }

    public Integer pop() {
        maxStack.pop();
        return stack.pop();
    }
}
