package br.com.mhbp.dynamic.programming.knapsack.pattern.knapsack01;

public class Knapsack_O_n_Space {

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || profits.length == 0 && profits.length != weights.length) return 0;

        int n = profits.length;
        int[][] dp = new int[2] [capacity + 1];

        for (int c = 0; c <= capacity ; c++) {

            if (weights[0] < capacity)
                dp[0][c] = dp[1][c] = profits[0];
        }

        for (int i = 1; i < n; i++) {
            for (int c = 0; c <= capacity ; c++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= c)
                    profit1 = profits[i] + dp [ (i - 1) % 2] [c - weights[i]];

                profit2 = dp[ (i - 1) % 2] [c];
                dp[i % 2] [c] = Math.max(profit1, profit2);
            }
        }

        return dp[ (n - 1) % 2] [capacity];
    }
}
