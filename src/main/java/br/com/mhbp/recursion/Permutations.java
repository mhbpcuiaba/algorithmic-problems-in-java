package br.com.mhbp.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//based on swaps, cause we must keep the list size, so we do not add or remove, just swap is enough
public class Permutations {

    static List<List<Integer>> generatePermutations(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        permutationHelper(A, 0, result);
        return result;
    }

    private static void permutationHelper(List<Integer> currentPermutation, int currentIndex, List<List<Integer>> result) {


        if (currentIndex == currentPermutation.size() - 1) {//we are at last position
            result.add(currentPermutation);
        } else {


            for (int i = currentIndex; i < currentPermutation.size(); i++) {
                Collections.swap(currentPermutation, i, currentIndex);
                permutationHelper(currentPermutation, currentIndex + 1, result);
                Collections.swap(currentPermutation, i, currentIndex);

            }
        }
    }

}
