package br.com.mhbp.challenges.piles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputHandler {

    public List<List<Integer>> readTestCase(Scanner scanner, int numberOfPiles) {
        List<List<Integer>> priceTable = new ArrayList<>();

        for (int i = 0; i < numberOfPiles; i++) {
            List<Integer> priceRow = new ArrayList<>();
            String priceLine = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(priceLine);
            while (tokenizer.hasMoreTokens()) {
                priceRow.add(Integer.parseInt(tokenizer.nextToken()));
            }
            priceTable.add(priceRow);
        }
        return priceTable;
    }

}