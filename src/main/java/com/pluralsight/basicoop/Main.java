package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        final Account account1 = new Account(new AccountUnfrozen());
        System.out.println("1 " + account1.getBalance());

        account1.verifyHolder();
        account1.deposit(new BigDecimal("20"));
        System.out.println("2 " + account1.getBalance());

        account1.freezeAccount();
        account1.deposit(new BigDecimal("30"));
        System.out.println("3 " + account1.getBalance());

        account1.deposit(new BigDecimal("30"));
        System.out.println("4 " + account1.getBalance());

        account1.freezeAccount();
        account1.withdraw(new BigDecimal("35"));
        System.out.println("5 " + account1.getBalance());
    }
}
