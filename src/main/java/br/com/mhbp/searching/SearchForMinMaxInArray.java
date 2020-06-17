package br.com.mhbp.searching;

import java.util.List;

public class SearchForMinMaxInArray {

    static class MinMax {
        int min, max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static MinMax minMax(Integer a, Integer b) {
        return a < b? new MinMax(a,b): new MinMax(b, a);
    }

    static MinMax findMinMax(List<Integer> list) {

        MinMax globalMinMax = minMax(list.get(0), list.get(1));

        for (int i = 2; i < list.size(); i += 2) {

            MinMax localMinMax = minMax(list.get(0), list.get(1));
            globalMinMax = new MinMax(Math.min(globalMinMax.min, localMinMax.min), Math.max(globalMinMax.max, localMinMax.max));
        }

        if (list.size()%2 == 1) { //if the number is odd we still need to copare the last element
            Integer lastNumber = list.get(list.size() - 1);
            globalMinMax = new MinMax(Math.min(globalMinMax.min, lastNumber), Math.max(globalMinMax.max, lastNumber));
        }
        return globalMinMax;
    }
}
