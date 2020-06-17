package br.com.mhbp.ood.interview.parkinglot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    Customer customer;
    Ticket ticket;
    LocalDateTime time;
    BigDecimal value;
    PaymentMethodEnum method;
    User registerBy;
}
