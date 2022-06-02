package com.test.designmodel.factory;

import com.test.designmodel.factory.model.BWM;
import com.test.designmodel.factory.model.Car;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        Car car = new CarFactory().getCar(BWM.class);
        car.carName();
    }
}
