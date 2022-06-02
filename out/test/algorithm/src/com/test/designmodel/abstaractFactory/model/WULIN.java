package com.test.designmodel.abstaractFactory.model;

public class WULIN implements YCar{
    @Override
    public void jiayou() {
        System.out.println(WULIN.class.getName() + ": jiaoyou");
    }
}
