package br.com.mhbp.arrays_primitives_strings.arrays;

public class ArrayPrecisionInteger {

    public static void main(String[] args) {
        int[] number = { 1, 1, 3 };
        int[] numberTwo = { 0, 0, 0, 0 };

        for (int i : number) {
            System.out.print(i);
        }

        increment(number);
        System.out.println();
        for (int i : number) {
            System.out.print(i);
        }


    }

    private static void increment(int[] number) {

        int count = number.length - 1;
        int carry = 0;

            int d = number[count] + 1;
        do {
            int result = d + carry;
            d = result % 10;
            carry = result / 10;
            number[count--] = d;
            if (count >= 0)
                d = number[count];
        } while (carry > 0  && count >= 0);

    }

}
