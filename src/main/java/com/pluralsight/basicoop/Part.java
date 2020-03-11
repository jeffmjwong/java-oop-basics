package com.pluralsight.basicoop;

import java.time.LocalDate;

public class Part {
    private LocalDate installmentDate;
    private LocalDate defectDetectedOn;

    public Part(LocalDate installmentDate) {
        this(installmentDate, null);
    }

    private Part(LocalDate installmentDate, LocalDate defectDetectedOn) {
        this.installmentDate = installmentDate;
        this.defectDetectedOn = defectDetectedOn;
    }

    public Part defective(LocalDate detectedOn) {
        return new Part(installmentDate, detectedOn);
    }

    public Warranty apply(Warranty partWarranty) {
        return defectDetectedOn == null ? Warranty.VOID : Warranty.lifetime(defectDetectedOn);
    }
}
