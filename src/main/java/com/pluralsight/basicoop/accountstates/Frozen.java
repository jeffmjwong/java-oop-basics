package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;
import com.pluralsight.basicoop.AccountUnfrozen;

public class Frozen implements AccountState {
    private AccountUnfrozen onUnfrozen;

    public Frozen(AccountUnfrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public AccountState deposit(Runnable addToBalance) {
        addToBalance.run();
        onUnfrozen.handle();
        return this;
    }

    @Override
    public AccountState withdraw(Runnable subtractFromBalance) {
        subtractFromBalance.run();
        onUnfrozen.handle();
        return this;
    }

    @Override
    public AccountState verifyHolder() {
        return this;
    }

    @Override
    public AccountState closeAccount() {
        return new Closed();
    }

    @Override
    public AccountState freezeAccount() {
        return this;
    }
}
