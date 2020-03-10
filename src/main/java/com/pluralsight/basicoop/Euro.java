package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Euro extends Money {
    private String iso2Country;

    public Euro(BigDecimal amount, Currency currency, String iso2Country) {
        super(amount, currency);
        this.iso2Country = iso2Country;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + iso2Country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Euro && equals((Euro) obj);
    }

    private boolean equals(Euro otherEuro) {
        return super.equals(otherEuro) && iso2Country.equals(otherEuro.iso2Country);
    }

    @Override
    public String toString() {
        return super.toString() + " (" + iso2Country + ")";
    }
}
