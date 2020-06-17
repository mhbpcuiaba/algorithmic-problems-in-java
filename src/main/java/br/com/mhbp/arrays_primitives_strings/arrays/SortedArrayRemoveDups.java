package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.Arrays;

public class SortedArrayRemoveDups {


    public static void main(String[] args) {
        int[] array = {1,1,1, 2,2,2,3,3, 4,4,4,4,4,4, 5, 6,6,7,7,7,7,8};


        int numberUniqueElements = removeDups(array);
        System.out.println("number of unique elements: " + numberUniqueElements);
        System.out.println();
        System.out.println("the whole array");
        for (int i : array) {
            System.out.println(i);
        }

        int[] uniques = Arrays.copyOfRange(array, 0, numberUniqueElements);
        System.out.println("only");

        for (int i : uniques) {
            System.out.println(i);
        }

    }

    private static int removeDups(int[] array) {
        if (array == null || array.length == 0) return 0;

        int writeIndex = 1;// start with 1 cause it is the first position we analyze

        for (int i = 1; i < array.length; i++) {

            if (!(array[i - 1] == array[i])) {
                array[writeIndex++] = array[i];
            }
        }

        return writeIndex;
    }

}
