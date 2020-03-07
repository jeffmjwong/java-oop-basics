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

//    public void closeAccount() {
//        closed = true;
//    }
//
//    public void freezeAccount() {
//        if (!verified || closed) {
//            return;
//        }
//
//        freezable = freezable.freezeAccount();
//    }
}
