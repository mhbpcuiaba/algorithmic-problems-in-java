package br.com.mhbp.challenges.piles;
import java.util.List;
import java.util.concurrent.Future;

public class OutputHandler {

    private static final String ZERO_ITEMS_TO_BUY = "0";

    private static final int MAX_NUMBER_OF_FLUTS_TO_SHOW = 10;

    public void printTestCaseResults(List<Future<TestCaseOutput>> testCaseResults) {
        testCaseResults.forEach(testCaseResult -> {
            try {
                List<OptimizationResult> optimizationResults = testCaseResult.get().getOptimizationResults();
                printOptimizationResults(optimizationResults);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void printOptimizationResults(List<OptimizationResult> optimizationResults) {
        optimizationResults.forEach(result -> {
            System.out.printf("schuurs %d\n", result.getPileNumber());
            System.out.printf("Maximum profit is %2.0f.\n", result.getProfit().floatValue());

            printNumberOfFluts(result);
            System.out.println();
        });
        System.out.println();
    }

    private void printNumberOfFluts(OptimizationResult optimizationResult) {
        System.out.print("Number of fluts to buy: ");
        if (!optimizationResult.isPositiveProfit()) {
            System.out.print(ZERO_ITEMS_TO_BUY);
        } else if (optimizationResult.isNumberOfFlutsUniquelyDetermined()) {
            System.out.printf("%d", optimizationResult.getNumberOfFlutsToBuy());
        } else {
            optimizationResult.getOrderOfFlutsToBuy(MAX_NUMBER_OF_FLUTS_TO_SHOW).forEach(number -> {
                System.out.printf("%d ", number);
            });
        }
    }
}