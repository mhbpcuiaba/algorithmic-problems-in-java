package br.com.mhbp.challenges.trading;

import java.util.*;
import java.util.stream.Collectors;

public class TimboektoeTrader {

    private static final Integer GAME_OVER = 0;
    private static final int MAX_FLUTS_TO_SHOW = 10;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer numberOfPiles = Integer.parseInt(scanner.nextLine());
            int schuurs = 1;
            List<List<CalculatedOptimalsTrades>> resultFinal = new ArrayList<>();
            while (numberOfPiles != GAME_OVER) {

                List<List<Integer>> pilesOfFlutes = readPilesOfFlutes(scanner, numberOfPiles);

                List<CalculatedOptimalsTrades> process = new OptimizationTask().process(pilesOfFlutes, schuurs++);
                resultFinal.add(process);

                numberOfPiles = Integer.parseInt(scanner.nextLine());
            }
            printResult(resultFinal);
        }
    }

    public static List<List<Integer>> readPilesOfFlutes(Scanner scanner, int numberOfPiles) {
        List<List<Integer>> listOfPileOfFlut = new ArrayList<>();

        for (int i = 0; i < numberOfPiles; i++) {

            List<Integer> pileOfFlut = new ArrayList<>();

            String priceLine = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(priceLine);
            while (tokenizer.hasMoreTokens()) {
                pileOfFlut.add(Integer.parseInt(tokenizer.nextToken()));
            }
            listOfPileOfFlut.add(pileOfFlut);
        }
        return listOfPileOfFlut;
    }

    public static void printResult(List<List<CalculatedOptimalsTrades>> testCaseResults) {

        for (List<CalculatedOptimalsTrades> testCaseResult : testCaseResults) {
            for (CalculatedOptimalsTrades calculatedOptimalsTrades : testCaseResult) {

                System.out.printf("schuurs %d\n", calculatedOptimalsTrades.getPileNumber());
                System.out.printf("Maximum profit is %d.\n", calculatedOptimalsTrades.getProfit());
                System.out.print("Number of fluts to buy: ");
                if (!calculatedOptimalsTrades.isPositiveProfit()) {
                    System.out.print(0);
                } else {
                    calculatedOptimalsTrades.getOrderOfFlutsToBuy(MAX_FLUTS_TO_SHOW).forEach(number -> {
                        System.out.printf("%d ", number);
                    });
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

class OptimizationTask {

    public List<CalculatedOptimalsTrades> process(List<List<Integer>> priceTable, int schuurs) {

        List<Pile> piles = createPiles(priceTable);
        ProfitOptimizer profitOptimizer = new ProfitOptimizer(piles);
        List<CalculatedOptimalsTrades> calculatedOptimalsTrades = profitOptimizer.optimize(schuurs);

        return calculatedOptimalsTrades;
    }

    private List<Pile> createPiles(List<List<Integer>> listOfPileFlut) {

        List<Pile> piles = new ArrayList<>();

        for (List<Integer> pileOfFlut: listOfPileFlut) {
            List<Flut> fluts = new ArrayList<>();
            List<Integer> boxes = pileOfFlut.subList(1, pileOfFlut.size());
            int flutNumber = 1;
            for (int price: boxes) {
                Flut flut = new Flut(flutNumber++, price);
                fluts.add(flut);
            }

            Pile pile = new Pile(pileOfFlut.get(0), fluts);
            piles.add(pile);
        }

        return piles;
    }
}

class ProfitOptimizer {

    private final List<Pile> piles;

    public ProfitOptimizer(List<Pile> piles) {
        this.piles = piles;
    }

    public List<CalculatedOptimalsTrades> optimize(int schuurs) {

        List<CalculatedOptimalsTrades> calculatedOptimalsTradesList = new ArrayList<>();
        List<List<FlutOrderNumberAndProfit>> allMaxAccumulatedProfitFromAllPiles = new ArrayList<>();

        for (Pile pile : piles) {

            List<FlutOrderNumberAndProfit> flutOrderNumberAndProfits = new ArrayList<>();
            flutOrderNumberAndProfits.addAll(calculateFinancialResults(pile));
            OptionalInt max = flutOrderNumberAndProfits.stream().mapToInt(fr -> fr.getProfit()).max();
            int maxAccumulatedProfit = max.getAsInt();
            List<FlutOrderNumberAndProfit> allMaxAccumulatedProfitFromPile = flutOrderNumberAndProfits.stream().filter(fr -> fr.getProfit() == maxAccumulatedProfit).collect(Collectors.toList());
            allMaxAccumulatedProfitFromAllPiles.add(allMaxAccumulatedProfitFromPile);
        }

        CalculatedOptimalsTrades calculatedOptimalsTrades = new CalculatedOptimalsTrades(schuurs, allMaxAccumulatedProfitFromAllPiles);
        calculatedOptimalsTradesList.add(calculatedOptimalsTrades);
        return calculatedOptimalsTradesList;
    }

    private List<FlutOrderNumberAndProfit> calculateFinancialResults(Pile pile) {

        return pile.getFluts()
                .stream()
                .map(flut -> {

                    int accumulatedProfit = pile.getFluts()
                            .stream()
                            .filter(f -> f.getOrderNumber() <= flut.getOrderNumber())
                            .map(Flut::getProfit)
                            .reduce(0, (a, b) -> a + b);

                    FlutOrderNumberAndProfit flutOrderNumberAndProfit = new FlutOrderNumberAndProfit(flut.getOrderNumber(), accumulatedProfit);
                    return flutOrderNumberAndProfit;
                })
                .collect(Collectors.toList());
    }
}

class Pile {
    private final int boxesInPile;

    private final List<Flut> fluts;

    public Pile(int boxesInPile, List<Flut> fluts) {
        this.boxesInPile = boxesInPile;
        this.fluts = fluts;
    }

    public List<Flut> getFluts() {
        return fluts;
    }

    public int getBoxesInPile() {
        return boxesInPile;
    }
}

class Flut {

    private final int orderNumber;

    private final int buyingPrice;

    public Flut(int orderNumber, int buyingPrice) {
        this.orderNumber = orderNumber;
        this.buyingPrice = buyingPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getProfit() {
        return 10 - buyingPrice ;
    }
}

class CalculatedOptimalsTrades {
    private final int pileNumber;

    private final int profit;

    private final List<Integer> orderOfFlutsToBuy;

    public CalculatedOptimalsTrades(int pileNumber, List<List<FlutOrderNumberAndProfit>> allMaxAccumulatedProfitFromAllPiles) {
        this.pileNumber = pileNumber;
        this.profit = calculateTotalProfit(allMaxAccumulatedProfitFromAllPiles);
        this.orderOfFlutsToBuy = get10FirstSolutions(allMaxAccumulatedProfitFromAllPiles);
    }

    private int calculateTotalProfit(List<List<FlutOrderNumberAndProfit>> allMaxAccumulatedProfitFromAllPiles) {
        int totalAccumulatedProfit = 0;

        for (List<FlutOrderNumberAndProfit> allMaxAccumulatedProfitFromPile : allMaxAccumulatedProfitFromAllPiles) {
            totalAccumulatedProfit += allMaxAccumulatedProfitFromPile.get(0).getProfit();
        }

        return totalAccumulatedProfit;
    }

    private List<Integer> get10FirstSolutions(List<List<FlutOrderNumberAndProfit>> allMaxAccumulatedProfitFromAllPiles) {
        Set<Integer> result = new HashSet();

        for (List<FlutOrderNumberAndProfit> allMaxAccumulatedProfitFromPile : allMaxAccumulatedProfitFromAllPiles) {

            if (result.isEmpty()) {
                for (FlutOrderNumberAndProfit flutOrderNumberAndProfit : allMaxAccumulatedProfitFromPile) {
                    result.add(flutOrderNumberAndProfit.getFlutOrderNumber());
                }
            } else {
                Set<Integer> resultNew = new HashSet();
                for (FlutOrderNumberAndProfit flutOrderNumberAndProfit : allMaxAccumulatedProfitFromPile) {
                    for (Integer value : result) {
                        resultNew.add(value + flutOrderNumberAndProfit.getFlutOrderNumber());
                    }
                }

                result = resultNew;
            }


        }
        return result.stream().collect(Collectors.toList());
    }

    public int getPileNumber() {
        return pileNumber;
    }

    public int getProfit() {
        return profit;
    }


    public List<Integer> getOrderOfFlutsToBuy(int maxSize) {
        return orderOfFlutsToBuy.stream()
                .limit(maxSize)
                .collect(Collectors.toList());
    }

    public boolean isPositiveProfit() {
        return getProfit() > 0;
    }

}

class FlutOrderNumberAndProfit {
    private final int flutOrderNumber;
    private final int profit;

    public FlutOrderNumberAndProfit(int flutOrderNumber, int profit) {
        this.flutOrderNumber = flutOrderNumber;
        this.profit = profit;
    }

    public int getFlutOrderNumber() {
        return flutOrderNumber;
    }

    public int getProfit() {
        return profit;
    }
}