package com.test;

import java.util.Calendar;
import java.util.Date;

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
