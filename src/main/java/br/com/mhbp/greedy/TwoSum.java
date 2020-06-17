package br.com.mhbp.greedy;

import java.util.List;

public class TwoSum {


   static boolean hasTwoSum(List<Integer> list, int sum) {


        for (int i = 0, j = list.size(); i < j;) {

            int sumPair = list.get(i) + list.get(j);
            if (sumPair == sum) {
                return true;
            } else if (sumPair < sum) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
