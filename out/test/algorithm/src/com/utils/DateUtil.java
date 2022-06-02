package com.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static void main(String[] args) {


        LocalDate prevWeek = LocalDate.of(2021,1,1);
        Map<String, Integer> weekAndMonthAndYear = DateUtil.getWeekAndMonthAndYear(Date.from(prevWeek.atStartOfDay(ZoneOffset.ofHours(8)).toInstant()), 2);
        weekAndMonthAndYear.entrySet().forEach(System.out::println);
    }

    public static Map<String,Integer> getWeekAndMonthAndYear(Date date,int  cycleType) {
        Map<String,Integer> result =  new HashMap<String,Integer>();

        SimpleDateFormat formatMon = new SimpleDateFormat("MM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");

        int week =0;
        int month = Integer.valueOf(formatMon.format(date));
        int year = Integer.valueOf(formatYear.format(date));
        int day = Integer.valueOf(formatDay.format(date));
        if (cycleType==2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setMinimalDaysInFirstWeek(4);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.setTime(date);
            week = calendar.get(Calendar.WEEK_OF_YEAR);
            month = calendar.getWeekYear()==year? month:12;
            year = calendar.getWeekYear();
        }

        result.put("year",year);
        result.put("month",month);
        result.put("week",week);
        return result;
    }
}
