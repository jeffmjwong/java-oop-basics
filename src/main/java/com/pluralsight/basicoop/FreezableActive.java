package com.pluralsight.basicoop;

public class FreezableActive implements Freezable {
    @Override
    public Freezable deposit() {
        return this;
    }

    @Override
    public Freezable withdraw() {
        return this;
    }

    @Override
    public Freezable freezeAccount() {
        return new FreezableFrozen();
    }
}
