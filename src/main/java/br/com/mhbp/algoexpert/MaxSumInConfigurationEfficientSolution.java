package br.com.mhbp.algoexpert;

public class MaxSumInConfigurationEfficientSolution {

    public static void main(String[] args)    {
        int arr[] = {8, 3, 1, 2};
        int n = arr.length;
        System.out.println(new MaxSumInConfigurationEfficientSolution().maxSum(arr, n));
    }
    int maxSum(int arr[], int n)    {

        // Compute sum of all array elements
        int arraySum = 0;
        for (int i = 0; i < n; i++) arraySum += arr[i];

        // Compute sum of i*arr[i] forinitial configuration.
        int currentSumConfiguration = 0;
        for (int i = 0; i < n; i++)  currentSumConfiguration += i * arr[i];

        // Initialize result
        int result = currentSumConfiguration;

        for (int i = 1; i < n; i++) {

            int nextValue = currentSumConfiguration - (arraySum - arr[i - 1]) + arr[i - 1] * (n - 1);
            currentSumConfiguration = nextValue;
            result = Math.max(result, currentSumConfiguration);
        }
        return result;
    }
}
