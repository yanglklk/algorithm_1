package com.test;

import org.apache.commons.lang.time.DateUtils;

import java.text.DecimalFormat;
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
        Date start =new SimpleDateFormat("yyyy-MM-DD").parse("2021-10-01");
        start = DateUtils.addMonths(start,1);
        System.out.println(start);
        System.out.println(null+"-"+null);
        double result = 0.34;
        DecimalFormat df = new DecimalFormat("0.00%");
        String r = df.format(result);
        System.out.println(r);
        System.out.println("----");
        System.out.println(CycleTypeEnum.MONTH.code.getClass());
        System.out.println(CycleTypeEnum.MONTH.equals("1"));
        System.out.println(Integer.valueOf("001"));
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

    enum CycleTypeEnum {
        MONTH(1, "按月结算"),
        WEEK(2, "按周结算"),
        DAY(3, "按日结算"),;

        private Integer code;

        private String value;

        CycleTypeEnum() {

        }

        public static String getValueByCode(Integer code) {
            for (CycleTypeEnum bonusBackCodeEnum : CycleTypeEnum.values()) {
                if (bonusBackCodeEnum.getCode().equals(code)) {
                    return bonusBackCodeEnum.getValue();
                }
            }
            return null;
        }

        CycleTypeEnum(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
