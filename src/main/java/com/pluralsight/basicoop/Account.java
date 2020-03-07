package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Account {
    private boolean verified;
    private boolean closed;

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
    }

    public void withdraw(BigDecimal amount) {
        if (!verified || closed) {
            return;
        }
    }
}
