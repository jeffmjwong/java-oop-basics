package com.pluralsight.basicoop;

import java.time.LocalDate;

public class LifetimeWarranty implements Warranty {
    private LocalDate dateIssued;

    public LifetimeWarranty(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    @Override
    public boolean isValidOn(LocalDate date) {
        return dateIssued.compareTo(date) <= 0;
    }
}
