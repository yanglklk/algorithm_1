package com.yanglk.algorithm.desingn_patterm.factory;

import com.yanglk.algorithm.offer.Str;

public class SimpleFactory {
    public static void main(String[] args) {
        SimpleCarFactory simpleCarFactory=new SimpleCarFactory();
        Car bwm= simpleCarFactory.getCar("bwm");
        bwm.run();
        Car benz= simpleCarFactory.getCar("benz");
        benz.run();
    }
}
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 21:49 2020/5/7
 * @Param 
 * @return
 *
 * 相较于工厂方法模式做出了简化
 * 只有一个简单工厂 根据类型制造相应的产品返回
 **/
class SimpleCarFactory{
    public Car getCar(String carname){
        if (carname.equals("bwm")){
            return new BWM();
        }
        if (carname.equals("benz")){
            return new Benz();
        }
        return null;
    }

}
