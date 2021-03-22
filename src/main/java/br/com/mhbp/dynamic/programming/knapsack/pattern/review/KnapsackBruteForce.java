package br.com.mhbp.dynamic.programming.knapsack.pattern.review;

public class KnapsackBruteForce {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (currentIndex == profits.length || capacity == 0) return 0;

        int profitIncludingCurrentItem = 0;
        if (capacity >= weights[currentIndex]) {
            profitIncludingCurrentItem = knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }
        int profitSkippingCurrentItem = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profitIncludingCurrentItem, profitSkippingCurrentItem);
    }
}
