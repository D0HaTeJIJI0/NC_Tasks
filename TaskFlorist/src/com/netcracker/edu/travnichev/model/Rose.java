package com.netcracker.edu.travnichev.model;

import com.netcracker.edu.travnichev.exception.ExceptionMessages;
import com.netcracker.edu.travnichev.parameter.MoneyParams;
import com.netcracker.edu.travnichev.type.Color;
import com.netcracker.edu.travnichev.type.FlowerName;

import java.math.BigDecimal;

public class Rose extends Flower {
    private static final FlowerName NAME = FlowerName.ROSE;
    private static final double MAX_HEIGHT_IN_CENTIMETERS = 600;
    private static BigDecimal priceInDollars = new BigDecimal("50.00");
    static {
        Rose.priceInDollars = Rose.priceInDollars.setScale(MoneyParams.SCALE, MoneyParams.ROUNDING_MODE);
    }

    public Rose() {
        super(NAME, MAX_HEIGHT_IN_CENTIMETERS, MAX_HEIGHT_IN_CENTIMETERS, Color.WHITE);
    }

    public Rose(Color color) {
        super(NAME, MAX_HEIGHT_IN_CENTIMETERS, MAX_HEIGHT_IN_CENTIMETERS, color);
    }

    public Rose(double heightInCentimiters) {
        super(NAME, heightInCentimiters, MAX_HEIGHT_IN_CENTIMETERS, Color.WHITE);
    }

    public Rose(double heightInCentimiters, Color color) {
        super(NAME, heightInCentimiters, MAX_HEIGHT_IN_CENTIMETERS, color);
    }

    public static double getMaxHeightInCentimeters() {
        return MAX_HEIGHT_IN_CENTIMETERS;
    }

    public static BigDecimal getPriceInDollars() {
        return priceInDollars;
    }

    public static void setPriceInDollars(BigDecimal priceInDollars) throws IllegalArgumentException{
        if (priceInDollars.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new IllegalArgumentException(ExceptionMessages.BELOW_ZERO);
        }
        Rose.priceInDollars = priceInDollars.setScale(MoneyParams.SCALE, MoneyParams.ROUNDING_MODE);
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result.substring(0, result.length() - 1)
                + ", priceInDollars: " + Rose.priceInDollars + "$]";
    }
}
