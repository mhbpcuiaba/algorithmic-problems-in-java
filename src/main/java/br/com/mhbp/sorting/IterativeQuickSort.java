package br.com.mhbp.sorting;

public class IterativeQuickSort {




    private void swap(int array[], int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    private void quickSort(int[] values, int low, int high) {
        /* Find middle element and pivot value */
        int middle = low + (high - low) / 2;
        int pivot = values[middle];
        /* Update low and high position */
        int i = low, j = high;
        while (i < j) {
            /* If the current value from the left list, is smaller then the pivot, move to next element */
            while (values[i] < pivot) {
                i++;
            }
            /* If the current value from the right list, is greater then the pivot, move to previous element */
            while (values[j] > pivot) {
                j--;
            }
            /* If we find a value in the left list which is larger then the pivot,
             * or if we find a value in the right list which is smaller then the pivot,
             * we swap these values. Once we are done swapping, we can increase i and decrease j */
            if (i <= j) {
                swap(values, i, j);
                i++;
                j--;
            }
            /* Apply quick sort on both left and right*/
            if (low < j) {
                quickSort(values, low, j);
            }
            if (high > i) {
                quickSort(values, i, high);
            }
        }
    }
}
