package com.netcracker.edu.travnichev.type;

import java.util.concurrent.ThreadLocalRandom;

public enum Color {
    RED,
    WHITE,
    PURPLE,
    YELLOW;

    private static int SIZE = 4;

    public static Color takeRandColor() {
        int ind = ThreadLocalRandom.current().nextInt(0, SIZE);
        return Color.values()[ind];
    }
}
