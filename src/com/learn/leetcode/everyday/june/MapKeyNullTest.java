package com.learn.leetcode.everyday.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapKeyNullTest {
    public static void main(String[] args) throws Exception {
        Map<String,Object> map = new HashMap<>();
        System.out.println(map.keySet());
        System.out.println(map.containsKey("1"));
        System.out.println(map.get("1"));
        if (map.keySet() != null){
            throw new Exception("ee");
        }
        List<String> list = new ArrayList();
        //List<String> list = null;
        System.out.println("-------");
        list.stream().forEach(f-> f="123");


    }
}
