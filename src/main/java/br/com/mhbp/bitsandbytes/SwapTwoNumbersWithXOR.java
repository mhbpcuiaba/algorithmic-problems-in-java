package br.com.mhbp.bitsandbytes;

public class SwapTwoNumbersWithXOR {

    public static void main(String[] args) {

        int a = 15, b = 121;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("Finally, after swapping; a = " + a + " , b = " + b);
    }
}
