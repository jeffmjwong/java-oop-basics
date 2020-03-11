package com.pluralsight.basicoop;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WarrantyDemo {
    public void claimWarranty(Article article) {
        LocalDate today = LocalDate.now();

        article.getMoneyBackGuarantee().claim(() -> System.out.println("Offer money back!"));

        if (article.getExpressWarranty().isValidOn(today)) {
            System.out.println("Offer repair!");
        }

        System.out.println("------------------------");
    }

    public void run() {
        final LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        final Warranty moneyBack1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(30));
        final Warranty warranty1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        final Article item1 = new Article(moneyBack1, warranty1);
        claimWarranty(item1);

        final Article item2 = new Article(Warranty.lifetime(sellingDate), Warranty.VOID);
        claimWarranty(item2);
    }
}
