package com.pluralsight.basicoop;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WarrantyDemo {
    public void claimWarranty(Article article) {
        LocalDate today = LocalDate.now();

        article.getMoneyBackGuarantee().on(today).claim(this::offerMoneyBack);
        article.getExpressWarranty().on(today).claim(this::offerRepair);

        System.out.println("------------------------");
    }

    private void offerMoneyBack() {
        System.out.println("Offer money back!");
    }

    private void offerRepair() {
        System.out.println("Offer repair!");
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
