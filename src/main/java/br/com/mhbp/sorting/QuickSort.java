package br.com.mhbp.sorting;


public class QuickSort {


    static  int[] array = {9,8,7,6,5,4,3,2,1,0};
    public static void main(String[] args) {
        quicksort(array, 0, array.length - 1);

        System.out.println("BEGIN");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("END");
    }

    private static void quicksort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partitioning(array, left, right);
            quicksort(array, left, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, right);

        }
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

    private static void swap(int array[], int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
