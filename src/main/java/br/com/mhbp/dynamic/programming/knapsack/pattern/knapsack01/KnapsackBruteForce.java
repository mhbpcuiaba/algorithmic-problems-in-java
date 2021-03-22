package br.com.mhbp.dynamic.programming.knapsack.pattern.knapsack01;

public class KnapsackBruteForce {

    public int solveKnasack(int[] prices, int[] weights, int bagCapacity) {
        return knapsackRcursive(prices, weights, bagCapacity, 0);
    }

    private int knapsackRcursive(int[] prices, int[] weights, int bagCapacity, int currentIndex) {

        if ( bagCapacity <= 0 || currentIndex > weights.length) //base checks, constraints
            return 0;

        int profit1 = 0;
        if ( weights[currentIndex] <= bagCapacity)
            profit1 = knapsackRcursive(prices, weights, bagCapacity - weights[currentIndex], currentIndex + 1);

        int profit2 = knapsackRcursive(prices, weights, bagCapacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }
}
