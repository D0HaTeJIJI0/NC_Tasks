package com.netcracker.edu.travnichev.model.helper;

import com.netcracker.edu.travnichev.exception.ExceptionMessages;
import com.netcracker.edu.travnichev.model.Aster;
import com.netcracker.edu.travnichev.model.Chamomile;
import com.netcracker.edu.travnichev.model.Flower;
import com.netcracker.edu.travnichev.model.Rose;

import java.math.BigDecimal;

public class PriceGetter {
    public static BigDecimal takePriceInDollars(Flower flower) {
        if (flower instanceof Rose) {
            return Rose.getPriceInDollars();
        }
        else if (flower instanceof Chamomile) {
            return Chamomile.getPriceInDollars();
        }
        else if (flower instanceof Aster) {
            return Aster.getPriceInDollars();
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.UNKNOWN_FLOWER);
        }
    }
}
