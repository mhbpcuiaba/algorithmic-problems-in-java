package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.*;

public class ThreeSum {

    //find all none duplicate triplet where : a + b + c = 0
    public List<List<Integer>> threeSum(int[] array) {

        Arrays.sort(array);

        Set<List<Integer>> allThreeSums = new HashSet<>();

        // we limit to array.length - 2, cause we analyzing each position and each position need at least 2 more elements
        //so that's why we do no go to the end of array, we must left two index righter most
        for (int i = 0; i < array.length - 2; i++) {
            findTwoSum(i, array, allThreeSums);
        }

        return new ArrayList<>(allThreeSums);
    }

    private void findTwoSum(int rootIndex, int[] array, Set<List<Integer>> allThreeSums) {

        int left = rootIndex + 1;
        int right = array.length - 1;


        while (left < right) {

            int threeNUmberSum = array[rootIndex] + array[left] + array[right];

            if (threeNUmberSum == 0) {
                allThreeSums.add(Arrays.asList(array[rootIndex] , array[left] , array[right]));
            } else if (threeNUmberSum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
