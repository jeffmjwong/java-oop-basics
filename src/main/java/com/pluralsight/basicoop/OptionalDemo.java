package com.pluralsight.basicoop;

import java.util.Optional;

public class OptionalDemo {
    private static abstract class MaybeString {
        public abstract MaybeString toUpperCase();
        public abstract String orElse();
    }

    private void display(MaybeString value) {
        MaybeString uppercase = value.toUpperCase();
        String printout = uppercase.orElse("Nothing to show...");
        System.out.println(printout);
    }

    public void run() {
        display(null);
        display("something");
        display("Making Your Java Code More Object-Oriented");
    }
}
