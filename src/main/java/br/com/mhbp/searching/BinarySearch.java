package br.com.mhbp.searching;

public class BinarySearch {


    int binarySearch(int[] array, int k) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + (end - start)/2;

            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }


    int binarySearchRecursive(int[] array, int k, int start, int end) {

        int mid = start + (end - start)/2;

        if (array[mid] == k) {
            return mid;
        } else if (array[mid] > k) {
            return binarySearchRecursive(array, k, start, mid - 1);
        } else {
            start = mid + 1;
            return binarySearchRecursive(array, k, mid + 1, end);
        }
    }
}
