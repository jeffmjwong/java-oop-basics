package com.pluralsight.basicoop;

import java.time.Duration;
import java.time.LocalDate;

public class TimeLimitedWarranty implements Warranty {
    private LocalDate dateIssued;
    private Duration validFor;

    public TimeLimitedWarranty(LocalDate dateIssued, Duration validFor) {
        this.dateIssued = dateIssued;
        this.validFor = validFor;
    }

    @Override
    public boolean isValidOn(LocalDate date) {
        return dateIssued.compareTo(date) <= 0 && getExpiredDate().compareTo(date) > 0;
    }

    @Override
    public Warranty on(LocalDate date) {
        return date.compareTo(dateIssued) < 0 ? Warranty.VOID
                : date.compareTo(getExpiredDate()) > 0 ? Warranty.VOID
                : this;
    }

    private LocalDate getExpiredDate() {
        return dateIssued.plusDays(getValidForDays());
    }

    private long getValidForDays() {
        return validFor.toDays();
    }
}
