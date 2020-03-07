package com.pluralsight.basicoop;

public class FreezableActive implements Freezable {
    @Override
    public Freezable deposit() {
        return stayUnfrozen();
    }

    @Override
    public Freezable withdraw() {
        return stayUnfrozen();
    }

    @Override
    public Freezable freezeAccount() {
        return new FreezableFrozen(new AccountUnfrozen());
    }

    private Freezable stayUnfrozen() {
        System.out.println("Account is active!");
        return this;
    }
}
