package br.com.mhbp.arrays_primitives_strings.arrays.cycic_sort;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

    public static List<Integer> findMissingNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {

            if ( nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {

            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
