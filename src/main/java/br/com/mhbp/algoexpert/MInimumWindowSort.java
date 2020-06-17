package br.com.mhbp.algoexpert;

public class MInimumWindowSort {

    public static int sort(int[] array) {
        int low = 0, high = array.length - 1;

        //find the first number out of sorting order from the beginning
        while ( low < array.length - 1 && array[low] <= array[low + 1]) low++;

        if (low == array.length) return 0; //it is already sorted

        //find the first number out of sorting order from the end
        while (high > 0 && array[high - 1] <= array[high - 1]) high--;

        int subarrayMax = Integer.MIN_VALUE;
        int subarrayMin = Integer.MAX_VALUE;

        //find min and max elements
        for (int i = low; i < high; i++) {
            subarrayMax = Math.max(subarrayMax, array[i]);
            subarrayMin = Math.min(subarrayMin, array[i]);
        }

        while (low > 0 && array[low - 1] > subarrayMin) low--;
        while (high < array.length - 1 && array[high + 1] < subarrayMax) high++;

        return high - low + 1;
    }
}
