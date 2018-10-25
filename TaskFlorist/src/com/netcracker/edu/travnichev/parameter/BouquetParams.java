package com.netcracker.edu.travnichev.parameter;

import com.netcracker.edu.travnichev.model.*;
import com.netcracker.edu.travnichev.type.Color;

public class BouquetParams {
    private static final int FLOWER_AMOUNT_WEDDING = 9;
    private static final int FLOWER_AMOUNT_BIRTHDAY = 101;
    private static final int FLOWER_AMOUNT_DATE = 1;

    private static final int FLOWER_HEIGHT_WEDDING = 15;
    private static final int FLOWER_HEIGHT_BIRTHDAY = 70;
    private static final int ROSE_HEIGHT_DATE = 50;

    public static final Flower[] WEDDING_LIST = {
            new Rose(FLOWER_HEIGHT_WEDDING, Color.WHITE),
            new Rose(FLOWER_HEIGHT_WEDDING, Color.RED),
            new Rose(FLOWER_HEIGHT_WEDDING, Color.WHITE),
            new Aster(FLOWER_HEIGHT_WEDDING, Color.PURPLE),
            new Aster(FLOWER_HEIGHT_WEDDING, Color.WHITE),
            new Aster(FLOWER_HEIGHT_WEDDING, Color.PURPLE),
            new Chamomile(FLOWER_HEIGHT_WEDDING, Color.PURPLE),
            new Chamomile(FLOWER_HEIGHT_WEDDING, Color.PURPLE),
            new Chamomile(FLOWER_HEIGHT_WEDDING, Color.WHITE)
    };
    public static final Flower[] BIRTHDAY_LIST = new Flower[FLOWER_AMOUNT_BIRTHDAY];
    public static final Flower[] DATE_LIST = {new Rose(ROSE_HEIGHT_DATE, Color.RED)};

    static {
        for (int i = 0; i < FLOWER_AMOUNT_BIRTHDAY; i++) {
            BIRTHDAY_LIST[i] = new Rose(FLOWER_HEIGHT_BIRTHDAY, Color.RED);
        }
    }

}
