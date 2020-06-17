package br.com.mhbp.greedy;

import java.util.Collections;
import java.util.List;

public class ThreeSum {


    boolean hasThreeSum(List<Integer> list, int sum) {
        Collections.sort(list);
        return list.stream().anyMatch( a -> TwoSum.hasTwoSum(list, sum - a));

    }
}
