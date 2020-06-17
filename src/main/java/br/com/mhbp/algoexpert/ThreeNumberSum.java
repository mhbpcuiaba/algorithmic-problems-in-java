package br.com.mhbp.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {


    public static void main(String[] args) {
        int[] input = { 12, 3, 1, 2, -6, 5, -8, 6 };
        List<Integer[]> integers = threeNumberSum(input, 0);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println();
            System.out.println("array: " + i);
            Integer[] integers1 = integers.get(i);
            for (int i1 = 0; i1 < integers1.length; i1++) {
                System.out.print(integers1[i1] + " ");
            }
            System.out.println();
        }


    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        // Write your code here.

        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            _threeNumberSum(array, targetSum, i, 0, array.length - 1, result);
        }
        return result;
    }

    private static void _threeNumberSum(int[] array, int targetSum, int currentIndex, int left, int right,  List<Integer[]> result) {

        while (left < right) {
            if (left == currentIndex) {
                left++;
                continue;
            }

            if (right == currentIndex) {
                right--;
                continue;
            }


            if (array[left] + array[right] + array[currentIndex] == targetSum) {
                Integer[] tmp = { array[left], array[right], array[currentIndex] };
                result.add(tmp);
                left++;
                right--;
            } else if (array[left] + array[right] + array[currentIndex] < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}
