package br.com.mhbp.challenges.piles;

import java.math.BigDecimal;

public class FinancialResult {

    private final int flutOrderNumber;

    private final BigDecimal accumulatedProfit;

    public FinancialResult(int flutOrderNumber, BigDecimal accumulatedProfit) {
        this.flutOrderNumber = flutOrderNumber;
        this.accumulatedProfit = accumulatedProfit;
    }

    public int getFlutOrderNumber() {
        return flutOrderNumber;
    }

    public BigDecimal getAccumulatedProfit() {
        return accumulatedProfit;
    }
}