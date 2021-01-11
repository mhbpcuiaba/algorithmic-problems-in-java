package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.Collections;
import java.util.List;

public class EvenOddArray {

    public static void evenOdd(List<Integer> list) {
        int evenIndex = 0;
        int oddIndex = list.size() - 1;

        while (evenIndex < oddIndex) {

            if (list.get(evenIndex) % 2 == 0) {
                evenIndex++;
            } else {
                Collections.swap(list, evenIndex, oddIndex--);
            }
        }
    }

}
