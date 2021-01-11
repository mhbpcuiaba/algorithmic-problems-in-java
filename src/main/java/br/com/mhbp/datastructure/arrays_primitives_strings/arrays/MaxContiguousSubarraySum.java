package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

public class MaxContiguousSubarraySum {

    public static void main(String[] args) {

        int[] array = { -2, 1, -3, 4, -1 , 2, 1, -5, 4 };
        int[] aux = new int[array.length];

        int indexLeftSubarray = 0;
        int indexRightSubarray = 0;
        int maxSum = array[0];

        for (int i = 1; i < array.length; i++) {

             if ( array[i] > maxSum + array[i]) {
                 indexLeftSubarray = i;
                 maxSum = array[i];
                 indexRightSubarray = i;
             } else {
                 maxSum += array[i];
                 indexRightSubarray++;
             }

            aux[i] = maxSum;

        }

        System.out.println(maxSum);
        System.out.println(indexLeftSubarray);
        System.out.println(indexRightSubarray);

        System.out.println("-----------------");
        int max = Integer.MIN_VALUE;
        for (int i : aux) {
            if (max < i) {
                max = i;
            }
        }

        System.out.println(max);
    }


    public int maxSubArray(int[] array) {
        int maxSoFar = array[0];
        int maxEndingHere = array[0];

        for (int el : array) {
            maxEndingHere = Math.max( maxEndingHere + el, el);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
