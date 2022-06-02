package com.test.designmodel.abstaractFactory;

import com.test.designmodel.abstaractFactory.model.DCar;
import com.test.designmodel.abstaractFactory.model.YCar;

public abstract class AbstractCarFactory {

    public abstract DCar getDCar(Class carType);
    public abstract YCar getECar(Class carType);
}
