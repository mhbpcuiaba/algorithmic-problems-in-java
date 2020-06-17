package br.com.mhbp.dynamic.programming;

import java.util.LinkedList;

public class ChangeMakingProblem {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5};
        int amount = 11;

    }


}

class ChangeMakingTopDownApproach {


    private int miniumAmountOfCoinNeedIt(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        return coinChange(coins, amount, new int [amount + 1]);
    }

    private int coinChange(int[] coins, int remainder, int[] solutionSpace) {

        if (remainder < 0) {
            return -1;
        }

        //The minimum coins needed to make change for 0 is always 0 coins
        if (remainder == 0) {
            return 0;
        }

        if (solutionSpace[remainder] != 0) { //already computed it
            return solutionSpace[remainder];
        }

        int minimum = Integer.MAX_VALUE;


        //try each coin as the last coin in the change that we make for the amount
        for (int coin : coins) {
            int changeResult = coinChange(coins, remainder - coin, solutionSpace);

            /*
             If making change was possible (changeResult >= 0) and the change result beats our present minimum Then
                add one to that smallest value
            */
            if (changeResult >= 0 && changeResult < minimum) {
                minimum = 1 + changeResult;
            }
        }

        solutionSpace[remainder] = (minimum == Integer.MAX_VALUE) ? -1 : minimum;
        return solutionSpace[remainder];
    }
}