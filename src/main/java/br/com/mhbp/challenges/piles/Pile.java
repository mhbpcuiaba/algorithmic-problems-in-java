package br.com.mhbp.challenges.piles;

import java.util.List;

public class Pile {

    private final int orderNumber;

    private final List<Flut> fluts;

    public Pile(int orderNumber, List<Flut> fluts) {
        this.orderNumber = orderNumber;
        this.fluts = fluts;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Flut> getFluts() {
        return fluts;
    }
}