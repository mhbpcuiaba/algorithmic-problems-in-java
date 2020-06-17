package br.com.mhbp.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {


    public List<List<Integer>> calculate(List<Integer> list, int target ) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int product = 1;


        for (int right = 0; right < list.size(); right++) {
            product *= list.get(right);

            while (product >= target && left < list.size()) product /= list.get(left++);

            LinkedList<Integer> tmpList = new LinkedList<>();

            for (int i = right; i >= left ; i--) {
                tmpList.add(0, list.get(i));
                result.add(new ArrayList<>((tmpList)));
            }
        }
        return result;
    }
}
