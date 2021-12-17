package com.utils;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class RetainAllTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.retainAll(Lists.newArrayList(1,3));
        System.out.println(list);
    }
}
