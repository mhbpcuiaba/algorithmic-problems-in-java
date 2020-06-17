package br.com.mhbp.heap;

import java.util.*;

public class OnlineMedian {

    static final int DEAFAULT_INITIAL_CAPACITY = 16;

    static List<Double> onlineMedian(List<Integer> list) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Iterator<Integer> iter = list.iterator();
        ArrayList<Double> result = new ArrayList<>();

        while (iter.hasNext()) {
            minHeap.add(iter.next());
            maxHeap.add(minHeap.remove());

            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            double median = minHeap.size() == maxHeap.size() ? 0.5 * (maxHeap.peek() + minHeap.peek()) : (double) minHeap.peek();
            result.add(median);
        }

        return result;
    }
}
