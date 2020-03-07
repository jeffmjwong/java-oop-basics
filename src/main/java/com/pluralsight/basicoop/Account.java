package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private boolean verified;
    private boolean closed;

    private Freezable freezable;

    public Account(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        freezable = new FreezableActive();
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public boolean isVerified() {
        return verified;
    }
    public boolean isClosed() {
        return closed;
    }

    public void verifyHolder() {
        verified = true;
    }

    public void closeAccount() {
        closed = true;
    }

    public void freezeAccount() {
        if (!verified || closed) {
            return;
        }

        freezable = freezable.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        if (closed) {
            return;
        }

        freezable = freezable.deposit();
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!verified || closed) {
            return;
        }

        freezable = freezable.withdraw();
        balance = balance.subtract(amount);
    }
}
