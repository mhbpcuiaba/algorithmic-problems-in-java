package br.com.mhbp.datastructure.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    private double[] findSlidingWindowMedian(int[] nums, int k) {
        int sizeOfSubarrayWithSizeK = nums.length - (k - 1);
        double[] result = new double[sizeOfSubarrayWithSizeK]; //

        for (int i = 0; i < nums.length; i++) {

            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }

            rebalanceHeaps();

            if (i - k + 1 >= 0) { //if we have at least 'k' elemens in the sliding window

                if( maxHeap.size() == minHeap.size()) { //add the median to the result array
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }

                int elementToBeRemoved = nums[i - k + 1];

                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }

                rebalanceHeaps();
            }
        }
        return result;
    }

    private void rebalanceHeaps() {

        if (maxHeap.size() > minHeap.size() + 1) { // max is bigger than min
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) { // min is bigger than max
            maxHeap.add(minHeap.poll());
        }
    }


    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
