package com.test;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateConvertTest {
    public static void main(String[] args) throws Exception {
        DateConvertTest dateConvertTest = new DateConvertTest();
        Date  date = new Date();
        date= DateUtils.addWeeks(date,3);
        date = DateUtils.addDays(date ,-4);
        dateConvertTest.getWeekAndMonthAndYear(date);
        Date start =new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-1");
        start = DateUtils.addMonths(start,1);
        System.out.println(start);
        System.out.println(null+"-"+null);
    }
    private Map<String,Integer> getWeekAndMonthAndYear(Date date) {
        Map<String,Integer> result =  new HashMap<String,Integer>();
        Calendar cal = Calendar.getInstance();

        //设置一周的开始,默认是周日,这里设置成星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);

        SimpleDateFormat formatMon = new SimpleDateFormat("MM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        cal.setTime(date);
        int month = Integer.valueOf(formatMon.format(date));
        int year = Integer.valueOf(formatYear.format(date));
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        if(week == 1 && month == 12){
            year++;
        }
        result.put("year",year);
        result.put("month",month);
        result.put("week",week);
        return result;
    }
}
