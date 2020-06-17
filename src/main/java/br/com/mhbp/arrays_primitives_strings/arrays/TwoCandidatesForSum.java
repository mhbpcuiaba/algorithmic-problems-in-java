package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.Arrays;

public class TwoCandidatesForSum {


    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, -8 };
        int n = 49;

        hasArrayTwoCandidatesForSum(A, n);
    }



    static boolean hasArrayTwoCandidatesForSum(int[] array, int sum) {
        if (array == null || array.length < 2) return false;

        int size = array.length;


        Arrays.sort(array);


        int left = 0;
        int right = size - 1;

        while (left < right) {

            int localSum = array[left] + array[right];
            if (localSum == sum) {
                System.out.println("found elements: array[" + left + "] = " + array[left] + " array[" + right + "]= " + array[right]);
                return true;
            } else if ( localSum > sum) {
                right--;
            } else {
                left++;
            }


        }

        System.out.println("Elements not found");
        return false;
    }
}
