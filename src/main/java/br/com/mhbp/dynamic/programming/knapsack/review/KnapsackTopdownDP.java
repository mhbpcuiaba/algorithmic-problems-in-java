package br.com.mhbp.dynamic.programming.knapsack.review;


/**
 *  'N' is the number of items
 *  'C' is the knapsack capacity
 *  space complexity O(C * N)
 *  time complexity
 */
public class KnapsackTopdownDP {


    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return knapsackRecursive(profits, weights, capacity, 0, dp);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex, Integer[][] dp) {
        if (currentIndex == profits.length || capacity == 0) return 0;

        if (dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }

        int profitIncludingCurrentItem = 0;
        if (capacity >= weights[currentIndex]) {
            profitIncludingCurrentItem = dp[currentIndex][capacity] = knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1, dp);
        }
        int profitSkippingCurrentItem = knapsackRecursive(profits, weights, capacity, currentIndex + 1, dp);
        return dp[currentIndex][capacity] = Math.max(profitIncludingCurrentItem, profitSkippingCurrentItem);
    }
}
