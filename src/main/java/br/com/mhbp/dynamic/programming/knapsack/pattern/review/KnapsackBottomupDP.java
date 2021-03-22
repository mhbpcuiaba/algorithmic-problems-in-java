package br.com.mhbp.dynamic.programming.knapsack.pattern.review;

public class KnapsackBottomupDP {

    public static void main(String[] args) {
        KnapsackBottomupDP ks = new KnapsackBottomupDP();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];

        for (int i = 0; i < profits.length; i++)
            dp[i][0] = 0;

        for (int i = 1; i < capacity; i++)
            if (weights[0] <= i)
                dp[0][i] = profits[0];

        for (int i = 1; i < profits.length; i++)
            for (int j = 0; j < capacity + 1; j++)
                dp[i][j] = Math.max(dp[i - 1][j], profits[i] +   dp[i -1][j - weights[i]]); // dp[i][j]=  max(exclude item, include item)

        return dp[profits.length - 1] [ capacity];
    }
}
