package br.com.mhbp.bitsandbytes;

/*
We check the right-most significant bit to see if the bit and & operation of 1 yields to 1.

In other words, we shift bits until the right MSB and & operation with 1 yields 1.

Algorithm #
If n == 0, return;
Initialize k = 1
Loop
If ((n >> (k - 1)) & 1) == 0 increment the pointer k
Else, return k
 */
public class CheckIfKthBitIsSeOrUnset {
    private static int helper(int n) {
        if (n == 0) {
            return 0;
        }

        int k = 1;

        while (true) {
            if (((n >> (k - 1)) & 1) == 0) {
                k++;
            } else {
                return k;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("First setbit position for number: 18 is -> " + helper(18));
        System.out.println("First setbit position for number: 5 is -> " + helper(5));
        System.out.println("First setbit position for number: 32 is -> " + helper(32));
    }
}
