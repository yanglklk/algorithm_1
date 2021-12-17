package com.test;

import com.yanglk.algorithm.offer.Str;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        Long l1 =null;
//        System.out.println(l1.toString());

        System.out.println(maps.get(null));

        Map<Integer,Integer> map1 = new HashMap<>();

        System.out.println(map1.get(null));
        map1.put(2,3);
        Map<Integer,Map<Integer,Integer>> map2 = new HashMap<>();
        map2.put(1,map1);
        System.out.println(Optional.ofNullable(map2.get(1))
                        .map(f-> f.get(2))
                        .get()
                //.get()
        );

        System.out.println(Optional.ofNullable(map2.get(1))
                .orElse(new HashMap<>())
                .entrySet()
                .stream()
                .filter(f->f.getKey().equals(2))
                .map(f-> f.getValue())
                .findFirst()
                .orElse(4)
        );

        System.out.println(Optional.ofNullable(map2.get(1))
                        .orElse(new HashMap<>()).get(2));


        System.out.println(Optional.empty().map(f-> f.getClass()));

       // List lll =new ArrayList();
        List<Integer> lll =null;
//        System.out.println(lll.stream()
//                .map(f->f+2)
//                .collect(Collectors.toList()));
        System.out.println(Optional.ofNullable(lll)
                .map(f->f.add(2)));

        System.out.println("--------------");
        Map<Integer, Supplier<Integer>> map3 = new HashMap<>();
        map3.put(1,()->getInt(2));
        map3.put(3,()->getInt(3));
        map3.entrySet().stream().peek(f-> System.out.println(f.getValue().get())).collect(Collectors.toList());
        System.out.println(map3.get(1).get());
        System.out.println(DateTest.class.getName());
    }
    public static Integer getInt(int i ){
        return i*7;
    }
}
