package br.com.mhbp.coursera.algorithmic.toolbox.week2;

import java.util.Scanner;

public class GCD {

    private static int gcdEuclid(int a, int b) {
        if (b == 0) return a;

        return gcdEuclid(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print(gcdEuclid(a, b));
    }
}
