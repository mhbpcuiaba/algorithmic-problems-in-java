package br.com.mhbp.dynamic.programming.knapsack.review;

public class KnapsackBottomupWithLinearSpaceComplexity {

    public static void main(String[] args) {
        KnapsackBottomupWithLinearSpaceComplexity ks = new KnapsackBottomupWithLinearSpaceComplexity();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

     int solveKnapsackWthOneArrayAux(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        // if we have only one weight, we will take it if it is not more than the
        // capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[c - weights[i]];
                // exclude the item
                profit2 = dp[c];
                // take maximum
                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) return 0;

        int n = profits.length;
        Integer[][] dp = new Integer[2][capacity + 1];

        for (int i = 0; i < capacity; i++)
            if (weights[0] <= i)
                dp[0][i] = profits[i];

        for (int i = 1; i < n; i++)
            for (int k = 0; k <= capacity; k++) {
                int profitIncludingItem = (weights[i] <= k) ? 0 : profits[i] + dp[ (i - 1) % 2 ][k - weights[i]];
                int profitExcludingItem = dp[ (i - 1) % 2][k];
                dp[i%2][k] = Math.max(profitIncludingItem, profitExcludingItem);
            }
        printSelectedElements(dp, weights, profits, capacity);
        return dp[ (n - 1) % 2][capacity];
    }

    private void printSelectedElements(Integer dp[][], int[] weights, int[] profits, int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length-1][capacity];
        for(int i=weights.length-1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if(totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }
}
