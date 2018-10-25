package com.netcracker.edu.travnichev.comparator;

import com.netcracker.edu.travnichev.model.*;
import com.netcracker.edu.travnichev.model.helper.PriceGetter;

import java.math.BigDecimal;
import java.util.Comparator;

public class ComparatorByPrice implements Comparator<Flower> {

    @Override
    public int compare(Flower o1, Flower o2) {
        BigDecimal price1 = PriceGetter.takePriceInDollars(o1),
                price2 = PriceGetter.takePriceInDollars(o2);
        return price1.compareTo(price2);
    }
}
