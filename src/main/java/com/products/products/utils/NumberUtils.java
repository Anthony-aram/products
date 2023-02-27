package com.products.products.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class NumberUtils {

    /**
     * Round to certain number of decimals
     *
     * @param number Number that we want to round
     * @param decimalPlace Number of decimal
     * @return Rounded number
     */
    public static float round(float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(number));
        bd = bd.setScale(decimalPlace, RoundingMode.valueOf(decimalPlace));
        return bd.floatValue();
    }
}
