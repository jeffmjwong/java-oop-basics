package com.pluralsight.basicoop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        useAccountClass();

//        final Currency c1 = new Currency("c");
//        final Currency c2 = new Currency("b");
//        final Money m1 = new Money(new BigDecimal("50"), c1);
//        final Money m2 = new Money(new BigDecimal("25"), c1);
//        final Money m3 = new Money(new BigDecimal("50"), c2);
//        final Money m4 = new Money(new BigDecimal("25"), c2);
//
//        List<Money> list1 = new ArrayList<>(Arrays.asList(m1, m2, m3, m4));
//        System.out.println(list1);
//        Collections.sort(list1);
//        System.out.println(list1);

        final AliasBugDemo demo1 = new AliasBugDemo();
        demo1.run();
    }

    private static void useAccountClass() {
        final Account account1 = new Account();
        System.out.println("Account just created: " + account1.getBalance());

        account1.deposit(new BigDecimal("50"));
        System.out.println("Deposited 50 with account not verified: " + account1.getBalance());

        account1.withdraw(new BigDecimal("20"));
        System.out.println("Withdrew 20 with account not verified: " + account1.getBalance());

        account1.verifyHolder();
        System.out.println("Account is verified!");
        account1.withdraw(new BigDecimal("20"));
        System.out.println("Withdrew 20 with account verified: " + account1.getBalance());

        account1.deposit(new BigDecimal("70"));
        System.out.println("Deposited 70 with account verified: " + account1.getBalance());

        account1.freezeAccount();
        System.out.println("Account is frozen!");
        account1.withdraw(new BigDecimal("30"));
        System.out.println("Withdrew 30 with account frozen then unfrozen: " + account1.getBalance());

        account1.freezeAccount();
        System.out.println("Account is frozen!");
        account1.deposit(new BigDecimal("10"));
        System.out.println("Deposited 10 with account frozen then unfrozen: " + account1.getBalance());

        account1.closeAccount();
        System.out.println("Account is closed!");
        account1.withdraw(new BigDecimal("30"));
        System.out.println("Withdrew 30 with account closed: " + account1.getBalance());

        account1.deposit(new BigDecimal("30"));
        System.out.println("Deposited 30 with account closed: " + account1.getBalance());
    }
}
