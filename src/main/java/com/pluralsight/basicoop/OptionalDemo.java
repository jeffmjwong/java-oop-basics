package com.pluralsight.basicoop;

public class OptionalDemo {
    private void display(String value) {
        String printout = value == null ? "Nothing to show..." : value.toUpperCase();
        System.out.println(printout);
    }

    public void run() {
        display(null);
        display("something");
        display("Making Your Java Code More Object-Oriented");
    }
}
