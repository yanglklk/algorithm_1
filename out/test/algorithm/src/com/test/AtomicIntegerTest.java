package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AtomicIntegerTest {


    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        int n = 5;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        System.out.println(list.stream().skip(0).limit(10).collect(Collectors.toList()));
        System.out.println(list.subList(0,10));
    }
}
