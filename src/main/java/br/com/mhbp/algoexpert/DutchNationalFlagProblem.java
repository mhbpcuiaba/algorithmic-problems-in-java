package br.com.mhbp.algoexpert;

//three pointers!!! low, middle, high
public class DutchNationalFlagProblem {


    void solve(int[] array ){
        int indexOnes =partitionBy(2, array, 0, array.length);
        partitionBy(1, array, 0, indexOnes);
    }

    void solveV2(int[] array) {
        int low = 0, high = array.length - 1;

        for (int middle = 0; middle <= high; ) { //

            if (array[middle] == 0) {
                swap(array, low, middle);
                low++;
                middle++;
            } else if (array[middle] == 1) {
                middle++;
            } else {
                swap(array, middle, high);
                high--;
            }

        }
    }
    int partitionBy(int k, int[] array, int left, int right) {
        while (left < right) {
            if (array[left] == k)
                swap(array, left, --right);
            else
                left++;
        }
        return right;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
