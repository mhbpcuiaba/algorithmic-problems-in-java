package br.com.mhbp.bitsandbytes;

public class CountBits {

    public static short countBits(int x) {
        short numBits = 0;
        while (x > 0) {
            numBits += ( x & 1);
            x >>>= 1;
        }

        return numBits;
    }

    public static short parityBruteForce(long x) {
        short result = 0;

        while(x!=0) {
            result ^= (x & 1);
            x >>>= 1;
        }

        return result;
    }

    public static short parity(long x) {
        short result = 0;

        while(x!=0) {
            result ^= 1;
            x >>>= 1;
        }

        return result;
    }


    public static short parityClever(long x) {

        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;

        return (short) ( x & 0x1);
    }

    public long swapBits(long x, int i, int j) {
        //...
        return x;
    }
}
