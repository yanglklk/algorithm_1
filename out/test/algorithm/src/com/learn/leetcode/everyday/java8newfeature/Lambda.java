package com.learn.leetcode.everyday.java8newfeature;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        InnerClassA a1 = new InnerClassA(1,"a1");
        InnerClassA a2 = new InnerClassA(2,"a2");
        InnerClassA a3 = new InnerClassA(3,"a3");
        List<InnerClassA> list1 = Lists.newArrayList(a1,a2,a3);
        List list2 = list1.stream().filter(f -> f.getAge()<3).collect(Collectors.toList());
        list1.forEach(System.out::println);
        list2.forEach(System.out::println);

    }
}
class InnerClassA{
    private int age;
    private String name;

    public InnerClassA(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
