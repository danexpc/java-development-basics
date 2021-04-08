package com.kpi.custom.exceptions;

public class SaveUserDataException extends DataException{
    public SaveUserDataException(String userMessage, String devMessage) {
        super(userMessage, devMessage);
    }
}
