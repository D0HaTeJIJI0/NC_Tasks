package com.netcracker.edu.travnichev.control;

import com.netcracker.edu.travnichev.model.Bouquet;
import com.netcracker.edu.travnichev.model.Aster;
import com.netcracker.edu.travnichev.model.Chamomile;
import com.netcracker.edu.travnichev.model.Flower;
import com.netcracker.edu.travnichev.model.Rose;
import com.netcracker.edu.travnichev.exception.NoBouquetException;
import com.netcracker.edu.travnichev.type.Color;
import com.netcracker.edu.travnichev.type.FlowerName;
import com.netcracker.edu.travnichev.view.Viewer;

import java.util.List;
import java.util.Scanner;

public class App {
    private static Bouquet bouquet = null;

    public static void main(String[] args) { launchStartMenu(); }

    private static void launchStartMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flagExit = false;
        while (!flagExit) {
            Viewer.printStartMenu();
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        launchCreateMenu();
                        break;
                    case 2:
                        if (bouquet == null) {
                            throw new NoBouquetException();
                        }
                        Viewer.printBouquetInfo(bouquet);
                        Viewer.pause();
                        break;
                    case 3:
                        if (bouquet == null) {
                            throw new NoBouquetException();
                        }
                        launchSortMenu();
                        break;
                    case 4:
                        if (bouquet == null) {
                            throw new NoBouquetException();
                        }
                        launchFindMenu();
                        break;
                    case 5:
                        flagExit = true;
                        break;
                }
            } catch (NoBouquetException e) {
                e.printInfo();
            }
            if (flagExit) {
                break;
            }
        }
    }

    private static void launchFindMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flagExit = false;
        while (!flagExit) {
            Viewer.printFindMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Viewer.printEnterName();
                    String name = sc.next();
                    try {
                        FlowerName flowerName = FlowerName.valueOf(name.toUpperCase());
                        List<Flower> flowerListName = bouquet.findFlowersByName(flowerName);
                        if (flowerListName.size() != 0) {
                            Viewer.printFlowers(flowerListName);
                            Viewer.pause();
                        }
                        else throw new IllegalArgumentException();
                    } catch(IllegalArgumentException e) {
                        Viewer.printNoName();
                        Viewer.pause();
                    }
                    break;
                case 2:
                    Viewer.printEnterColor();
                    String colorString = sc.next();
                    try {
                        Color color = Color.valueOf(colorString.toUpperCase());
                        List<Flower> flowerListColor = bouquet.findFlowersByColor(color);
                        if (flowerListColor.size() != 0) {
                            Viewer.printFlowers(flowerListColor);
                            Viewer.pause();
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                    } catch(IllegalArgumentException e) {
                        Viewer.printNoColor();
                        Viewer.pause();
                    }
                    break;
                case 3:
                    flagExit = true;
                    break;
            }
            if (flagExit) {
                break;
            }
        }
    }

    private static void launchSortMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flagExit = false;
        while (!flagExit) {
            Viewer.printSortMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bouquet.sortFlowersByHeight();
                    break;
                case 2:
                    bouquet.sortFlowersByPrice();
                    break;
                case 3:
                    bouquet.sortFlowersByColor();
                    break;
                case 4:
                    flagExit = true;
                    break;
            }
            if (flagExit) {
                break;
            }
        }
    }

    private static void launchCreateMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flagExit = false;
        while (!flagExit) {
            Viewer.printCreateMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bouquet = Bouquet.createWeddingBouquet();
                    flagExit = true;
                    break;
                case 2:
                    bouquet = Bouquet.createBirthdayBouquet();
                    flagExit = true;
                    break;
                case 3:
                    bouquet = Bouquet.createDateBouquet();
                    flagExit = true;
                    break;
                case 4:
                    launchCreateCustomMenu();
                    flagExit = true;
                    break;
                case 5:
                    flagExit = true;
                    break;
            }
            if (flagExit) {
                break;
            }
        }
    }

    private static void launchCreateCustomMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flagExit = false, firstAdd = true;
        double height;
        Color color;
        while (!flagExit) {
            Viewer.printCreateCustomMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    height = Math.random() * Rose.getMaxHeightInCentimeters();
                    color = Color.takeRandColor();
                    if (bouquet == null || firstAdd) {
                        firstAdd = false;
                        bouquet = new Bouquet(new Rose(height, color));
                    }
                    bouquet.addInBouquet(new Rose(height, color));
                    break;
                case 2:
                    height = Math.random() * Chamomile.getMaxHeightInCentimeters();
                    color = Color.takeRandColor();
                    if (bouquet == null || firstAdd) {
                        firstAdd = false;
                        bouquet = new Bouquet(new Chamomile(height, color));
                    }
                    bouquet.addInBouquet(new Chamomile(height, color));
                    break;
                case 3:
                    height = Math.random() * Aster.getMaxHeightInCentimeters();
                    color = Color.takeRandColor();
                    if (bouquet == null || firstAdd) {
                        firstAdd = false;
                        bouquet = new Bouquet(new Aster(height, color));
                    }
                    bouquet.addInBouquet(new Aster(height, color));
                    break;
                case 4:
                    flagExit = true;
                    break;
            }
            if (flagExit) {
                break;
            }
        }
    }
}



