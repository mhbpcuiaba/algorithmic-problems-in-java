package br.com.mhbp.coursera.algorithmic.toolbox.week6;

import java.util.*;

public class Knapsack {

    static int optimalWeight(int W, int[] w) {


        int result = 0;
        int[][] dp = new int [W + 1] [w.length + 1];
        Arrays.sort(w);

        /*
            capacity = 10
            items[8, 7, 6, 1, 4] => 5 items


            [ 1 4 6 7 8 ] sorted items
            o 1 2 3 4 5
            1 1 1 1 1 1
            2 1 1 1 1 1
            3 1 1 1 1 1
            4 1 4 4 4 4
            5 1 5 5 5 5
            6 1 5 6 6 6
            7 1 5 7 7 7
            8 1 5 7 8 8
            9 1 5 7 8 9
           10 1 5 10 10 10


         */


        for (int i = 0; i < W; i++) {
            dp[0][i] = i;
        }

        for (int j = 0; j < w.length; j++) {

            if (w[j] < W) {
                dp[j][0] = w[j];
            }

        }

        int capacity = W;

        for (int i = 1; i < W; i++) {
            for (int j = 1; j < w.length; j++) {

                int withoutCurrent = dp[j -1][i - 1];
                int withCurrent = -1;

                if ( w[j] < capacity) {
                    withCurrent  = dp[j -1][i - 1];// ??????
                }

                dp[i][j] = Math.max(withCurrent, withoutCurrent);
            }
        }

        return dp[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
