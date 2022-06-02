package com.test;

import java.lang.instrument.Instrumentation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = BigDecimal.ZERO.divide(BigDecimal.ONE);
        System.out.println("a.toString(): "+a.setScale(2).toString());
        System.out.println("b.toString(): "+b.toString());
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println(a == b);
        BigDecimal c = new BigDecimal("2.3");
//        BigDecimal d = new BigDecimal(2.3);
//        System.out.println("c.toString(): "+c.setScale(2).toString());
//        System.out.println("d.toString(): "+d.setScale(2, RoundingMode.DOWN).toString());
//        System.out.println("d.toString(): "+d.toString());
        System.out.println(new Date());
        Date d = BigDecimalTest.getStartTime();
        Date t = BigDecimalTest.addDays(d,-1);
        System.out.println(d);
        System.out.println(t);
        BigDecimal bb = new BigDecimal("83134143.14");
        BigDecimal aa = new BigDecimal("9313415416.86");
        System.out.println("--------"+bb.divide(aa,12,RoundingMode.UP).multiply(aa).setScale(2,RoundingMode.DOWN));
        //System.out.println((aa.multiply(new BigDecimal("0.88")))
         //       .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
        //System.out.println(BigDecimal.ZERO.compareTo(null));

    }
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date addDays(Date date_, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date_.getTime());
        cal.add(Calendar.DATE, day);

        return cal.getTime();
    }

}
