//package br.com.mhbp.coursera.algorithmic.toolbox.week5;

import java.util.Scanner;

public class ChangeDP {

    static int[] coins = {1, 3, 4};

    private static int getChange(int m) {

        if (m == 1) return 1;
        int[] minNumCoins = new int [m];
        minNumCoins[0] = 0;

        for (int i = 1; i < m; i++) {
            minNumCoins[i] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j]) {
                    int numCoins = minNumCoins[ i - coins[j]] + 1;

                    if (numCoins < minNumCoins[i]) {
                        minNumCoins[i] = numCoins;
                    }
                }
            }
        }

        return minNumCoins[m - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

