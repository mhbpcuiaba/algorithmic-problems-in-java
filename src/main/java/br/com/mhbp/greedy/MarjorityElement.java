package br.com.mhbp.greedy;

import java.util.Iterator;

public class MarjorityElement {

    static String marjoritySearch(Iterator<String> stream) {
        String candidate = "";
        int candidateCount = 0;

        while (stream.hasNext()) {
            String next = stream.next();

            if (candidateCount == 0) {
                candidate = next;
                candidateCount = 1;
            } else if (candidate.equals(next)) {
                candidateCount++;
            } else {
                candidateCount--;
            }
        }

        return candidate;
    }
}
