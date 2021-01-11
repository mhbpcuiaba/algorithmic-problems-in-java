package br.com.mhbp.datastructure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapEntry {
    static int DEFAULT_MAX_CAPACITY = 16;
    static class Entry {
        Integer index, value;

        public Entry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    static List<Integer> kLargestInBinaryHeap(List<Integer> list, int k) {


        PriorityQueue<Entry> candidateMaxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        candidateMaxHeap.add(new Entry(0, list.get(0)));
        List<Integer> resutl = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Entry entry = candidateMaxHeap.remove();
            Integer candidateIndex = entry.index;
            resutl.add(entry.value);

            Integer leftChildIdx = 2 * candidateIndex + 1;
            if (leftChildIdx < list.size())
                candidateMaxHeap.add(new Entry(leftChildIdx, list.get(leftChildIdx)));

            Integer rightChildIdx = 2 * candidateIndex + 2;
            if (leftChildIdx < list.size())
                candidateMaxHeap.add(new Entry(rightChildIdx, list.get(rightChildIdx)));

        }
        return resutl;
    }
}
