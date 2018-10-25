package com.netcracker.edu.travnichev.view;

import com.netcracker.edu.travnichev.model.Bouquet;
import com.netcracker.edu.travnichev.model.Flower;
import com.netcracker.edu.travnichev.type.Pack;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Viewer {
    private static final String START_MENU = "*******Start menu*******\n" +
                                            "(1)Create new bouquet\n" +
                                            "(2)Print bouquet info\n" +
                                            "(3)Sort flowers in bouquet\n" +
                                            "(4)Find flowers in bouquet\n" +
                                            "(5)Quit\n";

    private static final String CREATE_MENU = "*******Create menu*******\n" +
                                            "(1)Create wedding bouquet\n" +
                                            "(2)Create birthday bouquet\n" +
                                            "(3)Create date bouquet\n" +
                                            "(4)Create custom bouquet\n" +
                                            "(5)Back to start menu\n";

    private static final String CREATE_CUSTOM_MENU = "*******Create custom bouquet menu*******\n" +
                                                    "(1)Add Rose in bouquet(with rand characteristics)\n" +
                                                    "(2)Add Chamomile in bouquet(with rand characteristics)\n" +
                                                    "(3)Add Aster in bouquet(with rand characteristics)\n" +
                                                    "(4)Finish and go back to start menu\n";

    private static final String SORT_MENU = "*******Sort menu*******\n" +
                                            "(1)Sort flowers by height\n" +
                                            "(2)Sort flowers by price\n" +
                                            "(3)Sort flowers by color\n" +
                                            "(4)Back to start menu\n";

    private static final String FIND_MENU = "*******Find menu*******\n" +
                                            "(1)Find flowers by name\n" +
                                            "(2)Find flowers by color\n" +
                                            "(3)Back to start menu\n";

    private static final String ENTER_NAME = "Enter name: ";
    private static final String ENTER_COLOR = "Enter color: ";
    private static final String NO_SUCH_NAME = "There is no flower with such name!";
    private static final String NO_SUCH_COLOR = "There is no flower with such color!";
    private static final String PRESS_ENTER_TO_EXIT = "Press enter to continue...";
    private static final String NO_SUCH_BOUQUET = "You should create bouquet first!";

    public static void printStartMenu() {
        System.out.println(START_MENU);
    }

    public static void printCreateMenu() { System.out.println(CREATE_MENU); }

    public static void printSortMenu() {
        System.out.println(SORT_MENU);
    }

    public static void printCreateCustomMenu() {
        System.out.println(CREATE_CUSTOM_MENU);
    }

    public static void printFindMenu() {
        System.out.println(FIND_MENU);
    }

    public static void printEnterName() {
        System.out.print(ENTER_NAME);
    }

    public static void printEnterColor() { System.out.print(ENTER_COLOR); }

    public static void printNoName() { System.out.println(NO_SUCH_NAME); }

    public static void printNoColor() {
        System.out.println(NO_SUCH_COLOR);
    }

    public static void printNoBouquet() {
        System.out.println(NO_SUCH_BOUQUET);
    }

    public static void pause() {
        System.out.println(PRESS_ENTER_TO_EXIT);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printBouquetInfo(Bouquet bouquet) {
        printFlowers(bouquet.getFlowerList());
        printDelimiter();
        printPack(bouquet.getPack());
        printDelimiter();
        printPriceOfBouquet(bouquet.countPriceInDollars());
    }

    public static void printFlowers(List<Flower> flowerList){
        System.out.println("Flowers in bouquet: ");
        for (Flower f: flowerList) {
            System.out.println(f.toString());
        }
    }

    private static void printDelimiter() {
        System.out.println("----------------------------");
    }

    private static void printPack(Pack pack) {
        System.out.println("Pack is being used: ");
        System.out.println(pack.toString());
    }

    private static void printPriceOfBouquet(BigDecimal price) {
        System.out.println("Price of bouquet: " + price + "$");
    }
}
