package com.pluralsight.basicoop;

import com.pluralsight.basicoop.accountstates.Active;
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
        accountState = accountState.deposit(amount, a -> balance = balance.add(a));
    }

    public void withdraw(BigDecimal amount) {
        accountState = accountState.withdraw();
        balance = balance.subtract(amount);
    }

//    public void verifyHolder() {
//        verified = true;
//    }
//
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
