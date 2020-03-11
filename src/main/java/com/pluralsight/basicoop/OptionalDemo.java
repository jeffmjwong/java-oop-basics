package com.pluralsight.basicoop;

import java.util.Optional;
import java.util.function.Function;

public class OptionalDemo {
    private static abstract class MaybeString {
        public abstract MaybeString map(Function<String, String> transform);
        public abstract String orElse(String substitute);
        public abstract boolean isPresent();
    }

    private static class Some extends MaybeString {
        private String content;

        public Some(String content) {
            this.content = content;
        }

        @Override
        public MaybeString map(Function<String, String> transform) {
            return new Some(transform.apply(content));
        }

        @Override
        public String orElse(String substitute) {
            return content;
        }

        @Override
        public boolean isPresent() {
            return true;
        }
    }

    private static class None extends MaybeString {
        public None() {}

        @Override
        public MaybeString map(Function<String, String> transform) {
            return this;
        }

        @Override
        public String orElse(String substitute) {
            return substitute;
        }

        @Override
        public boolean isPresent() {
            return false;
        }
    }

    private void display(MaybeString value) {
        MaybeString uppercase = value.map(String::toUpperCase);
        System.out.println(uppercase.isPresent());
        String printout = uppercase.orElse("Nothing to show...");
        System.out.println(printout);
    }

    public void run() {
        display(new None());
        display(new Some("something"));
        display(new Some("Making Your Java Code More Object-Oriented"));
    }
}
