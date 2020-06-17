package br.com.mhbp.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumPointsCoveringIntervals {

    static class Interval {
        int start, end;
    }

    public Integer findMinimum(List<Interval> list) {
        Collections.sort(list, Comparator.comparingInt(i -> i.end));

        Integer numVisits = 0;
        Integer lastVisitTime = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {

            Interval interval = list.get(i);

            if (interval.start > lastVisitTime) {
                numVisits++;
                lastVisitTime = interval.end;
            }

        }
        return numVisits;
    }
}
