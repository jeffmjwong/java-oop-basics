package com.pluralsight.basicoop;

public class Article {
    private Warranty moneyBackGuarantee;
    private Warranty expressWarranty;
    private Warranty effectiveExpressWarranty;

    public Article(Warranty moneyBackGuarantee, Warranty expressWarranty) {
        this(moneyBackGuarantee, expressWarranty, Warranty.VOID);
    }

    private Article(Warranty moneyBackGuarantee, Warranty expressWarranty, Warranty effectiveExpressWarranty) {
        if (moneyBackGuarantee == null || expressWarranty == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null!");
        }

        this.moneyBackGuarantee = moneyBackGuarantee;
        this.expressWarranty = expressWarranty;
        this.effectiveExpressWarranty = effectiveExpressWarranty;
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
