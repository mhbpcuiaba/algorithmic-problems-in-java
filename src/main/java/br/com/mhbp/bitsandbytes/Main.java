package br.com.mhbp.bitsandbytes;

public class Main {

/*

      10
    1010
 */
    public static void main(String[] args) {

        int current = 54321;
        final int base = 5;
        int remainder = current % base;

        System.out.println("current: " + current);
        System.out.println("remainder: " + remainder);

        while(current > 0) {
            current = current / base;
            remainder = current % base;

            System.out.println("current: " + current);
            System.out.println("remainder: " + remainder);
        }

        System.out.println((0b10 | 0b10));
        System.out.println(Integer.toBinaryString(0b10 | 0b01));
        System.out.println(Integer.toBinaryString(0b1000 | 0b0001));
        System.out.println(Integer.toBinaryString(0b10000011 | 0b101));



        System.out.println((0b10 & 0b10));
        System.out.println(Integer.toBinaryString(0b10 & 0b01));
        System.out.println(Integer.toBinaryString(0b1000 & 0b0001));
        System.out.println(Integer.toBinaryString(0b10000011 & 0b101));

        System.out.println(Integer.toHexString(123));
    }

}
/*
formula base para conversao de bases nmumericas
 1 * 1 + 4 * 5 + 2 * 5 * 7 * 5

 237 => b^0 * 7+ b^1 * 3+ b^2 * 2

 237 =binnary=> 2^0 * 7+ 2^1 * 3+ 2^2 * 2 =

 b^0 * digit[0] + b^1 * digit[1] + b^2 * digit[2] + .... + b^n * * digit[n]

 */