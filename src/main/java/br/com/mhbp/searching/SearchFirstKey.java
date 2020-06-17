package br.com.mhbp.searching;

import java.util.List;

public class SearchFirstKey {


    int squareRoot(int k) {
        int start = 0;
        int end = k;
        while (start < end) {
            int mid = start + (end - start)/2;
            int midSquared = mid * mid;

            if (midSquared <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return start - 1;
    }
    int searchSmallestIntoShiftedSortedArray(List<Integer> list) {

        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start)/2;

            if (list.get(mid) > list.get(end)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    int searchEntryEqualToIndex(List<Integer> list) {

        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int difference = list.get(mid) - mid;//element - index

            if (difference > 0) {
                end = mid - 1;
            } else if (difference == 0) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return  -1;
    }

    int searchFirstOfK(List<Integer> list, int k) {

        int start = 0;
        int end = list.size() - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (list.get(mid) > k) {
                end = mid - 1;
            } else if (list.get(mid).equals(k)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
