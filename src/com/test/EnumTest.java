package com.test;

import com.google.common.collect.Lists;

import java.util.List;

public class EnumTest {
    public static void main(String[] args) {
        List<EEE> list = Lists.newArrayList(EEE.E1,EEE.E2,EEE.E3);
        EEE eee = EEE.E1;
        System.out.println(list.contains(EEE.E1));
        System.out.println(list.contains(null));
    }

}
enum EEE{
    E1("e1","111"),
    E2("e2","222"),
    E3("e3","333");
    private String name;
    private String desc;

    EEE(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}