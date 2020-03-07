package com.pluralsight.basicoop;

import com.pluralsight.basicoop.accountstates.NotVerified;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private AccountState accountState;

    public Account(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        accountState = new NotVerified();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        accountState = accountState.deposit(addToBalance(amount));
    }

    public void withdraw(BigDecimal amount) {
        accountState = accountState.withdraw(subtractFromBalance(amount));
    }

    public void verifyHolder() {
        accountState = accountState.verifyHolder();
    }

    public void closeAccount() {
        accountState = accountState.closeAccount();
    }

    public void freezeAccount() {

    }

    private Runnable addToBalance(BigDecimal amount) {
        return () -> {
            balance = balance.add(amount);
        };
    }

    private Runnable subtractFromBalance(BigDecimal amount) {
        return () -> {
            balance = balance.subtract(amount);
        };
    }
}
