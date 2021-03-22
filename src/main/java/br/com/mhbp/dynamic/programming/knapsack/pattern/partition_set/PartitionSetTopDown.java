package br.com.mhbp.dynamic.programming.knapsack.pattern.partition_set;

import java.util.Arrays;

public class PartitionSetTopDown {



    static boolean canPartition(int[] num) {
        int sum = Arrays.stream(num).sum();

        if (sum % 2 == 1) return false;

        /*
            rows == num.length
            cols == sum/2 + 1
         */
        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
        return canPartitionRecursive(dp, num, sum/2, 0);
    }

    // time and space complexity of O(N * S), 'N' represents total numbers and 'S' is the total sum of all the numbers
    private static boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {

        if (sum == 0) return true;

        if (currentIndex >= num.length) return false;

        if (dp[currentIndex][sum] == null ) { //if it is not calculated yet, then do it

            if (sum  >= num[currentIndex]) {
                if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1) ) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
        }

        return dp[currentIndex][sum];
    }
}
