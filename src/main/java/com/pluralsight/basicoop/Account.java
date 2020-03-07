package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private boolean verified;
    private boolean closed;

    public Account() {
        balance = BigDecimal.ZERO;
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

    public void deposit(BigDecimal amount) {
        if (closed) {
            return;
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!verified || closed) {
            return;
        }
    }
}
