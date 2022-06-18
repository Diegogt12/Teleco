package com.company;

public class ExArgumentoIncorrecto extends Exception {
    private String s;

    public ExArgumentoIncorrecto(String s) {
        super("EXARGINC: " + s);
    }
}
