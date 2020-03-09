package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class AliasBugDemo {
    private boolean isHappyHour;

    private void reserve(final Money cost) {
        if (isHappyHour) {
            cost.scale(0.5);
        }

        System.out.println("Reserving an item costing " + cost);
    }

    private void buy(final Money wallet,final Money cost) {
        reserve(cost);
        final boolean hasEnoughMoney = wallet.compareTo(cost) >= 0;

        if (hasEnoughMoney) {
            System.out.println("You will pay " + cost + " with your " + wallet);
        } else {
            System.out.println("You cannot pay " + cost + " with your " + wallet);
        }
    }

    public void run() {
        final Currency usd = new Currency("USD");
        final Money usd30 = new Money(new BigDecimal("30"), usd);
        final Money usd20 = new Money(new BigDecimal("20"), usd);
        final Money usd10 = new Money(new BigDecimal("10"), usd);

        buy(usd30, usd20);
        System.out.println();
        isHappyHour = true;
        buy(usd10, usd20);
    }
}
