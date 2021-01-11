package br.com.mhbp.datastructure.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {

    List<String> topK(int k, Iterator<String> iter) {

        PriorityQueue<String> minHeap = new PriorityQueue<>(k, (e1, e2) -> Integer.compare(e1.length(), e2.length()));

        while (iter.hasNext()) {
            minHeap.add(iter.next());

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }
}
