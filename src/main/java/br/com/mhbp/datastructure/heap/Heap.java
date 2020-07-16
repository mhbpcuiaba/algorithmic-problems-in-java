package br.com.mhbp.datastructure.heap;

import java.util.Arrays;

public class Heap {

    int[] array;
    int size;
    static final int CAPACITY = 100;

    public Heap() {
        this.array = new int[CAPACITY];
    }

    public void insert(int item) {
        if (isFull()) throw new IllegalStateException("heap is full!!!");

        /**
         * the main idea here is we insert in the end of array and then call fixup to compare recursively the child with its parent until child is les or equal the parent
         */
        array[size++] = item;
        fixUp(size - 1);
    }

    public boolean isMinHeap(int[] array) {
        int indexLastItemNonLeaf = (array.length - 2) / 2;

        for (int i = 0; i < indexLastItemNonLeaf; i++)
            if (array[i] > array[i * 2 + 1] || array[i] > array[i * 2 + 2])
                return false;

        return true;
    }

    public boolean isvalidMaxHeap(int[] array) {
        return isvalidMaxHeap(array, 0);
    }

    public boolean isvalidMaxHeap(int[] array, int nodeIndex) {
        if (nodeIndex >= array.length) return true;

        int leftChildIndex = nodeIndex * 2 + 1;
        int rightChildIndex = nodeIndex * 2 + 2;

        if (array[nodeIndex] < array[leftChildIndex] || array[nodeIndex] < array[rightChildIndex]) return false;

        boolean leftChildIsHeap = leftChildIndex < array.length ? isvalidMaxHeap(array, leftChildIndex) : true;
        boolean rightChildIsHeap = rightChildIndex < array.length ? isvalidMaxHeap(array, leftChildIndex) : true;
        return leftChildIsHeap && rightChildIsHeap;
    }

    public int poll() {
        if (isEmpty()) throw new IllegalStateException("heap is empty!!!");
        int max = getMax();
        swap(0, size - 1);
        size--;
        fixDown(0);
        return max;
    }

    public void heapsort() {

        for (int i = 0; i < size; i++) {
            int max = poll();
            System.out.print(max + " ");
        }
    }

    private void fixDown(int itemIndex) {
        int leftChildIndex = itemIndex * 2 + 1;
        int rightChildIndex = itemIndex * 2 + 2;

        int indexLargest = itemIndex;

        if (leftChildIndex < array.length && array[itemIndex] < array[leftChildIndex]) {
            indexLargest = leftChildIndex;
        }

        if (rightChildIndex < array.length && array[itemIndex] < array[rightChildIndex]) {
            indexLargest = rightChildIndex;
        }

        if (indexLargest != itemIndex) {
            swap(indexLargest, itemIndex);
            fixDown(indexLargest);
        }
    }

    private int getMax() {
        return array[size];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void fixUp(int index) {
        if (index == 0) return;

        int parentIndex = (index - 1) / 2;//calculate parentIndex

        /**
        while the index > 0 means until we consider all the items "above" the one we inserted.
        if a child node is greater than its parent then swap node's value
         */
        if (index > 0 && array[index] > array[parentIndex]) {
            swap(index, parentIndex);
            fixUp(parentIndex);
        }

    }

    private void swap(int index, int parentIndex) {
        int tmp = array[index];
        array[index] = array[parentIndex];
        array[parentIndex] = tmp;
    }

    private boolean isFull() {
        return size == array.length;
    }
}
