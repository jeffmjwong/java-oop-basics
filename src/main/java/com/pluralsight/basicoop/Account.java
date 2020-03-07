package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Account {
    private boolean isVerified;

    public void holderVerified() {
        isVerified = true;
    }

    public void deposit(BigDecimal amount) {

    }

    public void withdraw(BigDecimal amount) {
        if (!isVerified) {
            return;
        }
    }
}
