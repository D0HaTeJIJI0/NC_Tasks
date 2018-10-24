package com.netcracker.edu.travnichev.comparator;

import com.netcracker.edu.travnichev.model.Flower;

import java.util.Comparator;

public class ComparatorByHeight implements Comparator<Flower> {

    @Override
    public int compare(Flower o1, Flower o2) {
        double difference = o1.getHeightInCentimeters() - o2.getHeightInCentimeters();
        if (difference > 0) {
            return 1;
        }
        else if (difference < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
