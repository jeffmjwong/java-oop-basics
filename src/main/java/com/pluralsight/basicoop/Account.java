package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private boolean verified;
    private boolean closed;

    private AccountUnfrozen onUnfrozen;
    private EnsureUnfrozen ensureUnfrozen;

    public Account(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        this.onUnfrozen = onUnfrozen;
        this.ensureUnfrozen = this::stayUnfrozen;
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

        this.ensureUnfrozen = this::unfreeze;
    }

    public void deposit(BigDecimal amount) {
        if (closed) {
            return;
        }

        ensureUnfrozen.execute();
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!verified || closed) {
            return;
        }

        ensureUnfrozen.execute();
        balance = balance.subtract(amount);
    }

    private void unfreeze() {
        onUnfrozen.handle();
        this.ensureUnfrozen = this::stayUnfrozen;
    }

    private void stayUnfrozen() {
        System.out.println("Account is still active!");
    }
}
