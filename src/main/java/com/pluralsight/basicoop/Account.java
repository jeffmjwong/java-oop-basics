package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private boolean verified;
    private boolean closed;
    private boolean frozen;

    private AccountUnfrozen onUnfrozen;

    public Account(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        this.onUnfrozen = onUnfrozen;
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
    public boolean isFrozen() {
        return frozen;
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

        frozen = true;
    }

    public void deposit(BigDecimal amount) {
        if (closed) {
            return;
        }

        ensureUnfrozen();
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!verified || closed) {
            return;
        }

        ensureUnfrozen();
        balance = balance.subtract(amount);
    }

    private void ensureUnfrozen() {
        if (frozen) {
            frozen = false;
            onUnfrozen.handle();
        }
    }
}
