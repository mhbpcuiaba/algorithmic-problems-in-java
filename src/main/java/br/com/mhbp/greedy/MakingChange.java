package br.com.mhbp.greedy;

public class MakingChange {

    int numCoinsChange(int cents) {
        int numCoins = 0;
        int[] coins = { 100, 50, 25 , 10, 5, 1};


        for (int i = 0; i < coins.length && cents > 0; i++) {
            numCoins += cents/coins[i];
            cents %= coins[i];
        }

        return numCoins;
    }
}
