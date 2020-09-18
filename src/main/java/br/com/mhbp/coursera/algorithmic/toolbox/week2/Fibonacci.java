package br.com.mhbp.coursera.algorithmic.toolbox.week2;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fib = in.nextInt();
        if (fib <= 1) {
            System.out.print(fib);
        } else {
            BigInteger[] results = new BigInteger[fib + 1];
            results[0] = new BigInteger("0");
            results[1] = new BigInteger("1");

            for (int i = 2; i <= fib; i++) {
                results[i] = results[i - 1].add(results[i - 2])  ;
            }

            System.out.print(results[fib]);
        }
    }
}
