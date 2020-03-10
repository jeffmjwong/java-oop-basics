package com.pluralsight.basicoop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money implements Comparable<Money> {
    private BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
    }

    public Money scale(double factor) {
        return new Money(amount.multiply(new BigDecimal(factor)), currency);
    }

    public Money add(Money otherMoney) {
        if (currency.compareTo(otherMoney.currency) != 0) {
            throw new IllegalArgumentException();
        }

        return new Money(amount.add(otherMoney.amount), currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public int hashCode() {
        return amount.hashCode() * 17 + currency.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && equals((Money) obj);
    }

    private boolean equals(Money otherMoney) {
        return amount.equals(otherMoney.amount) && currency.equals(otherMoney.currency);
    }

    @Override
    public int compareTo(Money otherMoney) {
        return compareAmountTo(currency.compareTo(otherMoney.currency), otherMoney);
    }

    private int compareAmountTo(final int currencyCompare, final Money otherMoney) {
        return currencyCompare == 0 ? amount.compareTo(otherMoney.amount) : currencyCompare;
    }
}
