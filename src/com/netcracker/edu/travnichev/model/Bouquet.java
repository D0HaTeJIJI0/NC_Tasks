package com.netcracker.edu.travnichev.model;

import com.netcracker.edu.travnichev.comparator.ComparatorByColor;
import com.netcracker.edu.travnichev.comparator.ComparatorByHeight;
import com.netcracker.edu.travnichev.comparator.ComparatorByPrice;
import com.netcracker.edu.travnichev.model.helper.PriceGetter;
import com.netcracker.edu.travnichev.type.Color;
import com.netcracker.edu.travnichev.type.FlowerName;
import com.netcracker.edu.travnichev.type.Pack;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

import static com.netcracker.edu.travnichev.parameter.BouquetParams.*;

public class Bouquet {
    private List<Flower> flowerList;
    private Pack pack;
    private BigDecimal priceInDollars;

    private Bouquet() {}

    public Bouquet(Flower flower, Pack pack) {
        this.flowerList = new ArrayList<>();
        this.flowerList.add(flower);
        this.pack = pack;
    }

    public Bouquet(List<Flower> flowerList, Pack pack) {
        this.flowerList = new ArrayList<>();
        this.flowerList.addAll(flowerList);
        this.pack = pack;
    }

    public Bouquet(Flower flower) {
        this(flower, Pack.NO_PACK);
    }

    public Bouquet(List<Flower> flowerList) {
        this(flowerList, Pack.NO_PACK);
    }

    public static Bouquet createWeddingBouquet() {
        List<Flower> weddingList = Arrays.asList(WEDDING_LIST);
        Pack weddingPack = Pack.CELLOPHANE;
        return new Bouquet(weddingList, weddingPack);
    }

    public static Bouquet createBirthdayBouquet() {
        List<Flower> birthdayList = Arrays.asList(BIRTHDAY_LIST);
        Pack birthdayPack = Pack.CARDBOARD;
        return new Bouquet(birthdayList, birthdayPack);
    }

    public static Bouquet createDateBouquet() {
        List<Flower> dateList = Arrays.asList(DATE_LIST);
        Pack datePack = Pack.NO_PACK;
        return new Bouquet(dateList, datePack);
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public void addInBouquet(Flower flower) {
        this.flowerList.add(flower);
    }

    public BigDecimal countPriceInDollars() throws IllegalArgumentException{
        if (priceInDollars == null) {
            Function<Flower, BigDecimal> mapper = PriceGetter::takePriceInDollars;
            BigDecimal totalPriceInDollars = flowerList.stream()
                    .map(mapper)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            priceInDollars = totalPriceInDollars.add(this.pack.getPriceInDollars());
        }
        return priceInDollars;
    }

    public void sortFlowersByHeight() {
        flowerList.sort(new ComparatorByHeight());
    }

    public void sortFlowersByPrice() {
        flowerList.sort(new ComparatorByPrice());
    }

    public void sortFlowersByColor() {
        flowerList.sort(new ComparatorByColor());
    }

    public List<Flower> findFlowersByName(FlowerName name) {
        List<Flower> listResult = new ArrayList<>();
        for (Flower f: flowerList) {
            if (f.getName().equals(name)) {
                listResult.add(f);
            }
        }
        return listResult;
    }

    public List<Flower> findFlowersByColor(Color color) {
        List<Flower> listResult = new ArrayList<>();
        for (Flower f: flowerList) {
            if (f.getColor().equals(color)) {
                listResult.add(f);
            }
        }
        return listResult;
    }
}
