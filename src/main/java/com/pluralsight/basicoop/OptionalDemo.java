package com.pluralsight.basicoop;

import java.util.function.Function;

public class OptionalDemo {
    private static abstract class Maybe<T> {
        public abstract <TResult> Maybe<TResult> map(Function<T, TResult> transform);
        public abstract <TResult> Maybe<TResult> flatMap(Function<T, Maybe<TResult>> transform);
        public abstract T orElse(T substitute);
        public abstract boolean isPresent();
        public abstract T get();
    }

    private static class Some<T> extends Maybe<T> {
        private T content;

        public Some(T content) {
            this.content = content;
        }

        @Override
        public <TResult> Maybe<TResult> map(Function<T, TResult> transform) {
            return new Some<>(transform.apply(content));
        }

        @Override
        public <TResult> Maybe<TResult> flatMap(Function<T, Maybe<TResult>> transform) {
            return transform.apply(content);
        }

        @Override
        public T orElse(T substitute) {
            return content;
        }

        @Override
        public boolean isPresent() {
            return true;
        }

        @Override
        public T get() {
            return content;
        }
    }

    private static class None<T> extends Maybe<T> {
        public None() {}

        @Override
        public <TResult> Maybe<TResult> map(Function<T, TResult> transform) {
            return new None<>();
        }

        @Override
        public <TResult> Maybe<TResult> flatMap(Function<T, Maybe<TResult>> transform) {
            return new None<>();
        }

        @Override
        public T orElse(T substitute) {
            return substitute;
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public T get() {
            throw new IllegalStateException();
        }
    }

    private void display(Maybe<String> value) {
        System.out.println(value.map(String::toUpperCase).orElse("Nothing to show..."));
    }

    private void displayInt(Maybe<Integer> value) {
        System.out.println(value.map(Integer::intValue).orElse(100));
    }

    public void run() {
        display(new None<>());
        display(new Some<>("something"));
        display(new Some<>("Making Your Java Code More Object-Oriented"));
        displayInt(new Some<>(20));
    }
}
