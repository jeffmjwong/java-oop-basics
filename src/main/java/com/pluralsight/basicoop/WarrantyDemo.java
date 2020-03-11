package com.pluralsight.basicoop;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WarrantyDemo {
    public void claimWarranty(Article article) {
        LocalDate today = LocalDate.now();

        article.getMoneyBackGuarantee().on(today).claim(this::offerMoneyBack);
        article.getExpressWarranty().on(today).claim(this::offerRepair);
        article.getExtendedWarranty().on(today).claim(this::offerPartsReplacement);

        System.out.println("------------------------");
    }

    private void offerMoneyBack() {
        System.out.println("Offer money back!");
    }

    private void offerRepair() {
        System.out.println("Offer repair!");
    }

    private void offerPartsReplacement() {
        System.out.println("Offer parts replacement!");
    }

    public void run() {
        final LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        final Warranty moneyBack = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
        final Warranty warranty = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        final Part sensor = new Part(sellingDate);
        final Warranty sensorWarranty = new TimeLimitedWarranty(sellingDate, Duration.ofDays(90));

        final Article item = new Article(moneyBack, warranty).install(sensor, sensorWarranty);

        System.out.println("Start");
        claimWarranty(item);
        System.out.println("End");
        System.out.println();

        System.out.println("Start");
        claimWarranty(item.withVisibleDamage());
        System.out.println("End");
        System.out.println();

        System.out.println("Start");
        claimWarranty(item.withVisibleDamage().nonOperational());
        System.out.println("End");
        System.out.println();

        System.out.println("Start");
        claimWarranty(item.nonOperational());
        System.out.println("End");
        System.out.println();

        final LocalDate sensorExamined = LocalDate.now().minus(2, ChronoUnit.DAYS);

        System.out.println("Start");
        claimWarranty(item.sensorNotOperational(sensorExamined));
        System.out.println("End");
        System.out.println();

        System.out.println("Start");
        claimWarranty(item.nonOperational().sensorNotOperational(sensorExamined));
        System.out.println("End");
        System.out.println();
    }
}
