package br.com.mhbp.arrays_primitives_strings.arrays.cycic_sort;

public class CyclicSort {

    public static void main(String[] args) {
        int[] array = { 1, 5, 6, 4, 3, 2 };
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sort_V2(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else  {
                i++; // we only increment when the num is on the right place
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(int [] nums) {

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == i) {
                continue;
            }
            int j = i;
            while (nums[j - 1] != j) { // nums[i] == 2, i == 0
                int tmp = nums[nums[j - 1] - 1];
                nums[nums[j - 1] - 1] = nums[j - 1];
                nums[j - 1] = tmp;

            }
        }
    }
}
