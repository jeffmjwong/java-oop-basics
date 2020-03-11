package com.pluralsight.basicoop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        useAccountClass();
//        useAliasBugDemo();
//        useWarrantyDemo();
        useOptionalDemo();
    }

    private static void useOptionalDemo() {
        final OptionalDemo demo = new OptionalDemo();
        demo.run();
    }

    private static void useWarrantyDemo() {
        final WarrantyDemo demo = new WarrantyDemo();
        demo.run();
    }

    private static void useAliasBugDemo() {
        final AliasBugDemo demo = new AliasBugDemo();
        demo.run();
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
