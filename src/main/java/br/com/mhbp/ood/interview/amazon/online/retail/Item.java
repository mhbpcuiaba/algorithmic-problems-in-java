package br.com.mhbp.ood.interview.amazon.online.retail;

public class Item {
    Product product;
    int quantity;
    double price;

    public Item(Product p, int quantity) {
        this.product = p;
        this.quantity = quantity;
    }
}
