package com.test;

import java.math.BigDecimal;
import java.util.*;

public class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d2 = new Date();
//        d1.setHours(0);
//        d1.setSeconds(0);
//        d1.setMinutes(0);
//        d2.setHours(0);
//        d2.setSeconds(0);
//        d2.setMinutes(0);
        d1 = DateTest.setHourAndMinuteAndSecond(d1,0,0,0,0);
        d2 = DateTest.setHourAndMinuteAndSecond(d2,0,0,0,0);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.equals(d2));
        BigDecimal b =new BigDecimal("0.01");
        BigDecimal a =new BigDecimal("0.2");

        System.out.println(a.multiply(b));
        System.out.println(BigDecimal.ZERO.compareTo(new BigDecimal("")) < 0);
        System.out.println("____"+String.valueOf(null));
        System.out.println(d1.equals(null));
        int i =10;
        if (i>10){
            System.out.println("12134");
        }else if (i>6){
            System.out.println("111");
        }
        int kk = 2147483647;
        Long l = Long.valueOf(kk);
        System.out.println(Math.pow(2,31));

        List<Integer> ll = new ArrayList<>();
//        ll.add(1);
//        ll.add(null);
//        ll.add(3);
        for (Integer integer : ll) {
            System.out.println(integer.hashCode());
        }

        System.out.println(new Date().before(null));


    }

    public static Date setHourAndMinuteAndSecond(Date target, int templateHour, int templateMinute, int templateSecond,int templateMillSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(target);
        calendar.set(11, templateHour);
        calendar.set(12, templateMinute);
        calendar.set(13, templateSecond);
        calendar.set(14, templateMillSecond);
        return calendar.getTime();
    }
}
