package com.test.relect;

import com.alibaba.fastjson.JSON;
import com.test.cloneTest.Car;

import javax.smartcardio.CardChannel;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        Car car =new Car("bwm",123);
        System.out.println(MyReflect.getValue(car, "brand"));
        MyReflect.setValue(car,"brand","weilai");
        System.out.println(JSON.toJSONString(car));
        MyReflect.methodInvoke(car,"setBrand","wwe");
        System.out.println(JSON.toJSONString(car));



    }
}
