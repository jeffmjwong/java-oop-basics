package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;

public class Frozen implements AccountState {
    @Override
    public AccountState deposit(Runnable addToBalance) {
        addToBalance.run();
        return this;
    }

    @Override
    public AccountState withdraw(Runnable subtractFromBalance) {
        subtractFromBalance.run();
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
