package com.pluralsight.basicoop;

import java.time.LocalDate;

public interface Warranty {
    boolean isValidOn(LocalDate date);
}
