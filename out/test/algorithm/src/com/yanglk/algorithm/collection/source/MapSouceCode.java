package com.yanglk.algorithm.collection.source;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapSouceCode {


    public static void main(String[] args) {
        ConcurrentHashMap map=new ConcurrentHashMap(16,0.25f);
        //TreeMap<Integer,String> map=new TreeMap<>((o1, o2) -> o2-o1);
        //tmap.put(null,12);
        //HashMap<Integer, String> map = new HashMap(16);
        //map.put(null,"12");
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果：");

    }

}
