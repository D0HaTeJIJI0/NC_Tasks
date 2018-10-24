package com.netcracker.edu.travnichev.model;

import com.netcracker.edu.travnichev.exception.ExceptionMessages;
import com.netcracker.edu.travnichev.type.Color;
import com.netcracker.edu.travnichev.type.FlowerName;

import java.math.BigDecimal;

public class Flower {
    private FlowerName name;
    private double heightInCentimeters;
    private Double maxHeightInCentimeters;
    private Color color;

    private Flower() {}

    protected Flower(FlowerName name,
                     double heightInCentimeters,
                     double maxHeightInCentimeters,
                     Color color) {

        this.verifyMaxHeightInCentimeters(maxHeightInCentimeters);
        this.verifyHeightInCentimeters(heightInCentimeters, maxHeightInCentimeters);
        this.maxHeightInCentimeters = maxHeightInCentimeters;
        this.heightInCentimeters = heightInCentimeters;
        this.name = name;
        this.color = color;
    }

    private void verifyMaxHeightInCentimeters(double maxHeightInCentimeters) throws IllegalArgumentException{
        if (maxHeightInCentimeters < 0) throw new IllegalArgumentException(ExceptionMessages.BELOW_ZERO);
        this.maxHeightInCentimeters = maxHeightInCentimeters;
    }

    private void verifyHeightInCentimeters(double heightInCentimeters, double maxHeightInCentimeters) throws IllegalArgumentException{
        if (heightInCentimeters < 0) throw new IllegalArgumentException(ExceptionMessages.BELOW_ZERO);
        if (heightInCentimeters > maxHeightInCentimeters) {
            throw new IllegalArgumentException(
                    ExceptionMessages.generateGreaterThanValue(this.maxHeightInCentimeters));
        }
        this.heightInCentimeters = heightInCentimeters;
    }

    public FlowerName getName() { return name; }

    public double getHeightInCentimeters() { return heightInCentimeters; }

    public Color getColor() { return color; }

    @Override
    public String toString() {
        return "Flower: " + "["
                + "name: " + this.name + ", "
                + "heightInCentimeters: " + this.heightInCentimeters + "cm, "
                + "maxHeightInCentimeters: " + this.maxHeightInCentimeters + "cm, "
                + "color: " + this.color + "]";
    }
}
