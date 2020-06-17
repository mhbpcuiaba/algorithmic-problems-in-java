package br.com.mhbp.sorting;

public class InPlaceMergeSort {


    public static void main(String[] args) {
        int[] array =  { 9, 7, 8, 43, 5, 2, 0, 1, 4, 22, 11 };


        new InPlaceMergeSort().mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }

    }
    void mergeSort(int[] array, int low, int high) {

        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(array, low, middle);
            mergeSort(array,  middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    /*
       merges two subarrays
       subarray1 = array[low..middle]
       subarray2 = array[middle + 1, high]
     */
    private void merge(int[] array, int left, int middle, int right) {


        int start1 = left;
        int start2 = middle + 1;


        while( start1 < middle && start2 < right) {


            if (array[start1] <= array[start2])
                start1++;
//                swap(array, );
            else {

                swap(array, start1, start2);
                start1++;
                start2++;
            }

        }
    }

    private void swap(int array[], int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

}
