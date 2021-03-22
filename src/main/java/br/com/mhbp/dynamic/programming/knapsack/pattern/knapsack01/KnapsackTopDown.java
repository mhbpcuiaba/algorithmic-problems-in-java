package br.com.mhbp.dynamic.programming.knapsack.pattern.knapsack01;

public class KnapsackTopDown {

    public static void solveKnapsack(int[] weights, int[] prices, int capacity) {
        Integer[][] weitghsPrices = new Integer[prices.length][capacity + 1];//  number of items vs capacity + 1
        int result = solveKnapsackRecursive( weitghsPrices, weights, prices, capacity, 0);
    }

    // O (N * C) => N -> number of itmes, C is the knapsack capacitu
    private static int solveKnapsackRecursive(Integer[][] weitghsPrices, int[] weights, int[] prices, int capacity, int currentIndex) {

        if (capacity <= 0 || currentIndex > weights.length)   return 0;


        if (weitghsPrices[currentIndex][capacity] != null)
            return weitghsPrices[currentIndex][capacity];



        int profit1 = 0;
        if (weights[currentIndex] < capacity)
            profit1 = solveKnapsackRecursive(weitghsPrices, weights, prices, capacity - weights[currentIndex], currentIndex + 1);

        int profit2 =solveKnapsackRecursive(weitghsPrices, weights, prices, capacity, currentIndex + 1);

        weitghsPrices[currentIndex][capacity] = Math.max(profit1, profit2);
        return weitghsPrices[currentIndex][capacity];
    }
}
