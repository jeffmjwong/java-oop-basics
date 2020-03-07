package com.pluralsight.basicoop;

import java.math.BigDecimal;

public interface AccountState {
    AccountState deposit(Runnable addToBalance);
    AccountState withdraw(Runnable subtractFromBalance);
    AccountState verifyHolder();
    AccountState closeAccount();
    AccountState freezeAccount();
}
