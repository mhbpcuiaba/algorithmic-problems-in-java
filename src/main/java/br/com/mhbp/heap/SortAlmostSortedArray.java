package br.com.mhbp.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

    static List<Integer> sortAproxSortedData(List<Integer> list, int k) {
        Iterator<Integer> iterator = list.iterator();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k && iterator.hasNext(); i++) {
            minHeap.add(iterator.next());
        }

        ArrayList<Integer> result = new ArrayList<>();

        //now for every new element, add it to minHeap and extract the min and add it to the result
        while (iterator.hasNext()) {
            minHeap.add(iterator.next());
            result.add(minHeap.remove());
        }


        while (!minHeap.isEmpty()) result.add(minHeap.remove());

        return result;
    }
}
