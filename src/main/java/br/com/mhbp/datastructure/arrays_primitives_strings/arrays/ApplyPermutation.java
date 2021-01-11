package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.Collections;
import java.util.List;

public class ApplyPermutation {

    public static void main(String[] args) {

    }

    public void generatePermutations(List<Integer> list, List<Integer> permutation) {


        for (int i = 0; i < list.size(); i++) {

            while (permutation.get(i) != i) {
                Collections.swap(list, i, permutation.get(i));
                Collections.swap(permutation, i, permutation.get(i));
            }
        }

    }
}
