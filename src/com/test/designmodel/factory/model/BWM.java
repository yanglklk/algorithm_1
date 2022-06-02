package com.test.designmodel.factory.model;

public class BWM implements Car{
    @Override
    public void carName() {
        System.out.println("car Name: "+BWM.class.getName());
    }
}
