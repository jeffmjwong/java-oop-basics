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

    private LocalDate getExpiredDate() {
        return dateIssued.plusDays(getValidForDays());
    }

    private long getValidForDays() {
        return validFor.toDays();
    }
}
