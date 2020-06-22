package br.com.mhbp.coursera.algorithmic.toolbox.week2;

import java.util.Scanner;

public class FibonacciLastDigit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fib = in.nextInt();
        if (fib <= 1) {
            System.out.print(fib);
        } else {
            int[] results = new int[60];
            results[0] = 0;
            results[1] = 1;
            for (int i = 2; i < 60; i++) {
                results[i] = (results[i - 1]  + results[i - 2]) % 10 ;
            }
            int index = fib % 60;
            System.out.print(results[index]);
        }
    }
}
