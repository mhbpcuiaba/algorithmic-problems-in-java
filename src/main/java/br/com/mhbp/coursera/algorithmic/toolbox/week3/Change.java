package br.com.mhbp.coursera.algorithmic.toolbox.week3;

import java.util.Scanner;

public class Change {

    static Integer[] coins = {10, 5, 1};

    private static int getChange(int m) {
        int change = 0;

        for (int i = 0; i < coins.length && m > 0; i++) {
            change += m/coins[i];
            m = m % coins[i];
        }


        //write your code here
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
