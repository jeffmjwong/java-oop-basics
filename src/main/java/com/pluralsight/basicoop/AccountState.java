package com.pluralsight.basicoop;

public interface AccountState {
    AccountState deposit();
    AccountState withdraw();
    AccountState verifyHolder();
    AccountState closeAccount();
    AccountState freezeAccount();
}
