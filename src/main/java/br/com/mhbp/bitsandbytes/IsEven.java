package br.com.mhbp.bitsandbytes;

public class IsEven {


    String isEven(int n) {
        return (n & 1) == 0 ? "Even":"Odd";
    }

    boolean isEvenV2(int n) {
        if (n == 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
