package br.com.mhbp.algoexpert;

public class MaxSumInConfigurationBruteForceSolution {

    int maxSum(int[] arr, int n) {
        int result = Integer.MIN_VALUE;

        /**
        Consider rotation beginning with i for all possible values of i
         */
        for (int i = 0; i < n; i++) {

            int currentSum = 0;

            for (int j = 0; j < n; j++) {
                int index = ( i + j) % n; // this trick makes the index rotate without actually change de element's position.
                currentSum += j * arr[index];
            }
            result = Math.max(result, currentSum);
        }

        return result;
    }

}
