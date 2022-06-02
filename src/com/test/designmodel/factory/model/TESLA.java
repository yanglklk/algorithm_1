package com.test.designmodel.factory.model;

public class TESLA implements Car{
    @Override
    public void carName() {
        System.out.println("car Name: "+TESLA.class.getName());
    }
}
