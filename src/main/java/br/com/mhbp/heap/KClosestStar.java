package br.com.mhbp.heap;

import java.util.*;

public class KClosestStar {

    static class Star implements Comparable<Star> {

        double x, y, z;

        public Star(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }
        @Override
        public int compareTo(Star star) {
            return Double.compare(distance(), star.distance());
        }
    }

    static List<Star> findClosestkStarsd(Iterator<Star> stars, int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        /**
         * add each star to the max-heap. If the max-heap size exceeds k, remove the maximum element from the max-heap
         */
        while (stars.hasNext()) {
            maxHeap.add(stars.next());

            if (maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }


        List<Star> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.remove());
        }

        return result;
    }
}
