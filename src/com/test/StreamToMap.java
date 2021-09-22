package com.test;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {
    public static void main(String[] args) {
        Stu stu1 = new Stu("y",1);
        Stu stu2 = new Stu("mmm",1);
        Stu stu3 = new Stu("yyy",2);
        Stu stu4 = new Stu("lll",2);
        System.out.println(stu1.getAge().hashCode());
        System.out.println(stu2.getAge().hashCode());
        ArrayList<Stu> list = Lists.newArrayList();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        //(f1, f2) -> f1) 在key值相同的情况下要保留的value是哪一个
        Map<Integer,Stu> map1 = list.stream().collect(Collectors.toMap(Stu::getAge, Function.identity(), (f1, f2) -> f1));
        System.out.println(map1.get(1).getName());
        System.out.println(map1.get(2).getName());
    }
}
class Stu{
    private  String name;
    private Integer age;

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
