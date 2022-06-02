package com.utils;

import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.IfNode;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

public class tree {
    public static void main(String[] args) throws Exception{
       // new tree().shengdanshu();
       // new tree().sum();
        List<Object> list= new ArrayList<>();
        list.add(new Date());
        list.add("123");
        list.forEach(System.out::println);
        Map<String,String> map = new HashMap<>();
        System.out.println(map.keySet().size());
    }
    public void shengdanshu() throws Exception{
        String fileName = "/Users/anjuke/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/96bea7139e0114a5d362787128d1089f/Message/MessageTemp/cfdd36093611ccb7a5352ea4e8e3a840/File/error.log";
int i =0;
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                int start = line.indexOf("commissionUuid:") == -1 ? -1 : line.indexOf("commissionUuid:")+new String("commissionUuid:").length();
                int end = line.indexOf(" createdTime");
                if (start!= -1 && end != -1){
                    System.out.println("'"+line.substring(start,end)+"'");
                    i++;
                    if (i%1000==0){
                        System.out.println("-------");
                    }
                }
            }
        }

    }

    public void sum(){
        BigDecimal a= new BigDecimal("368.00");
        BigDecimal b = new BigDecimal("1328.57");
        System.out.println(a.add(b));
    }
}
