package br.com.mhbp.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {


    public static void main(String[] args) {
//        int[] input = { 12, 3, 1, 2, -6, 5, -8, 6 };
        int[] input = { 1, 2, 3 };
        List<Integer[]> integers = threeNumberSum(input, 7);

        if (integers.size() == 0) {
            System.out.println("[]");
            return;
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.println();
            System.out.println("array: " + i);
            Integer[] integers1 = integers.get(i);

            if (integers1.length ==0) {
                System.out.println("[]");
            } else {
            for (int i1 = 0; i1 < integers1.length; i1++) {
                System.out.print(integers1[i1] + " ");
            }

            }
            System.out.println();
        }


    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        // Write your code here.

        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue;
            _threeNumberSum(array, targetSum - array[i], i + 1,  result);
        }
        return result;
    }

    private static void _threeNumberSum(int[] array, int targetSum,  int left,   List<Integer[]> result) {
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];

            if (currentSum == targetSum) {
                Integer[] tmp = { array[left++], array[right--], -targetSum };
                result.add(tmp);
                //skip same elements to avoid duplicate triplet
                while (left < right && array[left - 1] == array[left]) left++;
                while (left < right && array[right ] == array[right + 1]) right--;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }

        }
    }
}
