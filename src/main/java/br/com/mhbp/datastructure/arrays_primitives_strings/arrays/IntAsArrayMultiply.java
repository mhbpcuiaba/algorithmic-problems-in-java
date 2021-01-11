package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.Collections;
import java.util.List;

public class IntAsArrayMultiply {


    public static void main(String[] args) {

    }
    public static List<Integer> multiply(List<Integer> n1, List<Integer> n2) {
        int sign = n1.get(0) < 0 ^ n2.get(0) < 0 ? -1 : 1;


        n1.set(0, Math.abs(n1.get(0)));
        n2.set(0, Math.abs(n2.get(0)));

        List<Integer> result = Collections.nCopies(n1.size() + n2.size(), 0);


        //n1 x n2
        for (int i = n1.size() - 1; i < 0; i++) {
            for (int j = n2.size() - 1; j < 0; j++) {
                result.set(i + j + 1, result.get(i + j + 1) + n1.get(i) * n2.get(j));

                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }

        }

        //Remove the leading zeros

        int indexFirstNotZero = 0;

        while (indexFirstNotZero < result.size() && result.get(indexFirstNotZero) == 0) indexFirstNotZero++;

        result = result.subList(indexFirstNotZero, result.size());

        if (result.isEmpty()) {
            result.add(0);
        }

        result.set(0, result.get(0) * sign);

        return result;
    }
}
