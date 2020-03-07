package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        final Account account1 = new Account(new AccountUnfrozen());
        System.out.println("Account just created: " + account1.getBalance());

        account1.deposit(new BigDecimal("20"));
        System.out.println("Deposited 20 with account not verified: " + account1.getBalance());

        account1.withdraw(new BigDecimal("10"));
        System.out.println("Withdrew 10 with account not verified: " + account1.getBalance());

        account1.verifyHolder();
        System.out.println("Account is verified!");
        account1.withdraw(new BigDecimal("10"));
        System.out.println("Withdrew 10 with account verified: " + account1.getBalance());

        account1.deposit(new BigDecimal("20"));
        System.out.println("Deposited 20 with account verified: " + account1.getBalance());

        account1.closeAccount();
        System.out.println("Account is closed!");
        account1.withdraw(new BigDecimal("30"));
        System.out.println("Withdrew 30 with account closed: " + account1.getBalance());

        account1.deposit(new BigDecimal("30"));
        System.out.println("Deposited 30 with account closed: " + account1.getBalance());
    }
}
