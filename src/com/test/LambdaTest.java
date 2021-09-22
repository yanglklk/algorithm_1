package com.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.Adler32;

public class LambdaTest {
    public static void main(String[] args) {
//        Map<Integer,Integer> map = putAll(false);
//        map.entrySet().stream().forEach(f-> System.out.println(f.getKey()+":"+f.getValue()));
        AAA a1 = new AAA("1","yyy");
        AAA a2 = new AAA(null,"yyy1");
        AAA a3 = new AAA(null,null);
        AAA a4 = new AAA("1","yyy4");
        List<AAA> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        Map<String,String> map= new HashMap<>();
        map =list.stream().collect(Collectors.toMap(AAA::getId,AAA::getName,(v1,v2)->v2));
        System.out.println(map.entrySet().stream().collect(Collectors.toList()));



    }

    private static Map<Integer, Integer> putAll(boolean flag) {
        List<Integer> list = Lists.newArrayList(1,2,3);
        Set<Integer> set = Sets.newHashSet();
        Map<Integer,Integer> map = Maps.newHashMap();
        Map<Integer,Integer> map1 = Maps.newHashMap();
        map1.put(1,3);
        map1.put(2,4);
        if (flag){
            // 不能直接赋值使用 因为后面lambda中使用的一定要是final 类型
            // map = map1;
            // 可以使用 putAll 在再赋值 list set 同理 addAll
            map.putAll(map1);
        }
        else {
            list.stream().peek(f-> System.out.println(f)).collect(Collectors.toList()).stream().peek(f-> System.out.println("ff"+f)).collect(Collectors.toList()).forEach(System.out::println);
            //collect(Collectors.toList());
            //list.stream().forEach(f-> System.out.println(f));
            //list.stream().map(f-> map.put(f,f*2));
            //list.stream().map(f-> map.put(f,f*2)).collect(Collectors.toList());
            list.stream().forEach(f-> map.put(f,f*2));
        }
        return map;
    }
}

class AAA{
    private String id;
    private String name;

    public AAA(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}