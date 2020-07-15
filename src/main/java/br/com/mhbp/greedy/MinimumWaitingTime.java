package br.com.mhbp.greedy;

import java.util.Collections;
import java.util.List;

public class MinimumWaitingTime {

    public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
        Collections.sort(serviceTimes);

        int totalWaitingTime = 0;
        int size = serviceTimes.size();

        for (int i = 0; i < size; i++) {
            int numRemaingQueries = size - (i + 1);
            totalWaitingTime += serviceTimes.get(i) * numRemaingQueries;// cause all the other queries have to wait
        }

        return totalWaitingTime;
    }
}
