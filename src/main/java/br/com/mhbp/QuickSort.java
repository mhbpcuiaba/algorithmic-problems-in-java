package br.com.mhbp;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return  array;
    }

    private static void quickSort(int[] array, int l, int r) {

        if (l < r) {
            int pivotIndex = partition(array, l, r);
            quickSort(array, l, pivotIndex - 1);
            quickSort(array, pivotIndex + 1 , r);
        }

    }

    private static int partition(int[] array, int l, int r) {
        int pivot = array[l];
        int i = l + 1;
        while (i < r) {
            if (array[i] < array[pivot] ) {
                swap(array, i, r);
                r--;
            }
            i++;
        }
        swap(array, pivot, r);
        return i;
    }

    private static int partitioning(int[] array, int left, int right) {
        int pivot = array[right];
        int pIndex = left - 1;//?????
        for (int i = left; i < right; i++) {
            if ( array[i] <= pivot) {
                pIndex++;
                swap(array, i, pIndex);
            }
        }

        swap(array, ++pIndex, right);
        return pIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = { 8, 5, 2, 9, 5, 6, 3 };
        array = quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
