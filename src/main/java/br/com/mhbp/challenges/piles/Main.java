package br.com.mhbp.challenges.piles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
Test input samples: [12 3 10 7 16 5] and [[7 3 11 9 10] [1 2 3 4 10 16 10 4 16]]
 */
public class Main {

    private static final String END_OF_INPUT = "0";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputHandler inputHandler = new InputHandler();
            List<Future<TestCaseOutput>> testCaseResults = new ArrayList<>();

            String ch = scanner.nextLine();

            while (!ch.equals(END_OF_INPUT)) {
                int numberOfPiles = Integer.parseInt(ch);
                List<List<Integer>> priceTable = inputHandler.readTestCase(scanner, numberOfPiles);
                TestCaseInput testCaseInput = new TestCaseInput(priceTable);
                OptimizationTask optimizationTask = new OptimizationTask(testCaseInput);
                FutureTask<TestCaseOutput> futureTask = new FutureTask<>(optimizationTask);
                testCaseResults.add(futureTask);
                Thread thread = new Thread(futureTask);
                thread.start();
                ch = scanner.nextLine();
            }
            OutputHandler outputHandler = new OutputHandler();
            outputHandler.printTestCaseResults(testCaseResults);
        }
    }

}