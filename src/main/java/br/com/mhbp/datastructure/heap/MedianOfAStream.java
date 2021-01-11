package br.com.mhbp.datastructure.heap;

import java.util.PriorityQueue;

public class MedianOfAStream {

    /*
    * How to create min and max heap depends on the comparator function
    *
    * */
    PriorityQueue<Integer> maxHeapForFirstHalf = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeapForSecondHalf = new PriorityQueue<>((a, b) -> a - b);

    public void insertNum(int num) {

        if (maxHeapForFirstHalf.isEmpty() || maxHeapForFirstHalf.peek() >= num)
            maxHeapForFirstHalf.add(num);
        else
            minHeapForSecondHalf.add(num);


        if (maxHeapForFirstHalf.size() > minHeapForSecondHalf.size() + 1)
            minHeapForSecondHalf.add(maxHeapForFirstHalf.poll());
        else if (maxHeapForFirstHalf.size() < minHeapForSecondHalf.size())
            maxHeapForFirstHalf.add(minHeapForSecondHalf.poll());
    }

    public double findMedian() {
        if (maxHeapForFirstHalf.size() == minHeapForSecondHalf.size()) {
            return maxHeapForFirstHalf.peek() / 2.0 + minHeapForSecondHalf.peek() / 2.0;
        }
        return maxHeapForFirstHalf.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
