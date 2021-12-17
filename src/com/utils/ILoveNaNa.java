package com.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ILoveNaNa {
    public static void main(String[] args) {
        String[] nanaFeature = new String[]{"亲爱的","可爱的","美丽的","漂亮的","大方的","端庄的","善良的","性感的","妩媚的","温柔的","聪明的"};
        String[] nanaName = new String[]{"娜娜","马丽娜","宝宝","宝贝儿","老宝贝儿～～","NaNa","MLN"};
        String[] gegeFeature = new String[]{"大宝贝儿","黑狗","小狗蛋","烦人精","讨厌鬼"};
        String[] gegeName = new String[]{"YLK","杨连坤","坤坤","哥哥","GeGe"};

        Random random = new Random();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        int[] idx = random.ints(5,0,nanaFeature.length).distinct().toArray();
        StringBuffer nanaFeatureStr = new StringBuffer();
        for (int i : idx) {
            nanaFeatureStr.append(nanaFeature[i]);
        }
        System.out.println("现在是"+ dateStr +", 今天的"
                +gegeFeature[random.nextInt(gegeFeature.length)]
                +gegeName[random.nextInt(gegeName.length)]
                +"对"
                +nanaFeatureStr
                +nanaName[random.nextInt(nanaName.length)]
                +"的爱是"
                +date.getTime()
                +
                "分！！！！！！");
    }
}
