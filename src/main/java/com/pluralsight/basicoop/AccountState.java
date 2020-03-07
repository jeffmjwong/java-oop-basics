package com.pluralsight.basicoop;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {
    AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);
    AccountState withdraw();
    AccountState verifyHolder();
    AccountState closeAccount();
    AccountState freezeAccount();
}
