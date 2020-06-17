package br.com.mhbp.binarysearch;

public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if ( key > arr[arr.length - 1]) return -1;// it is bigger than the biggest

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end -start)/2;

            if ( key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return start;
    }

    public static int searchFloorOfANumber(int[] arr, int key) {
        if ( key < arr[arr.length - 1]) return -1;// it is smaller than smallest

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end -start)/2;

            if ( key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return end;
    }


}
