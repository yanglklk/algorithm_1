package com.test.designmodel.abstaractFactory;

public class FactoryProducer {

    public static AbstractCarFactory getFactory(Class factoryType){
        if (DCarFactory.class.equals(factoryType)){
            return new DCarFactory();
        }
        if (YCarFactory.class.equals(factoryType)){
            return new YCarFactory();
        }
        return null;
    }
}
