package br.com.mhbp.bitsandbytes;

public class CheckKthBitSetOrNot {
    private static boolean checkKthBitSet(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }

    public static void main(String[] args) {
        System.out.println("n = 5, k = 3 : " + checkKthBitSet(5, 3));
        System.out.println("------------");
        System.out.println("n = 10, k = 2 : " + checkKthBitSet(10, 2));
        System.out.println("------------");
        System.out.println("n = 10, k = 1 : " + checkKthBitSet(10, 1));
    }
}
/*
Explanation #
We used the left shift operation to shift the bits to k^{th}k
​th
​​  position and then use the & operation with number 1 and check if it is not-equals to 0.

Let’s see these in 32-bit binary representation

Case #1:

Input n = 5, k = 3

   n    = 5 = 00000000 00000000 00000000 00000101
   1    = 1 = 00000000 00000000 00000000 00000001
   k    = 3 = 00000000 00000000 00000000 00000011
(k - 1) = 2 = 00000000 00000000 00000000 00000010
Now shift 1 with (k - 1) positions. We are shifting number 1 two bit positions to the left side.

(1 << (k - 1)) = 4 = 00000000 00000000 00000000 00000100
Now by doing & operation of n and (1 << (k - 1)) will give us a decimal number. If that is not equal to 0, then the bit is set, and we return true.

Finally, let’s see this in action.

         n         = 5 = 00000000 00000000 00000000 00000101
  (1 << (k - 1))   = 4 = 00000000 00000000 00000000 00000100
-------------------------------------------------------------
n & (1 << (k - 1)) = 4 = 00000000 00000000 00000000 00000100
-------------------------------------------------------------
So n & (1 << (k - 1)) = 4 which is not 0, so we return true.

Complexity analysis #
Time Complexity: O(1). This is always constant time, as we are dealing with the bit representation of the decimals or ASCII. They are represented in either 32/64 bit.

Space Complexity: O(1) extra space, as we are not using any extra space in our code.

We can solve this problem using the right shift as well. We will see how to solve the same problem using the >> operator in the next chapter.
 */