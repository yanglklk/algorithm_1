package com.utils;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSErrorType;

public class Str2Json {
    public static void toJson(String str){
        Object o = JSON.parse(str);
        System.out.println(o.toString());
    }


}
