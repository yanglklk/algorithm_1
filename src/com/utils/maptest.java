package com.utils;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class maptest {

    public static void main(String[] args) {

        System.out.println(Objects.equals(new BigDecimal("0"),BigDecimal.ZERO));
        BigDecimal b1 = new BigDecimal(189.6522);
        BigDecimal b2 = new BigDecimal("189.6522");
        System.out.println(amount(b1,0));
        ArrayList<BigDecimal> bigDecimals = Lists.newArrayList(b1, b2,new BigDecimal(-29.755));
        BigDecimal reduce = bigDecimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(maptest.amount(b1,2));
        System.out.println(maptest.amount(b2,2));
        //System.out.println(null == 3);
        System.out.println( String.format("%02d",58));
        int day = maptest.convertDate2LocalDateTime(new Date()).getDayOfMonth();
        System.out.println((String.format("%02d",day)));



    }

    public static BigDecimal amount(BigDecimal amount, int scale) {
        if (amount == null) {
            return BigDecimal.ZERO;
        }
        return amount.setScale(scale, RoundingMode.HALF_UP);
    }

    public static LocalDateTime convertDate2LocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
