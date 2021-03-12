package com.kpi.custom.exceptions;

public class PriceLessZeroException extends Exception {
    public PriceLessZeroException(String message) {
        super(message);
    }
}
