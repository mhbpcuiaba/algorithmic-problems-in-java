package br.com.mhbp.coursera.algorithmic.toolbox.week6;

import java.util.*;

public class Knapsack {

    /*20
    Input:
20 4
5 7 12 18

Your output:
24

Correct output:
19


10 5
3 5 3 3 5

10



Input:
20 4
5 7 12 18

Your output:
17

Correct output:
19




    * */
    static int optimalWeight(int W, int[] items) {

//        Arrays.sort(items);

        int[][] dp = new int [items.length + 1] [W + 1] ;

        //if we only one bar we tale since the capacity 'W' still greater or equal than the weight's bar
//        for (int i = 1; i <= W; i++) {
//            if (items[0] <= W)
//                dp[0][i] = items[0];
//        }

//        System.out.println("start processing");
//        print(dp);
        for (int i = 1; i <= items.length; i++) {

            for (int w = 1; w <= W ; w++) {

                dp[i][w] = dp[i - 1][w];

                if (items[i -1] <= w) {

                    int current = dp[i - 1][w - items[i -1]] + items[i -1];
                    if (current > dp[i][w]) {
                        dp[i][w] = current;
                    }
                }

            }
        }
//        print(dp);
//        System.out.println();
        return dp[items.length][W];//check
    }

    static void printBars(int[] bars) {


        System.out.print("       ");
        for (int i = 0; i < bars.length ; i++)
             System.out.print( i +" ");

        System.out.println();
        System.out.print(" bars: ");
        for (int i = 0; i < bars.length ; i++) {
            System.out.print(bars[i] + " ");
        }
        System.out.println();
    }
    static void print(int[][] dp) {

        for (int j = 0; j < dp[0].length; j++){
            if ( j > 9)
                System.out.print(j + " ");
            else
                System.out.print(j + "  ");
        }

        System.out.println("--------------------");
        System.out.println();
        for (int i = 0; i < dp.length ; i++) { //column
            System.out.println();
            for (int j = 0; j < dp[0].length; j++) { //row
                if (dp[i][j] > 9)
                    System.out.print(dp[i][j] + " ");
                else
                    System.out.print(dp[i][j] + "  ");
            }
            System.out.println();

        }
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
