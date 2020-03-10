package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class AliasBugDemo {
    private boolean isHappyHour;

    private Money reserve(final Money cost) {
        final Money finalCost = isHappyHour ? cost.scale(0.5) : cost;
        System.out.println("Reserving an item costing " + finalCost);
        return finalCost;
    }

    private void buy(final Money wallet,final Money cost) {
        final boolean hasEnoughMoney = wallet.compareTo(cost) >= 0;
        final Money finalCost = reserve(cost);
        final boolean hasEnoughMoneyFinal = wallet.compareTo(finalCost) >= 0;

        if (!hasEnoughMoney && hasEnoughMoneyFinal) {
            System.out.println("Only this time, you will pay " + finalCost + " with your " + wallet);
        } else if (hasEnoughMoney) {
            System.out.println("You will pay " + finalCost + " with your " + wallet);
        } else {
            System.out.println("You cannot pay " + finalCost + " with your " + wallet);
        }
    }

    public void run() {
//        useAliasBug();

        final Currency eur = new Currency("EUR");
        final Money euro20 = new Money(new BigDecimal("20"), eur);
        final Euro euro20de = new Euro(new BigDecimal("20"), eur, "de");
        System.out.println(euro20 instanceof Money);
        System.out.println(euro20de instanceof Money);
        System.out.println(euro20 instanceof Euro);
        System.out.println(euro20de instanceof Euro);
    }

    private void useAliasBug() {
        final Currency usd = new Currency("USD");
        final Money usd30 = new Money(new BigDecimal("30"), usd);
        final Money usd20 = new Money(new BigDecimal("20"), usd);
        final Money usd10 = new Money(new BigDecimal("10"), usd);

        buy(usd30, usd20);
        System.out.println();

        buy(usd20, usd30);
        System.out.println();

        isHappyHour = true;
        buy(usd20, usd30);
        System.out.println();

        isHappyHour = true;
        buy(usd30, usd10);
    }
}
