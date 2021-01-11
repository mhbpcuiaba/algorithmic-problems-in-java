package br.com.mhbp.datastructure.tree.binarytree.bst;

public class BinarySearch {

    public static int search(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];

        while (start < end) {

            int mid = start + (end -start) / 2;

            if (arr[mid] == key) return mid;

            if (isAscending) {

                if (arr[mid] < key ) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] < key ) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }

        return -1;
    }
}
