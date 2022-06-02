package com.yanglk.algorithm.aaaacplus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
//        int n=398,r=0,sum=0;
//        for (;;sum=0)
//        {
//            for (;; )
//            {
//                r = n % 10;
//                n = n / 10;
//                sum += r;
//                if (n == 0)  break;
//            }
//            n = sum;
//            if ( n <= 9)  break;
//
//        }
        Date date=new Date(1585540200*1000);
        long time1 = 1585540200;
//        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time1 * 1000));
//        System.out.println("10位数的时间戳（秒）--->Date:" + result1);
        Date date1 = new Date(time1*1000);
        System.out.println(date1);

    }
}
