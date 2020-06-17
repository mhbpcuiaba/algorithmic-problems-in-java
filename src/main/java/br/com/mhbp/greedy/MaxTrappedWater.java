package br.com.mhbp.greedy;

import java.util.List;

public class MaxTrappedWater {

    static int getMaxTrappedWater(List<Integer> heights) {
        int left = 0, right = heights.size() - 1, maxWater = 0;

        while (left < right) {
            Integer lHeight = heights.get(left);
            Integer rHeight = heights.get(right);

            int width = right - left;
            maxWater = Math.max(maxWater, width * Math.min(lHeight, rHeight));

            if (lHeight > rHeight) {
                left++;
            } else {
                right--;
            }

        }

        return maxWater;
    }
}
