package br.com.mhbp.stacks.and.queues;

import java.util.Arrays;
import java.util.Collections;

public class CircularQueue {

    private int head, tail, numQueueElements;
    static final int SCALE_FACTOR = 2;
    Integer[] array;

    public CircularQueue(int capcacity) {
        array = new Integer[capcacity];
    }

    public int size() {
        return numQueueElements;
    }

    public void enqueue(Integer x) {

        if (numQueueElements == array.length) { //needs to resize
            Collections.rotate(Arrays.asList(array), -head);
            //reset head and tail
            head = 0;
            tail = numQueueElements;
            array = Arrays.copyOf(array, numQueueElements * SCALE_FACTOR);
        }

        array[tail] = x;
        tail = (tail + 1) % array.length;
        numQueueElements++;
    }

    public Integer dequeue() {
        --numQueueElements;
        Integer result = array[head];
        head = (head + 1) % array.length;
        return result;
    }
}
