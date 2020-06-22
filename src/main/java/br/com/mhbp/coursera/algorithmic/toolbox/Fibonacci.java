package br.com.mhbp.coursera.algorithmic.toolbox;

import java.math.BigInteger;

public class Fibonacci {

    public static void main(String[] args) {
        int fib = 200;
        BigInteger[] results = new BigInteger[fib];
        results[0] = new BigInteger("0");
        results[1] = new BigInteger("1");

        for (int i = 2; i < fib; i++) {
            results[i] = results[i - 1].add(results[i - 2])  ;
        }

        System.out.println(results[fib - 1]);
    }
}
