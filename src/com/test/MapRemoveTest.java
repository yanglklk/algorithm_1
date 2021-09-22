package com.test;

import java.util.*;

public class MapRemoveTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        map.put(4,5);
        // Set<Integer> set = map.keySet(); // 获取的是内部对象，他的修改会映射到map，同样会出问题
        // 方法1 2 都是安全的
        // 方法1
        // Set<Integer> set = new HashSet<>(map.keySet());
        // 方法2
         Set<Integer> set = new HashSet<>();
        set.addAll(map.keySet());
        for (Integer integer : set) {
            map.remove(integer);
        }
        System.out.println(map.get(6));

        Map<Integer,Integer> maps = new HashMap<>();
        System.out.println(maps.get(null));

        Long l1 =null;
        System.out.println(l1.toString());

    }
}
