package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        //                0  1  2  3  4  5
        int[] array_1 = { 2, 1, 5, 1, 3, 2 };
        int k_1 = 3;

        int[] array_2 = { 2, 3, 4, 1, 5 };
        int k_2 = 2;

//        System.out.println(findMaxSumSubArray(array_1, k_1));
//        System.out.println(findMaxSumSubArray(array_2, k_2));

        int[] array3 = { 2, 1, 5, 2, 3, 2 };
        System.out.println(findMinSubArray(7, array3));
    }

    public static int findMinSubArray_V2(int sum, int[] array) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd];

            while (windowSum > sum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= array[windowStart++];
            }

        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int findMinSubArray(int sum, int[] array) {

        int windowSum = 0;
        int nEl = 0;
        int nElSmallest = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int i = 0; i < array.length; i++) {

            int currentrEl = array[i];

            if (sum > windowSum + currentrEl) {
                windowSum += currentrEl;
                nEl++;
            } else {
                windowSum += currentrEl;
                nEl++;
                while ( windowSum > sum) {
                    if (windowSum - array[windowStart] < sum) {
                        break;
                    }
                    windowSum -= array[windowStart++];
                    nEl--;
                }

                if (nElSmallest > nEl) {
                    nElSmallest = nEl;
                }
            }
        }


        return nElSmallest;
    }

    public static int findMaxSumSubArray(int[] array, int k) {

        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        int newSum = maxSum;
        for (int i = k; i < array.length ; i++) {
            int elementToBeRemoved = array[i -k];
            int currentElement = array[i];
            newSum = newSum - elementToBeRemoved + currentElement;
            maxSum = Math.max(maxSum, newSum);

        }
        return maxSum;
    }

    public static int findMaxSumSubArray_v2(int k, int[] arr) {

        int windowSum = 0;
        int maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }
}
