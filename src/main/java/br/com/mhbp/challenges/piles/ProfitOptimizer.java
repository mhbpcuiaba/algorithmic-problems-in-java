package br.com.mhbp.challenges.piles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProfitOptimizer {

    private final List<Pile> piles;

    public ProfitOptimizer(List<Pile> piles) {
        this.piles = piles;
    }

    public List<OptimizationResult> optimize() {

        List<OptimizationResult> optimizationResults = new ArrayList<>();

        piles.forEach( pile -> {

            List<FinancialResult> financialResults = calculateFinancialResults(pile);

            FinancialResult optimalFinancialResult = findOptimalFinancialResult(financialResults);

            List<Integer> orderOfFlutsToBuy = findOrderOfFlutsToBuy(financialResults, optimalFinancialResult);
            boolean isNumberOfFlutesUniquelyDetermined = isNumberOfFlutsUniquelyDetermined(financialResults, optimalFinancialResult);

            OptimizationResult optimizationResult = new OptimizationResult(pile.getOrderNumber(), optimalFinancialResult.getAccumulatedProfit(), isNumberOfFlutesUniquelyDetermined, orderOfFlutsToBuy);
            optimizationResults.add(optimizationResult);
        });

        return optimizationResults;
    }

    private List<FinancialResult> calculateFinancialResults(Pile pile) {
        return pile.getFluts()
                .stream()
                .map(flut -> {

                    BigDecimal accumulatedProfit = pile.getFluts().stream()
                            .filter(f -> f.getOrderNumber() <= flut.getOrderNumber())
                            .map(Flut::getProfit)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    return new FinancialResult(flut.getOrderNumber(), accumulatedProfit);
                })
                .collect(Collectors.toList());
    }

    private FinancialResult findOptimalFinancialResult(List<FinancialResult> financialResults) {
        return financialResults.stream()
                .filter(result -> {
                    BigDecimal maxProfit = financialResults.stream()
                            .map(FinancialResult::getAccumulatedProfit)
                            .max(BigDecimal::compareTo)
                            .orElseThrow(() -> new IllegalStateException("Max profit not found"));

                    return result.getAccumulatedProfit().compareTo(maxProfit) == 0;
                })
                .min(Comparator.comparing(FinancialResult::getFlutOrderNumber, Integer::compareTo))
                .orElseThrow(() -> new IllegalStateException("Optimal financial result not found"));
    }

    private List<Integer> findOrderOfFlutsToBuy(List<FinancialResult> financialResults,
                                                FinancialResult optimalFinancialResult) {
        return financialResults.stream()
                .map(FinancialResult::getFlutOrderNumber)
                .filter(orderNumber -> orderNumber <= optimalFinancialResult.getFlutOrderNumber())
                .collect(Collectors.toList());
    }

    private boolean isNumberOfFlutsUniquelyDetermined(List<FinancialResult> financialResults,
                                                      FinancialResult optimalFinancialResult) {
        return financialResults.stream()
                .map(FinancialResult::getAccumulatedProfit)
                .filter(profit -> profit.compareTo(optimalFinancialResult.getAccumulatedProfit()) == 0)
                .count() == 1;
    }
}
