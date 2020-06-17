package br.com.mhbp.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class  Permutations {


    public static List<List<Integer>> findPermutationsHelper(int[] nums, int currentIndex) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (int k = 0; k < nums.length; k++) { // current element
            int numberOfPermutations = permutations.size();


            for (int i = 0; i < numberOfPermutations; i++) { // for each permutation add the current element, nums[currentIndex], if it is not there yet

                // we will iterate all permutations to create new permutations from the new element and old permutations
                List<Integer> oldPermutation = permutations.poll();

                for (int j = 0; j < oldPermutation.size(); j++) {

                    ArrayList<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, nums[k]);//??????????????????????????????????????????????

                    if (nums.length == newPermutation.size()) { //in this we reach the target, so it is a valid result
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation); // this permutation is  still incomplete
                    }
                }
            }
        }

        return result;
    }


    public static void findPermutationsRecursive(int[] nums, int currentIndex, List<List<Integer>> result, List<Integer> permutation) {

        if (currentIndex == nums.length) {
            result.add(permutation);
        } else {

            for (int i = currentIndex; i < permutation.size(); i++) {
                ArrayList<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(i, nums[currentIndex]);
                findPermutationsRecursive(nums, currentIndex + 1, result, permutation);
            }
        }


    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        findPermutationsRecursive(nums, 0, result, permutation);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
