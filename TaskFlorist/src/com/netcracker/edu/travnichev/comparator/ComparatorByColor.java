package com.netcracker.edu.travnichev.comparator;

import com.netcracker.edu.travnichev.model.Flower;

import java.util.Comparator;

public class ComparatorByColor implements Comparator<Flower> {
    @Override
    public int compare(Flower o1, Flower o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
