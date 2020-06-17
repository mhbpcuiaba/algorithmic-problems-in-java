package br.com.mhbp.challenges.piles;


import java.util.List;
import java.util.concurrent.Callable;

public class OptimizationTask implements Callable<TestCaseOutput> {

    private final TestCaseInput testCaseInput;

    public OptimizationTask(TestCaseInput testCaseInput) {
        this.testCaseInput = testCaseInput;
    }

    @Override
    public TestCaseOutput call() throws Exception {
        PileFactory pileFactory = new PileFactory();
        List<Pile> piles = pileFactory.createPiles(testCaseInput.getPriceTable());
        ProfitOptimizer profitOptimizer = new ProfitOptimizer(piles);
        List<OptimizationResult> optimizationResults = profitOptimizer.optimize();
        return new TestCaseOutput(optimizationResults);
    }
}