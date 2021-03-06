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


    * */
    static int optimalWeight(int W, int[] items) {

        Arrays.sort(items);
        int[][] dp = new int [items.length] [W + 1] ;

        //if we only one bar we tale since the capacity 'W' still greater or equal than the weight's bar
        for (int i = 1; i <= W; i++) {
            if (items[0] <= W)
                dp[0][i] = items[0];
        }

//        System.out.println("start processing");
//        print(dp);
        for (int i = 1; i < items.length; i++) {
            int currentBar =  items[i];
            for (int w = 1  ; w <= W; w++) {

//5 7 12 18
                if (currentBar > w) {
                    dp[i][w] = dp[i -1][w];
                } else {
//                    System.out.println(" including bar:" + (dp[i-1][w - currentBar] + currentBar));
//
                        int profit1 = dp[i-1][w - currentBar] + currentBar;
                        if (profit1 > W)
                            profit1 = dp[i][w - 1];
                        int profit2 = dp[i-1][w];
                        dp[i][w] = Math.max(profit1, profit2);
                }
            }

//            System.out.println();
//            System.out.println();
//            printBars(items);
//            System.out.println(" solution including up to the item " + i);
//            print(dp);
        }

        System.out.println("finish processing");
//        print(dp);

        return dp[items.length -1][W];
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
