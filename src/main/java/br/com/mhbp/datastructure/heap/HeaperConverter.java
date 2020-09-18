package br.com.mhbp.datastructure.heap;

public class HeaperConverter {

    int[] heap;

    public HeaperConverter(int[] heap) {
        this.heap = heap;
    }


    int[] transform() {
        /** we do not have to consider leaf nodes
         * thats why last node we have to consider has index (length-2)/2
         * */
        for (int i = (heap.length - 2)/2; i >= 0 ; i--) {
            heapify(i);
        }

        return heap;
    }

    private void heapify(int index) {

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (heap[smallest] > heap[leftChildIndex])
            smallest = leftChildIndex;

        if (heap[smallest] > heap[rightChildIndex])
            smallest = rightChildIndex;

        if (smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }
    }

    private void swap(int smallest, int index) {
        int tmp = heap[smallest];
        heap[smallest] = heap[index];
        heap[index] = tmp;
    }
}
