package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlternatingArray {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(10, 9, 8, 7, 7, 6, 6, 6, 5, 4, 3, 2, 1, 0);
        rearrengeArray(l);
    }

    public static void rearrengeArray(List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {

            boolean isEven = i % 2 == 0;
            if (
                    (isEven && list.get(i) > list.get(i -1))
                    ||
                    (!isEven && list.get(i) < list.get(i -1))
                                ) {
                Collections.swap(list, i, i - 1);
            }
        }


        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
