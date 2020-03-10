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
    public boolean equals(Object obj) {
        return obj instanceof Currency && equals((Currency) obj);
    }

    public boolean equals(Currency otherCurrency) {
        return symbol.equals(otherCurrency.symbol);
    }

    @Override
    public int compareTo(Currency otherCurrency) {
        return this.symbol.compareTo(otherCurrency.symbol);
    }
}
