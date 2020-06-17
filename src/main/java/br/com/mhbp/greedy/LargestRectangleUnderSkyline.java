package br.com.mhbp.greedy;

import java.util.ArrayDeque;
import java.util.List;

public class LargestRectangleUnderSkyline {

    static int calculateLaregestRectangle(List<Integer> heights) {
        ArrayDeque<Integer> pillarIndices = new ArrayDeque<>();
        int maxRectangleArea = 0;

        for (int i = 0; i < heights.size(); i++) {


            while (!pillarIndices.isEmpty() && isNewPillarOrReachEnd(heights, i, pillarIndices.peekFirst())) {

                int height = heights.get(pillarIndices.removeFirst());
                int width = pillarIndices.isEmpty() ? i : i - pillarIndices.peekFirst() - 1;
                maxRectangleArea = Math.max(maxRectangleArea, height * width);

            }

            pillarIndices.addFirst(i);
        }

        return maxRectangleArea;
    }

    static boolean isNewPillarOrReachEnd(List<Integer> heights, int currIdx, int lastPillarIdx) {
     return currIdx < heights.size() ? heights.get(currIdx) <= heights.get(lastPillarIdx):true;
    }
}
