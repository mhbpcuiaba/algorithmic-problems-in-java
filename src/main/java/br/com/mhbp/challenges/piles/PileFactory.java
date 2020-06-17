package br.com.mhbp.challenges.piles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PileFactory {

    private int flutNumber;

    private int pileNumber;

    public List<Pile> createPiles(List<List<Integer>> priceTable) {
        List<Pile> piles = new ArrayList<>();
        for (List<Integer> pilePrices: priceTable) {
            List<Flut> fluts = new ArrayList<>();

            List<Integer> boxes = pilePrices.subList(1, pilePrices.size());
            for (int price: boxes) {
                flutNumber++;
                Flut flut = new Flut(flutNumber, BigDecimal.valueOf(price));
                fluts.add(flut);
            }
            pileNumber++;
            Pile pile = new Pile(pileNumber, fluts);
            piles.add(pile);
        }
        return piles;
    }
}