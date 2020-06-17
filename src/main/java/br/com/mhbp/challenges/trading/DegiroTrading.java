package br.com.mhbp.challenges.trading;

import java.util.*;
import java.util.stream.Collectors;

public class DegiroTrading {
    private static final int SELLING_PRICE_OF_EACH_FLUTE = 10;
    private static final int SIZE_OF_LIST_OF_NO_OF_IDENTIFIED_FLUTS = 10;

    public static void main(String[] args) {
        List<InputFormat> inputList = readInput();

        processOutput(inputList);
    }

    private static void processOutput(List<InputFormat> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            InputFormat input = inputList.get(i);
            if (i > 0) {
                System.out.println();
            }
            System.out.println("schuurs " + input.getNoOfPiles());
            processEachTestCase(input);
        }

    }

    private static void processEachTestCase(InputFormat input) {
        /*
           L1: 5  7  3 11  9 10
           L2: 9  1  2  3  4 10  16  10  4  16
         */
        for (InputFormat.PileOfFlut pileOfFluts : input.getPileOfFluts()) {
            processEachLine(pileOfFluts);
        }

    }

    private static void processEachLine(InputFormat.PileOfFlut pileOfFluts) {

        int totalNoOfFLuts = pileOfFluts.getNumberOfBoxes();
        List<Integer> fluts = pileOfFluts.getFluts();

        int maxProfit = 0;
        PriorityQueue<Integer> listOfNoOfFluts = null;

        for (int i = 1; i <= totalNoOfFLuts; i++) {

            int totalPriceOfFluts = 0;
            for (int j = 0; j < i; j++) {
                totalPriceOfFluts = totalPriceOfFluts + fluts.get(j);

            }
            int profit = (i * SELLING_PRICE_OF_EACH_FLUTE) - totalPriceOfFluts;
            if (profit > 0) {
                if (profit > maxProfit) {
                    maxProfit = profit;
                    listOfNoOfFluts = new PriorityQueue<>((a,b)->Integer.compare(b, a));
                    if (listOfNoOfFluts.size() > SIZE_OF_LIST_OF_NO_OF_IDENTIFIED_FLUTS) {
                        listOfNoOfFluts.poll();
                    }
                    listOfNoOfFluts.add(i);
                } else if (profit == maxProfit) {
                    listOfNoOfFluts.add(i);
                }
            }
        }
        System.out.println("Maximum profit is " + maxProfit);

        Set<Integer> setOfNumbers=new TreeSet<>((a,b)->Integer.compare(a,b));
        setOfNumbers.addAll(listOfNoOfFluts);
        System.out.println("Number of fluts to buy: " + setOfNumbers.stream().map(a->Integer.toString(a)).collect(Collectors.joining(" ")));
    }

    private static List<InputFormat> readInput() {
        List<InputFormat> inputFormatList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        // int caseNumber = 1;
        while (!line.startsWith("0")) {
            InputFormat input = new InputFormat();
            int noOfSchurrs = Integer.parseInt(line);
            // input.setTestCaseNumber(caseNumber);
            input.setNoOfPiles(noOfSchurrs);
            List<InputFormat.PileOfFlut> plieOfFlutsList = new ArrayList<>();
            for (int i = 0; i < noOfSchurrs; i++) {
                InputFormat.PileOfFlut pileOfFLut = input.new PileOfFlut();
                String[] pileOfFluts = scanner.nextLine().trim().split(" ");
                int noOfFluts = Integer.parseInt(pileOfFluts[0]);
                pileOfFLut.setNumberOfBoxes(noOfFluts);
                List<Integer> fluts = new ArrayList<>();
                for (int j = 1; j <= noOfFluts; j++) {
                    fluts.add(Integer.parseInt(pileOfFluts[j]));
                }
                pileOfFLut.setFluts(fluts);
                plieOfFlutsList.add(pileOfFLut);
            }
            input.setPileOfFluts(plieOfFlutsList);
            line = scanner.nextLine().trim();
            inputFormatList.add(input);
        }
        scanner.close();
        return inputFormatList;

    }
}
