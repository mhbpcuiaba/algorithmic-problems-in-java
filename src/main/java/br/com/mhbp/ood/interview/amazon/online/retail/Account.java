package br.com.mhbp.ood.interview.amazon.online.retail;


import javax.swing.*;
import java.util.Set;

/*
There are two types of registered accounts in the system: one will be an Admin,
who is responsible for adding new product categories and blocking/unblocking members;
the other, a Member, who can buy/sell products.
 */
public abstract class Account {

    private String userName;
    private String password;
    private AccountStatus status;
    private String name;
    private ShippingAddress address;
    private String email;
    private String phone;
    private Set<CreditCard> creditCards;
    private Set<EletronicBankTransfer> bankAccounts;


    void addProduct(Product p) {}
    void addProductReview(ProductReview pr, Product p) {}
    public boolean resetPassword(){ return false; }
}
