package br.com.mhbp.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {


    public static void main(String[] args) {
        List<List<Integer>> powerset = powerset(Arrays.asList(1, 2, 3));
        for (List<Integer> integers : powerset) {
           System.out.println(integers);
        }
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, array, result, new ArrayList<>());
        return result;
    }

    public static void generate(int index, List<Integer> array, List<List<Integer>> result, List<Integer> current) {
        if (index == array.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(array.get(index));
        generate(index + 1, array, result, current);
        current.remove(current.size() - 1);
        generate(index + 1, array, result, current);
    }
}
