package com.pluralsight.basicoop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
//        useValueObjectEquality();

//        Map<Integer, String> map1 = new HashMap<>();
//        map1.put(50, "Meaning of life");
//        Integer key = 50;
//        System.out.println(key + " -> " + map1.getOrDefault(key, "nothing, really..."));
//
//        Map<Money, String> map2 = new HashMap<>();
//        map2.put(new Money(new BigDecimal("50"), new Currency("USD")), "Cost of life");
//        Money money = new Money(new BigDecimal("50"), new Currency("USD"));
//        System.out.println(money + " -> " + map2.getOrDefault(money, "nothing, really..."));

        final Currency c1 = new Currency("USD");
        final Money m1 = new Money(new BigDecimal("50"), c1);
        final Money m2 = new Money(new BigDecimal("50"), c1);
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());
    }

    private void useValueObjectEquality() {
        final Currency eur = new Currency("EUR");
        final Money euro20 = new Money(new BigDecimal("20"), eur);
        final Euro euro20de = new Euro(new BigDecimal("20"), eur, "de");
        System.out.println(euro20.equals(euro20de));
        System.out.println(euro20de.equals(euro20));
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
