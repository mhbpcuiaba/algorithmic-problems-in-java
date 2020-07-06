package br.com.mhbp.arrays_primitives_strings.arrays.two_pointers;

import java.util.Arrays;
import java.util.List;

public class PairWithTargetSum {


    //given two intervals there will be isx different ways the two intervals can relate to each other
    public static void main(String[] args) {

        int[] t1 = { 1, 2, 3, 4, 6 };
        int[] search = search(t1, 6);
        System.out.println(search[0]);
        System.out.println(search[1]);
    }


    public static int[] search(int[] array, int target) {

        for(int i = 0, j = array.length - 1; i < j;) {
            int sumOfPair = array[i] + array[j];
            if (sumOfPair == target ) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = j;
                return result;
            } else if (sumOfPair > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public static List<Integer> search(List<Integer> array, int target) {

        for(int i = 0, j = array.size() - 1; i < j;) {
            int sumOfPair = array.get(i) + array.get(j);

            if (sumOfPair == target ) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = j;
                return null;
            } else if (sumOfPair > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

}
