package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;

public class NotVerified implements AccountState {
    @Override
    public AccountState deposit(Runnable addToBalance) {
        addToBalance.run();
        return this;
    }

    @Override
    public AccountState withdraw(Runnable subtractFromBalance) {
        return this;
    }

    @Override
    public AccountState verifyHolder() {
        return new Active();
    }

    @Override
    public AccountState closeAccount() {
        return new Closed();
    }

    @Override
    public AccountState freezeAccount() {
        return new Frozen();
    }
}
