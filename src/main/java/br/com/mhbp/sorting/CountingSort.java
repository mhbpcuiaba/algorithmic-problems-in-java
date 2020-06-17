package br.com.mhbp.sorting;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = {9,9,8,9,7,2,7,1,2,3,4,5,6,7,3,4,5,9,0};

        countingsort(array);
    }

    private static int[] countingsort(int[] array) {

        if (array == null) throw new IllegalArgumentException("array must not be null");

        int k = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if( k <= array[i]) {
                k = array[i];
            }
        }

        int[] countedElements = new int[k];


        //frequency
        for (int i = 0; i < array.length; i++) {
            countedElements[array[i]]++;
        }

        // summation with last position
        for (int i = 1; i < countedElements.length; i++) {
            countedElements[i] += countedElements[i - 1];
        }

        int[] result = new int[array.length];


        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            result[countedElements[element] - 1] = element;
            countedElements[element] -= 1;
        }

        return result;
    }
}
