package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.Arrays;
import java.util.List;

public class AdvanceByOffset {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 3, 1, 0, 2, 0, 1);
        List<Integer> list2 = Arrays.asList(3, 2, 0, 0, 2, 0, 1);

//        System.out.println(canReachEnd(list));
        System.out.println(canReachEnd(list2));
    }

    private static boolean canReachEnd(List<Integer> list) {

        if (list.get(0) <= 0) return false;

        int furthestReachSoFar = 0;
        int lastIndex = list.size() - 1;

        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {

            int pickingCurrent = i + list.get(i);
            furthestReachSoFar = Math.max(furthestReachSoFar, pickingCurrent);
        }

        return furthestReachSoFar == lastIndex;
    }
}
