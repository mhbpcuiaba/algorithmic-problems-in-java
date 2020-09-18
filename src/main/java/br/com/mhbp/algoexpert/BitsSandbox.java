package br.com.mhbp.algoexpert;

public class BitsSandbox {


    public static void main3(String[] args) {
        int a = 10;
        int b = 12;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        System.out.println(a);

    }
    public static void main2(String[] args) {
        for(int i = 0; i <2;i++) {
            for(int j = 0; j <2;j++) {
                System.out.printf("%d xor %d = %d%n", i, j, i  ^ j );
                System.out.printf("%d xor %d = %d%n", i, j, (i  & ~j) );

                System.out.printf("i  ^ ~i= %d", i  ^ ~i);
            }

            /*shifting left its like multiply by 10*/

        }
        System.out.println("\nFIM LOOP");
        //like multiplying
        System.out.println( 1 << 1); /* 1 * 2  ^ 1 */
        System.out.println( 1 << 2); /* 1 * 2  ^ 2 */
        System.out.println( 1 << 3); /* 1 * 2  ^ 3 */
        System.out.println( 1 << 4); /* 1 * 2  ^ 4 */

        //like dividing
        System.out.println( 100000 >> 1); /* 1 * 2  ^ 1 */
        System.out.println( 100000 >> 2); /* 1 * 2  ^ 2 */
        System.out.println( 100000 >> 3); /* 1 * 2  ^ 3 */
        System.out.println( 100000 >> 4); /* 1 * 2  ^ 4 */

        System.out.println( 100000 >>> 4); /* 1 * 2  ^ 4 */

        /*
        *  >> keeps signed, >>> is unsigned
        * */

        System.out.println( 0x1 << 4); /* 1 * 2  ^ 4 */
        System.out.println( 0x1 << 8); /* 1 * 2  ^ 8 */
        System.out.println( 0x1 << 16); /* 1 * 2  ^ 16 */

        System.out.println("FIM PROGRAM");
    }

    public static CharSequence intToBits(int num) {
        StringBuilder result = new StringBuilder();

        for (int bit = 31; bit >= 0; bit--) {
            System.out.println(num & (1 << bit));

            if ( (num & (1 << bit)) != 0) {
                result.append(1);
            } else {
                result.append(0);
            }

            if (bit > 0) {

                if ( (bit & 0b11) ==  0) result.append("_");
                if ( (bit & 0b111) ==  0) result.append("_");
            }
        }

        return result;
    }
}
