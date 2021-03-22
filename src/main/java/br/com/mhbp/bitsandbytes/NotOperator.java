package br.com.mhbp.bitsandbytes;

public class NotOperator {
    /*

    The rule of 2’s complement is:

If the leading bit on the left side is 0, then it is a positive number.

If the leading bit on the left side is 1, then it is a negative number.

When doing NOT operation on positive numbers, they become negative and vice-versa.

Now, 2’s complement representation is

If we were given a negative number “-x”, its 2’s complement representation is "2^32 -x"

formula
 ~x = (2³² -x)

We know the integer data type takes 4 bytes in C, C++, and Java.

4 Bytes = 4 * (8 bits) = 32 bits. { 1 Byte = 8 bits }


Let’s see one of the above examples in binary representation.

For simplicity, we’ll represent these in 16-bit instead of 32-bit binary.


 a =  1 => in Binary : 0000 0000 0000 0001

        ~a in Binary : 1111 1111 1111 1110
 ----------------------------------------

So,  a = 1 becomes -2(~a)


The ~ operation happens from the rightmost bit traversing towards the leftmost bit in the 32 bit binary representation.

Let’s visualize the steps below:

Step #1:

Right most bit inverts to 0
 a =  1 => in Binary : 0000 0000 0000 0001

        ~a in Binary :                   0

Step #2:

All other bits are 0, and they invert into 1.
 a =  1 => in Binary : 0000 0000 0000 0001

        ~a in Binary : 1111 1111 1111 1110

Below is code representation of the ~ operator.
*/

    public static void main( String args[] ) {
        int a = 1;
        System.out.println("Bitwise NOT of a is : " + ~a);
    }
}
