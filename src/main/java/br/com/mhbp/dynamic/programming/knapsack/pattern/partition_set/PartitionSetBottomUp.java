package br.com.mhbp.dynamic.programming.knapsack.pattern.partition_set;

import java.util.Arrays;

public class PartitionSetBottomUp {


    public static boolean canPartition(int[] num) {
        int sum = Arrays.stream(num).sum();
        if (num.length == 0 || sum % 2 == 1)
            return false; //we cannot partition odd integer sum equally or an empty array

        int halfSum = sum / 2;
        Boolean[][] dp = new Boolean[num.length][ halfSum + 1];


        //Fill first Column
        //poplate the sum = 0 column, as we can always have '0' sum without including any element
        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        //Fill first Row

        for (int i = 1; i <= halfSum; i++) {
            dp[0][i] = i == num[0] ? true:false;
        }


        for (int i = 1; i < num.length ; i++) {
            for (int s = 0; s < halfSum; s++) {

                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i][s - num[i]];
                }
            }

        }
        return dp[num.length - 1] [halfSum];
    }


}
