package com.netcracker.edu.travnichev.exception;

public class ExceptionMessages{
    public static final String BELOW_ZERO = "The value cannot be below zero!";
    public static final String UNKNOWN_FLOWER  = "The value cannot be below zero!";

    public static String generateGreaterThanValue(double value) {
        return "The value cannot be greater than " + value + "!";
    }
}
