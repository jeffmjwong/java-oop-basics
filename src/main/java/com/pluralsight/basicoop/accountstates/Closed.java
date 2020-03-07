package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Closed implements AccountState {
    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        return this;
    }

    @Override
    public AccountState withdraw() {
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
