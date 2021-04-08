package com.kpi.custom.exceptions;

import java.io.IOException;

public class DataException extends IOException {

    private final String devMessage;

    public DataException(String userMessage, String devMessage) {
        super(userMessage);
        this.devMessage = devMessage;
    }

    public String getUserMessage() {
        return super.getMessage();
    }

    public String getDevMessage() {
        return devMessage;
    }
}
