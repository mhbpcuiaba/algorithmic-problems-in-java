package br.com.mhbp.datastructure.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArrayMerge {
    static class ArrayEntry {
        Integer value;
        Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        ArrayList<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.value, e2.value));

        for (int i = 0; i < iters.size(); i++) {

            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);

            if (iters.get(headEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId));
            }
        }
        return result;
    }
}
