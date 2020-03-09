package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class AliasBugDemo {
    private void reserve(Money cost) {
        System.out.println("Reserving an item costing " + cost);
    }

    private void buy(Money wallet, Money cost) {

    }

    public void run() {
        final Money m1 = new Money(new BigDecimal("20"), new Currency("d"));
        reserve(m1);
    }
}
