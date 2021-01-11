package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static List<Integer> nextPermutation( List<Integer> perm) {

        int inversionPoint = perm.size() - 2;

        while (inversionPoint >= 0 && perm.get(inversionPoint) >= perm.get(inversionPoint + 1)) {
            --inversionPoint;
        }

        if (inversionPoint == -1) {
            return Collections.emptyList();
        }

        for (int i = perm.size(); i >= inversionPoint ; i--) {

            if (perm.get(i) > perm.get(inversionPoint)) {
                Collections.swap(perm, inversionPoint, i);
                break;
            }
        }


        return perm;
    }
}
