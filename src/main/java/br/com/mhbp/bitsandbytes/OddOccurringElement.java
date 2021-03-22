package br.com.mhbp.bitsandbytes;

public class OddOccurringElement {
    private static int helper(int[] arr) {
        int res = 0;
        for (int value : arr) {
            res ^= value;
        }
        return res;
    }

    public static void main(String[] args) {
        int result = helper(new int[]{4, 3, 3, 4, 4, 4, 5, 3, 5});
        System.out.println("Odd occurring element is " + result);
    }
}
