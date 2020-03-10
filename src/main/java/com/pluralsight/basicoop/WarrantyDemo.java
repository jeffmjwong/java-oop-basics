package com.pluralsight.basicoop;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WarrantyDemo {
    public void claimWarranty(Article article, boolean isInGoodCondition, boolean isNonOperational) {
        LocalDate today = LocalDate.now();

        if (isInGoodCondition && isNonOperational && article.getMoneyBackGuarantee() != null && article.getMoneyBackGuarantee().isValidOn(today)) {
            System.out.println("Offer money back!");
        }

        if (isNonOperational && article.getExpressWarranty() != null && article.getExpressWarranty().isValidOn(today)) {
            System.out.println("Offer repair!");
        }

        System.out.println("------------------------");
    }

    public void run() {
        final LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        final Warranty moneyBack1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(30));
        final Warranty warranty1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        final Article item1 = new Article(moneyBack1, warranty1);
        System.out.println(item1);
    }
}
