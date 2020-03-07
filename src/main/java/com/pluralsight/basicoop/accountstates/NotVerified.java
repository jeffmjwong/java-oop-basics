package com.pluralsight.basicoop.accountstates;

import com.pluralsight.basicoop.AccountState;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class NotVerified implements AccountState {
    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        addToBalance.accept(amount);
        return this;
    }

    @Override
    public AccountState withdraw() {
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
