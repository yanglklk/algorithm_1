package com.test.designmodel.abstaractFactory;

import com.test.designmodel.abstaractFactory.model.BWM;
import com.test.designmodel.abstaractFactory.model.DCar;
import com.test.designmodel.abstaractFactory.model.TESLA;
import com.test.designmodel.abstaractFactory.model.YCar;


public class DCarFactory extends AbstractCarFactory {

    @Override
    public DCar getDCar(Class type){
        if (BWM.class.equals(type)){
            return new BWM();
        }
        if (TESLA.class.equals(type)){
            return new TESLA();
        }
        return null;
    }

    @Override
    public YCar getECar(Class carType) {
        return null;
    }
}
