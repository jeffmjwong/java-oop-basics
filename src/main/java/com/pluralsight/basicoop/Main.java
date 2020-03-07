package com.pluralsight.basicoop;

public class Main {
    public static void main(String[] args) {
        final Account account1 = new Account();
        System.out.println(account1.isClosed());
        System.out.println(account1.isVerified());
        System.out.println(account1.getBalance());

        account1.closeAccount();
        account1.verifyHolder();

        System.out.println(account1.isClosed());
        System.out.println(account1.isVerified());
        System.out.println(account1.getBalance());
    }
}
