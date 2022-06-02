package com.test.relect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.OffsetDateTime;

public class MyReflect {

    public MyReflect() {
    }

    public static Object getValue(Object source,String field){
        Class<?> aClass = source.getClass();
        try {
            Field declaredField = aClass.getDeclaredField(field);
            declaredField.setAccessible(true);
            Object o = declaredField.get(source);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }

    public static void setValue(Object source,String field,Object val){
        Class<?> aClass = source.getClass();
        try {
            Field declaredField = aClass.getDeclaredField(field);
            declaredField.setAccessible(true);
            declaredField.set(source,val);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void methodInvoke(Object object,String method,Object args){
        Class<?> aClass = object.getClass();
        try {
            Method getBrand = aClass.getMethod(method,args.getClass());
            getBrand.invoke(object,args);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
