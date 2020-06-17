package br.com.mhbp.ood.interview.amazon.online.retail;

public abstract class Customer {

    ShoppingCart shoppingCart;
    Order order;

    ShoppingCart getShoppingCar() {
        return shoppingCart;
    }

    public boolean addItemToCart(Item item) {
        return shoppingCart.addItem(item);
    }

}
