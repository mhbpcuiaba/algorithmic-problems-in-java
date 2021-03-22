package br.com.mhbp.bitsandbytes;

public class CountSetBits {

    int count(int n) {

        int result = 0;
        while ( n > 0) {

            if (n%2 != 0) {
                result++;
            }
            n = n/2;

        }
        return result;
    }

    int countBitwise(int n) {
        int result = 0;


        while (n > 0) {
            if ((n & 1) == 1) result++;

            n >>= 1;
        }
        return  result;
    }

    int countBitwiseSimplified(int n) {
        int result = 0;
        while (n > 0) {
            result += (n & 1);
            n >>= 1;
        }
        return  result;
    }


    int countBitwiseSimplifiedWithoutShifting(int n) {
        int result = 0;
        while (n > 0) {
            n &= (n -1);
            result++;
        }
        return  result;
    }
}
