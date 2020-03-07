package com.pluralsight.basicoop;

public class FreezableFrozen implements Freezable {
    @Override
    public Freezable deposit() {
        return new FreezableActive();
    }

    @Override
    public Freezable withdraw() {
        return new FreezableActive();
    }

    @Override
    public Freezable freezeAccount() {
        return this;
    }
}
