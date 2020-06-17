package br.com.mhbp.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSizeK {


    static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(n, k, 1, result, new ArrayList<>());
        return result;
    }

    private static void generateCombinations(int N, int k, int offset, List<List<Integer>> result, List<Integer> currentCombination) {


        if (currentCombination.size() == k) {
            result.add( new ArrayList<>(currentCombination));
        } else {

            int remainings = k - currentCombination.size();

            for (int i = offset; i <= N && remainings <= N - i + 1; i++) {

            }
        }
    }
}
