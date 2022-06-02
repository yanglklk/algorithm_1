package com.test.designmodel.abstaractFactory;

import com.test.designmodel.abstaractFactory.model.BWM;
import com.test.designmodel.abstaractFactory.model.DCar;
import com.test.designmodel.abstaractFactory.model.WULIN;
import com.test.designmodel.abstaractFactory.model.YCar;
import com.test.designmodel.single.DDLSingle;
import com.test.jvmTest.A;

import javax.swing.*;

public class TestAbstractFactory {

    public static void main(String[] args) {
        AbstractCarFactory abstractCarFactory = FactoryProducer.getFactory(DCarFactory.class);
        DCar BWM = abstractCarFactory.getDCar(BWM.class);
        abstractCarFactory= FactoryProducer.getFactory(YCarFactory.class);
        YCar wuling = abstractCarFactory.getECar(WULIN.class);
        BWM.charge();
        wuling.jiayou();
    }
}
