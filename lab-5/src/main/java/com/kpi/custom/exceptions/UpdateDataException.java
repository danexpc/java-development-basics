package com.kpi.custom.exceptions;

public class UpdateDataException extends DataException {

    public UpdateDataException(String userMessage, String devMessage) {
        super(userMessage, devMessage);
    }
}
