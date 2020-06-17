package br.com.mhbp.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        generatePowerSetHelper(result, inputSet, new ArrayList<Integer>(), 0);
        return result;
    }

    private static void generatePowerSetHelper(List<List<Integer>> result, List<Integer> inputSet, ArrayList<Integer> currentSet, int currentIndex) {

        if (currentIndex == currentSet.size()) {
            result.add(currentSet);
        } else {

            currentSet.add(inputSet.get(currentIndex));
            generatePowerSetHelper(result, inputSet, currentSet, currentIndex + 1);
            currentSet.remove(currentSet.size() - 1);
            generatePowerSetHelper(result, inputSet, currentSet, currentIndex + 1);
        }

    }
}
