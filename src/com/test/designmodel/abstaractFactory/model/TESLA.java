package com.test.designmodel.abstaractFactory.model;

public class TESLA implements DCar {
    @Override
    public void carName() {
        System.out.println("car Name: "+ TESLA.class.getName());
    }

    @Override
    public void charge() {
        System.out.println(TESLA.class.getName()+ ": charge");
    }
}
