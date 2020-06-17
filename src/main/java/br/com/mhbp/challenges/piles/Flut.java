package br.com.mhbp.challenges.piles;

import java.math.BigDecimal;

public class Flut {
    private final int orderNumber;

    private final BigDecimal buyingPrice;

    public Flut(int orderNumber, BigDecimal buyingPrice) {
        this.orderNumber = orderNumber;
        this.buyingPrice = buyingPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public BigDecimal getProfit() {
        return getSellingPrice().subtract(buyingPrice);
    }

    private static final BigDecimal SELLING_PRICE = BigDecimal.TEN;

    public static BigDecimal getSellingPrice() {
        return SELLING_PRICE;
    }


}
