package com.kpi.custom.exceptions;

public class SaveStoreDataException extends DataException{
    public SaveStoreDataException(String userMessage, String devMessage) {
        super(userMessage, devMessage);
    }
}
