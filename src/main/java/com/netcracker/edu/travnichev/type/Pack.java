package com.netcracker.edu.travnichev.type;

import com.netcracker.edu.travnichev.exception.ExceptionMessages;
import com.netcracker.edu.travnichev.parameter.MoneyParams;

import java.math.BigDecimal;

public enum Pack {
    NO_PACK("0"),
    CARDBOARD("1"),
    CELLOPHANE("2");

    private BigDecimal priceInDollars;

    Pack(String priceInDollars) {
        this.setPriceInDollars(new BigDecimal(priceInDollars));
        this.priceInDollars = this.priceInDollars.setScale(MoneyParams.SCALE, MoneyParams.ROUNDING_MODE);
    }

    public void setPriceInDollars(BigDecimal priceInDollars) throws IllegalArgumentException {
        if (priceInDollars.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new IllegalArgumentException(ExceptionMessages.BELOW_ZERO);
        }
        this.priceInDollars = new BigDecimal(priceInDollars.toString());
    }

    public BigDecimal getPriceInDollars() {
        return priceInDollars;
    }


    @Override
    public String toString() {
        return "Pack: [" +
                "name: " + this.name() + ", " +
                "price: " + this.priceInDollars + "$]";
    }
}
