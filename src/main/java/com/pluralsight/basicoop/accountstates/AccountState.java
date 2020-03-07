package com.pluralsight.basicoop.accountstates;

public interface AccountState {
    AccountState deposit(Runnable addToBalance);
    AccountState withdraw(Runnable subtractFromBalance);
    AccountState verifyHolder();
    AccountState closeAccount();
    AccountState freezeAccount();
}
