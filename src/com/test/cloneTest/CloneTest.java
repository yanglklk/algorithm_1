package com.test.cloneTest;

import com.alibaba.fastjson.JSON;

public class CloneTest {
    public static void main(String[] args) {
        Person p1 = new Person("Hao LUO", 33, new Car("Benz",300));
        Person p2 = null;
        try {
            p2 = MyClone.clone(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(p1));
        System.out.println(JSON.toJSONString(p2));
        //p2.getCar().setBrand("yyy");
        System.out.println(JSON.toJSONString(p1));
        System.out.println(JSON.toJSONString(p2));
    }

}
