package com.pluralsight.basicoop;

public class FreezableFrozen implements Freezable {
    private AccountUnfrozen onUnfrozen;

    public FreezableFrozen(AccountUnfrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public Freezable deposit() {
        return unfreeze();
    }

    @Override
    public Freezable withdraw() {
        return unfreeze();
    }

    @Override
    public Freezable freezeAccount() {
        return this;
    }

    private Freezable unfreeze() {
        onUnfrozen.handle();
        return new FreezableActive();
    }
}
