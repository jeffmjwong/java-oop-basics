package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Active implements AccountState {
    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        addToBalance.accept(new BigDecimal("55"));
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
