package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Currency implements Comparable<Currency> {
    private String symbol;

    public Currency(String symbol) {
        this.symbol = symbol;
    }

    public Money zero() {
        return new Money(BigDecimal.ZERO, this);
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    @Override
    public int compareTo(Currency otherCurrency) {
        return this.symbol.compareTo(otherCurrency.symbol);
    }
}
