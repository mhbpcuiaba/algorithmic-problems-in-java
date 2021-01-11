package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStocks {


    public static double buyAndSelStocksOnce(List<Double> prices) {

        double minProfit = Double.MAX_VALUE;
        double maxProfit = 0.0;

        for (int i = 1; i < prices.size(); i++) {
            Double price = prices.get(i);
            maxProfit = Math.max(maxProfit, price - minProfit);
            minProfit = Math.min(minProfit, price);
        }

        return maxProfit;
    }


    public static double buyAndSellStocksTwice(List<Double> prices) {
        double minProfit = Double.MAX_VALUE;
        double maxProfit = 0.0;
        List<Double> firstsBuySellProfits = new ArrayList<>();

        for (int i = 1; i < prices.size(); i++) {
            Double price = prices.get(i);
            maxProfit = Math.max(maxProfit, price - minProfit);
            minProfit = Math.min(minProfit, price);
            firstsBuySellProfits.add(maxProfit);
        }

        double maxPriceSoFar = Double.MIN_VALUE;

        for (int i = 1; i < prices.size(); i++) {
            Double price = prices.get(i);
            maxPriceSoFar = Math.max(maxPriceSoFar, price);
            maxProfit = Math.max(maxProfit, maxPriceSoFar - price + firstsBuySellProfits.get(i));
        }
        return maxProfit;
    }

}
