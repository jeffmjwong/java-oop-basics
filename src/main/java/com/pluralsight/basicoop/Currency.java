package com.pluralsight.basicoop;

import java.math.BigDecimal;

public final class Currency implements Comparable<Currency> {
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
        return obj != null && getClass() == obj.getClass() && equals((Currency) obj);
    }

    private boolean equals(Currency otherCurrency) {
        return symbol.equals(otherCurrency.symbol);
    }

    @Override
    public int compareTo(Currency otherCurrency) {
        return this.symbol.compareTo(otherCurrency.symbol);
    }
}
