package br.com.mhbp.datastructure.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {



    static List<List<Integer>> twosum(List<Integer> list, int target) {
        List<List<Integer>> r = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int remainder = target - list.get(i);

            if (map.containsKey(remainder)) {
                r.add(Arrays.asList(list.get(i), remainder ));
            }

            map.put(list.get(i), i);
        }

        return r;
    }
}
