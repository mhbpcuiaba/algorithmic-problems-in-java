package br.com.mhbp.bitsandbytes;

public class MissingNUmber {
    /*
    For n numbers, the math below can be applied.

a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b;

For example:

1 ^ 5 ^ 1 = (1 ^ 1) ^ 5 = 0 ^ 5 = 5;
     */

    private static int helper(int[] nums) {
        int n = nums.length + 1;
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= i;
        }

        for (int value : nums) {
            res ^= value;
        }
        return res;
    }

    private static int helperImproved(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing element in the array is " + helper(nums));
    }
}
