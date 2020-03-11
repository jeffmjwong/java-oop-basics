package com.pluralsight.basicoop;

import java.time.LocalDate;

public interface Warranty {
    boolean isValidOn(LocalDate date);
    default void claim(Runnable action) {
        action.run();
    };

    Warranty VOID = new VoidWarranty();

    static Warranty lifetime(LocalDate dateIssued) {
        return new LifetimeWarranty(dateIssued);
    }
}
