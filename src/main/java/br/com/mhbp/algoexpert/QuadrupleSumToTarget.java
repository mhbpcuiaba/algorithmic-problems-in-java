package br.com.mhbp.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = 0; j < 2; j++) {
                if (j > 0 && arr[j] == arr[j - 1]) continue;
                searchPairs(arr, target, i, j, quadruplets );
            }

        }

        return quadruplets;
    }

    static void searchPairs(int[] array, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = array.length - 1;

        while (left < right) {
            int sum = array[first] + array[second] + array[left] + array[right];

            if (sum == targetSum) {
                quadruplets.add(Arrays.asList(array[first], array[second], array[left++], array[right--]));

                while (left < right && array[left] == array[left - 1]) left++;
                while (left < right && array[right] == array[right + 1]) right--;

            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

    }
}
