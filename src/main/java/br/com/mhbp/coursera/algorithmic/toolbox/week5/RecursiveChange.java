package br.com.mhbp.coursera.algorithmic.toolbox.week5;

public class RecursiveChange {



    int recursiveChange(int money, int[] coins) {

        if (money == 0) return 0;

        int minNumCoins = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= money) {
                int numCoins = recursiveChange(money - coins[i], coins);
                if (numCoins + 1 < minNumCoins) {
                    minNumCoins = numCoins + 1;
                }
            }
        }

        return minNumCoins;
    }
}
