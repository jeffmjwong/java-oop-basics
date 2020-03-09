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

    public void scale(double factor) {
        amount = amount.multiply(new BigDecimal(factor)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public int compareTo(Money otherMoney) {
        return compareAmountTo(currency.compareTo(otherMoney.currency), otherMoney);
    }

    private int compareAmountTo(final int currencyCompare, final Money otherMoney) {
        return currencyCompare == 0 ? amount.compareTo(otherMoney.amount) : currencyCompare;
    }
}
