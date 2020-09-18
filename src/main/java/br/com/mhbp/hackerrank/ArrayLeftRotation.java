package br.com.mhbp.hackerrank;

import java.util.Arrays;

public class ArrayLeftRotation {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int d = 4;
        int rotations = d%a.length;

        int[] ints = Arrays.copyOfRange(a, 0, rotations);

        int[] rest = Arrays.copyOfRange(a, rotations, a.length);

        int length = rest.length + ints.length;
        int[] result = new int[length];
        System.arraycopy(rest, 0, result,0, rest.length);
        System.arraycopy(ints, 0, result, rest.length, ints.length);
//        System.arraycopy(ints, 0, result, 0, ints.length);
//        System.arraycopy(rest, 0, result, ints.length, rest.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
