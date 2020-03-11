package com.pluralsight.basicoop;

import java.time.LocalDate;

public class Article {
    private Warranty moneyBackGuarantee;
    private Warranty expressWarranty;
    private Warranty effectiveExpressWarranty;
    private Part sensor;
    private Warranty extendedWarranty;

    public Article(Warranty moneyBackGuarantee, Warranty expressWarranty) {
        this(moneyBackGuarantee, expressWarranty, Warranty.VOID, null, Warranty.VOID);
    }

    private Article(Warranty moneyBackGuarantee, Warranty expressWarranty, Warranty effectiveExpressWarranty, Part sensor, Warranty extendedWarranty) {
        if (moneyBackGuarantee == null || expressWarranty == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null!");
        }

        this.moneyBackGuarantee = moneyBackGuarantee;
        this.expressWarranty = expressWarranty;
        this.effectiveExpressWarranty = effectiveExpressWarranty;
        this.sensor = sensor;
        this.extendedWarranty = extendedWarranty;
    }

    public Warranty getMoneyBackGuarantee() {
        return moneyBackGuarantee;
    }
    public Warranty getExpressWarranty() {
        return effectiveExpressWarranty;
    }
    public Warranty getExtendedWarranty() {
        return sensor == null ? Warranty.VOID : sensor.apply(extendedWarranty);
    }

    public Article withVisibleDamage() {
        return new Article(Warranty.VOID, expressWarranty, effectiveExpressWarranty, sensor, extendedWarranty);
    }

    public Article nonOperational() {
        return new Article(moneyBackGuarantee, expressWarranty, expressWarranty, sensor, extendedWarranty);
    }

    public Article install(Part sensor, Warranty extendedWarranty) {
        return new Article(moneyBackGuarantee, expressWarranty, effectiveExpressWarranty, sensor, extendedWarranty);
    }

    public Article sensorNotOperational(LocalDate detectedOn) {
        return install(sensor.defective(detectedOn), extendedWarranty);
    }
}
