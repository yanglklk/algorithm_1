package com.test.designmodel.factory;

import com.test.designmodel.factory.model.BWM;
import com.test.designmodel.factory.model.Car;
import com.test.designmodel.factory.model.TESLA;
import com.yanglk.algorithm.offer.Str;

public class CarFactory {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public  Car getCar(Class type){
        if (BWM.class.equals(type)){
            this.car = new BWM();
        }
        if (TESLA.class.equals(type)){
            this.car = new TESLA();
        }
        return this.car;
    }
}
