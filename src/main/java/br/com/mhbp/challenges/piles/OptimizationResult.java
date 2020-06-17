package br.com.mhbp.challenges.piles;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OptimizationResult {

    private final int pileNumber;

    private final BigDecimal profit;

    private boolean isNumberOfFlutsUniquelyDetermined;

    private final List<Integer> orderOfFlutsToBuy;

    public OptimizationResult(int pileNumber, BigDecimal profit, boolean isNumberOfFlutsUniquelyDetermined,
                              List<Integer> orderOfFlutsToBuy) {
        this.pileNumber = pileNumber;
        this.profit = profit;
        this.isNumberOfFlutsUniquelyDetermined = isNumberOfFlutsUniquelyDetermined;
        this.orderOfFlutsToBuy = orderOfFlutsToBuy;
    }

    public int getPileNumber() {
        return pileNumber;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public int getNumberOfFlutsToBuy() {
        return orderOfFlutsToBuy.size();
    }

    public boolean isNumberOfFlutsUniquelyDetermined() {
        return isNumberOfFlutsUniquelyDetermined;
    }

    public List<Integer> getOrderOfFlutsToBuy(int maxSize) {
        return orderOfFlutsToBuy.stream()
                .limit(maxSize)
                .collect(Collectors.toList());
    }

    public boolean isPositiveProfit() {
        return getProfit().compareTo(BigDecimal.ZERO) == 1;
    }

}
