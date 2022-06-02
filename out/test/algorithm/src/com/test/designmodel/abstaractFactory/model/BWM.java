package com.test.designmodel.abstaractFactory.model;

public class BWM implements DCar {
    @Override
    public void carName() {
        System.out.println("car Name: "+ BWM.class.getName());
    }

    @Override
    public void charge() {
        System.out.println(BWM.class.getName()+ ": charge");
    }
}
