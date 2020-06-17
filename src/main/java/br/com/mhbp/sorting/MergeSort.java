package br.com.mhbp.sorting;


public class MergeSort {

    public static void main(String[] args) {

        int[] array = { 9, 7, 8, 43, 5, 2, 0, 1, 4, 22, 11 };
        sort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {

        if (array.length > 1) {

            int[] left = new int[array.length/2];
            System.arraycopy(array, 0, left, 0, left.length);

            int[] right = new int[array.length - left.length];
            System.arraycopy(array, left.length, right, 0, right.length);

            sort(left);
            sort(right);
            merge(array, left, right);
        }

    }







    private static void merge(int[] array, int[] left, int[] right) {

        int lIndex = 0, rIndex = 0, index = 0;

        while (lIndex < left.length && rIndex < right.length) {

            if (left[lIndex] < right[rIndex]) {
                array[index++] = left[lIndex++];
            } else {
                array[index++] = right[rIndex++];
            }
        }

        if (lIndex < left.length ) {
            while (lIndex < left.length) array[index++] = left[lIndex++];
        } else {
            while (rIndex < right.length) array[index++] = right[rIndex++];
        }
    }

}
