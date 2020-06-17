package br.com.mhbp.sorting;




public class InsertionSort {


    public static void main(String[] args) {

        int[] array = { 9, 7, 8, 43, 5, 2, 0, 1, 4, 22, 11 };
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void sort(int[] array) {


        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] < array[i + 1]) continue;

            int j = i;

            while (j >= 0 && (array[j] > array[j + 1])) {
                swap(array, j, j+ 1);
                j--;
            }

        }
    }

    private static void swap(int[] array, int j, int i) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
