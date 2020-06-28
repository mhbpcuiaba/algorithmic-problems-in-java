package br.com.mhbp.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A GRANDE SACADA EH, PERMUTACAO MANTEM OS ELEMENTOS ORIGINAIS, O QUE DIFERENCIA UMA PERMUTACAO DA OUTRA É A ORDEM
 * EM QUE OS ELEMENTOS APARECEM.
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(getPermutations(Arrays.asList(1,2,3)));
    }
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        if (!array.isEmpty())
            generate(array, 0, result);
        return result;
    }

    private static void generate(List<Integer> array, int index, List<List<Integer>> result) {
        if (index == array.size()) {
            result.add(new ArrayList<>(array));
            return;
        }

        /**
         *
         * PARA CADA POSICAO 'I' TROQUE DE POSICAO COM 'J' E CACLULA DPS DESTROCA
         */
        for (int i = index; i < array.size() ; i++) {
            Collections.swap(array, i, index);
            generate(array, index + 1, result);
            Collections.swap(array, i, index);
        }
    }
}
