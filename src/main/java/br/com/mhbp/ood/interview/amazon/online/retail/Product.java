package br.com.mhbp.ood.interview.amazon.online.retail;


/*
This class will encapsulate the entity that the users of our system will be buying and selling.
Each Product will belong to a ProductCategory.
 */
public class Product {
    Long id;
    String name;
    Double price;
    Integer availableItemCount;

    ProductCategory productCategory;

    public synchronized Integer getAvailableItemCount()  {
        return availableItemCount;
    }

    public synchronized void sellProduct(int quantity) {

        if (availableItemCount < quantity) {
            throw new InsufficianAvailableProductToSellexception();
        }
        availableItemCount -= quantity;
    }
}
