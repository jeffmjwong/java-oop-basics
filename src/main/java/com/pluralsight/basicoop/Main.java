package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        final Account account1 = new Account();
        System.out.println(account1.getBalance());

        account1.deposit(new BigDecimal("20"));
        System.out.println(account1.getBalance());

        account1.verifyHolder();
        account1.withdraw(new BigDecimal("20"));
        System.out.println(account1.getBalance());
    }
}
