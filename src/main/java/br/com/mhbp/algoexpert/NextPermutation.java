package br.com.mhbp.algoexpert;

import java.util.Collections;
import java.util.List;

public class NextPermutation {

    static List<Integer> nextPermutation(List<Integer> perm) {

        int inversionPoint = perm.size() - 2;

        //find the first entry from the right that is maller than the entry imediately after it
        while (inversionPoint >= 0 && perm.get(inversionPoint) < perm.get(inversionPoint + 1))
            inversionPoint--;


        if (inversionPoint < 0) return Collections.emptyList();

        /**
         * swap the smallest entry after index inversionPoint that is greater than perm.get(inversionPoint).
         * Since entries in perm are decreasing after inversionPoint. If we search in reverse order, the first entry that is
         * greater than perm.get(inversionPoint) is the entry to swap with
         */

        for (int i = perm.size() - 1; i > inversionPoint; i--) {

            if (perm.get(inversionPoint) < perm.get(i)) {
                Collections.swap(perm, inversionPoint, i);
                break;
            }
        }

        Collections.reverse(perm.subList(inversionPoint + 1, perm.size()));
        return perm;
    }
}
