package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumTarget {


    public static List<List<Integer>> searchTriplets(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            searchPair(arr, result, -arr[i]);
        }
        return result;
    }

    private static void searchPair(int[] arr, List<List<Integer>> result, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] + arr[right] == k) {
                result.add(Arrays.asList(arr[left++], arr[right--], -k));
                while (left < right && arr[left] == arr[left - 1]) left++;
                while (left < right && arr[right] == arr[right + 1]) right--;
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else {
                right--;
            }

        }
    }
}
