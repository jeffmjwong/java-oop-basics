package com.pluralsight.basicoop;

import java.time.LocalDate;

public class VoidWarranty implements Warranty {
    @Override
    public boolean isValidOn(LocalDate date) {
        return false;
    }

    @Override
    public void claim(Runnable action) {

    }
}
