package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;

public class Closed implements AccountState {
    @Override
    public AccountState deposit(Runnable addToBalance) {
        return this;
    }

    @Override
    public AccountState withdraw(Runnable subtractFromBalance) {
        return this;
    }

    @Override
    public AccountState verifyHolder() {
        return this;
    }

    @Override
    public AccountState closeAccount() {
        return this;
    }

    @Override
    public AccountState freezeAccount() {
        return this;
    }
}
