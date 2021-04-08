package com.kpi.controller.validators;

import com.kpi.custom.exceptions.EmptyRequestException;
import com.kpi.custom.exceptions.InvalidFormatTypeException;
import com.kpi.custom.exceptions.PriceLessZeroException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void checkPrice(int price) throws PriceLessZeroException {
        if (price < 0) {
            throw new PriceLessZeroException("Price can not be less than 0");
        }
    }

    public static void checkType(String type) throws InvalidFormatTypeException, EmptyRequestException {
        if (type.strip().isEmpty()) {
            throw new EmptyRequestException("Input data cannot be empty");
        }

        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(type);

        if (!matcher.matches()) {
            throw new InvalidFormatTypeException("Invalid type format. Must be only letters");
        }
    }


}
