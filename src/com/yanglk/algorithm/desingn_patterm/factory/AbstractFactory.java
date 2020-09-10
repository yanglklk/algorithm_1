package com.yanglk.algorithm.desingn_patterm.factory;

public class AbstractFactory {

    public static void main(String[] args) {
        //前驱车工厂
        // 两个品牌的车都会生产 只有前驱车
        AbsCarFactory absCarFactory= new BPowerCarFactory();
        AbsCar bwm1=absCarFactory.getBwm();
        AbsCar benz=absCarFactory.GetBenz();

    }
}
// 假设 现在车的种类有 前驱 后驱
// 大的产品族就是前后驱 两种
// 每个具体的产品 又可以细化到那两种里面去
// 所以具体到最后就是四种 不同的品牌+ 不同驱动
// 顶层的抽象工厂只负责 那种品牌
// 次级工厂负责 某一种类 各品牌的生产
// 工厂方法的工厂 一种产品 car 具体到工厂来生产那一类 bwm 还是benz
// 使用工厂方法需要简历多个对应具体产品的工厂
// 抽象工厂只是建立相应产品种类的工厂 在工厂里实现所有产品族
// 抽象工厂 是某一类 bwm 还是benz  这两类就是产品族
// 具体到工厂里 是针对不同的每个产品族里不同的种类了 这里会生产某个种类里各个产品族的产品
// 解决接口选择的问题
//
interface AbsCar{
    public void run();
    public void power();
}

abstract  class BWM1 implements AbsCar{

    @Override
    public void run() {
        System.out.println("BWM is run" );
    }


}
abstract class Benz1 implements AbsCar{

    @Override
    public void run() {
        System.out.println("Benz is run" );
    }


}

interface AbsCarFactory{
    BWM1 getBwm();
    Benz1 GetBenz();
}
class FPowerCarFactory implements AbsCarFactory{
    @Override
    public BWM1 getBwm() {
        return new FPowerBWM();
    }

    @Override
    public Benz1 GetBenz() {
        return new FPowerBenz();
    }
}

class BPowerCarFactory implements AbsCarFactory{
    @Override
    public BWM1 getBwm() {
        return new BPowerBWM();
    }

    @Override
    public Benz1 GetBenz() {
        return new BPowerenz();
    }
}


class FPowerBWM extends BWM1 {
    @Override
    public void power() {
        System.out.println("前驱车");
    }
}
class BPowerBWM extends BWM1 {
    @Override
    public void power() {
        System.out.println("后驱车");
    }
}

class FPowerBenz extends Benz1 {
    @Override
    public void power() {
        System.out.println("前驱车");
    }
}
class BPowerenz extends Benz1 {
    @Override
    public void power() {
        System.out.println("后驱车");
    }
}


