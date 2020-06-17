package br.com.mhbp.dynamic.programming.partition_set;

public class SubsetSumEqualToGivenNumberBottomUp {

    public static boolean calculate(int[] array, int targetSum) {
        boolean[][] dp = new boolean[array.length][targetSum + 1]; // we add one cause we need a special column to represent empty sum


        for (int i = 0; i < array.length; i++) {
            dp[i][0] = true;

        }

        for (int i = 0; i < targetSum; i++) {
            if (array[0] >= i) {
                dp[0][i] = true;

            }
        }

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < targetSum + 1; j++) {

                 if (dp[i - 1][j]) { //if we can get the sum without the number at index 'i'
                     dp[i ][j] = true;
                 } else if (targetSum >= array[i]) {
                     /*
                     else include the number and see if we can find a subset to get the remaining sum
                      */
                     dp[i ][j] = dp[i ][j - array[i]];
                 }
            }
        }

        return dp[array.length - 1][targetSum];
    }
}
