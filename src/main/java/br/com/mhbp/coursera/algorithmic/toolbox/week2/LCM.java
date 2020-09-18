package br.com.mhbp.coursera.algorithmic.toolbox.week2;

import java.math.BigInteger;
import java.util.Scanner;

public class LCM {


    public static BigInteger lcm(int a, int b) {
        BigInteger biA = new BigInteger(String.valueOf(a));
        BigInteger biB = new BigInteger(String.valueOf(b));
        BigInteger gcd = biA.gcd(biB);
        BigInteger product = biA.multiply(biB).abs();
        return product.divide(gcd);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
