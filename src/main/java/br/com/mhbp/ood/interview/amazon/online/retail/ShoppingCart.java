package br.com.mhbp.ood.interview.amazon.online.retail;

import java.util.Set;

/*
Users will add product items that they intend to buy to the shopping cart.
 */
public class ShoppingCart {
    Long idAccount;
    Set<Item> items;
    TransactionManager transactionManager;


    void addItem(Product p, int quantity) {
        items.add( new Item(p, quantity));
    }

    boolean addItem(Item item) {
        return items.add( item);
    }

    boolean removeItem(Item i) {
        return items.remove(i);
    }

    void modify(Item item, int newQuantity) {
        items.forEach( i -> {
            if ( i.equals(item)) {
                i.quantity = item.quantity;
            }
        });
    }

    boolean buyItemsOnShoppingCartWithCreditCard(CreditCard cc) {
        CreditCardTransaction cct = transactionManager.buyItems(items, cc);
        return  cct.status.equals(PaymentStatus.COMPLETED);
    }
}
