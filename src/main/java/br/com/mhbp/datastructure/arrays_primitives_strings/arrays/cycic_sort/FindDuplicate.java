package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.cycic_sort;

public class FindDuplicate {



    public static int findNumber(int[] nums) {
        int i = 0;

        while ( i < nums.length) {

            if ( nums[i] !=  i + 1) {

                if ( nums[i] !=  nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    return nums[i];
                }



            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length - 1; j++) {

            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        return -1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
