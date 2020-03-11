package com.pluralsight.basicoop;

public class Article {
    private Warranty moneyBackGuarantee;
    private Warranty expressWarranty;

    public Article(Warranty moneyBackGuarantee, Warranty expressWarranty) {
        if (moneyBackGuarantee == null || expressWarranty == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null!");
        }

        this.moneyBackGuarantee = moneyBackGuarantee;
        this.expressWarranty = expressWarranty;
    }

    public Warranty getMoneyBackGuarantee() {
        return moneyBackGuarantee;
    }
    public Warranty getExpressWarranty() {
        return expressWarranty;
    }

    public Article withVisibleDamage() {
        return new Article(Warranty.VOID, expressWarranty);
    }
}
