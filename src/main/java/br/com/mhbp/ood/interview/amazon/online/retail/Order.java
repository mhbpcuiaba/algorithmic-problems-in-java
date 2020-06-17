package br.com.mhbp.ood.interview.amazon.online.retail;

import java.time.LocalDateTime;
import java.util.Set;

public class Order {

    String orderNumber;
    OrderStatus orderStatus;
    LocalDateTime orderDateTime;
    Set<OrderLog> orderLog;

    boolean sendForShipment() {
        return false;
    }

}
