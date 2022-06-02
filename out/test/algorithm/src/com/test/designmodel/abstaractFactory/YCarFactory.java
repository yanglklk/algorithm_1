package com.test.designmodel.abstaractFactory;

import com.test.designmodel.abstaractFactory.AbstractCarFactory;
import com.test.designmodel.abstaractFactory.model.DCar;
import com.test.designmodel.abstaractFactory.model.WULIN;
import com.test.designmodel.abstaractFactory.model.YCar;

public class YCarFactory extends AbstractCarFactory {

    @Override
    public DCar getDCar(Class carType) {
        return null;
    }

    @Override
    public YCar getECar(Class carType) {
        if (YCar.class.equals(carType)){
            return new WULIN();
        }
        return null;
    }
}
