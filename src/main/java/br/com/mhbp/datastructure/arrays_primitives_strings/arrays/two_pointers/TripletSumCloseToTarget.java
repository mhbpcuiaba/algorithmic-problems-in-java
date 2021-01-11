package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_pointers;

import java.util.Arrays;

//TODO Revisar
public class TripletSumCloseToTarget {

    public static void main(String[] args) {

    }


    public static void searchTripletsSumCloseTarget(int[] arr, int target) {


        Arrays.sort(arr);

        int smallestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1, right = arr.length - 1;

            while (left < right) {
                int diff = arr[i] + arr[left] + arr[right] - target;


                if (diff == 0) {
                    System.out.println("indexes: " + i + ", " +  left + ", " + right);
                    return;
                }

                if ( diff > 0) {
                    right--;
                } else if ( diff < 0) {
                    left++;
                }

                smallestDifference = Math.min(smallestDifference, diff);
            }
        }

    }


}
