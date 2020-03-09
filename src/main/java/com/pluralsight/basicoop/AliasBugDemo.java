package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class AliasBugDemo {
    private void reserve(Money cost) {
        System.out.println("Reserving an item costing " + cost);
    }

    private void buy(Money wallet, Money cost) {
        final boolean hasEnoughMoney = wallet.compareTo(cost) >= 0;
        reserve(cost);

        if (hasEnoughMoney) {
            System.out.println("You will pay " + cost + " with your " + wallet);
        } else {
            System.out.println("You cannot pay " + cost + " with your " + wallet);
        }
    }

    public void run() {
        final Money m1 = new Money(new BigDecimal("20"), new Currency("d"));
        reserve(m1);
    }
}
