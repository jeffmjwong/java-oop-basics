package com.pluralsight.basicoop;

import java.time.LocalDate;

public class LifetimeWarranty implements Warranty {
    private LocalDate dateIssued;

    public LifetimeWarranty(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    @Override
    public Warranty on(LocalDate date) {
        return date.compareTo(dateIssued) < 0 ? Warranty.VOID : this;
    }
}
