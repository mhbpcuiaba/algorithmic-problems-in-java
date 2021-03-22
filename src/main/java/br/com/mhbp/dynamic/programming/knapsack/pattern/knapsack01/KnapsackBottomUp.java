package br.com.mhbp.dynamic.programming.knapsack.pattern.knapsack01;

public class KnapsackBottomUp {

    //assume taht are valid
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {


        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        //if we have only one weight, we will take it if is not more than the capacity
        for (int i = 0; i < capacity; i++) {

            if (weights[i] <= capacity) {
                dp[0][i] = profits[i];
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < capacity; i++) {
                int profit1 = dp[ j - 1] [i];
                int profit2 = (weights[j] < capacity) ? profits[j] + dp[j - 1][weights[i]] : 0;// check if can add current item or not
                dp[j][i] = Math.max(profit1, profit2);
            }
        }

        return dp[n -1][capacity];
    }

    private void printSelectedElements(int[][] dp, int[] weights, int[] prices, int capacity) {
        int totalProfit = dp [weights.length - 1][capacity];

        for (int i = weights.length - 1; i > 0; i--) {

            if (totalProfit != dp[i - 1] [capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= prices[i];
            }

        }
        if (totalProfit != 0) System.out.println(" " + weights[0]);
        System.out.println();
    }
}
