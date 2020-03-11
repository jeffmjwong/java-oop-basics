package com.pluralsight.basicoop;

import java.util.Optional;

public class OptionalDemo {
    private static abstract class MaybeString {
        public abstract MaybeString toUpperCase();
        public abstract String orElse(String substitute);
    }

    private static class Some extends MaybeString {
        private String value;

        public Some(String value) {
            this.value = value;
        }

        @Override
        public MaybeString toUpperCase() {
            value = value.toUpperCase();
            return this;
        }

        @Override
        public String orElse(String substitute) {
            return value;
        }
    }

    private void display(MaybeString value) {
        MaybeString uppercase = value.toUpperCase();
        String printout = uppercase.orElse("Nothing to show...");
        System.out.println(printout);
    }

    public void run() {
        display(null);
        display(new Some("something"));
        display("Making Your Java Code More Object-Oriented");
    }
}
