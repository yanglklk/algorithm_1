package com.yanglk.algorithm.desingn_patterm.factory;

public class FacforyMethod {
    public static void main(String[] args) {
        Car bwm= new BWMCarFactory().getCar();
        bwm.run();
        Car benz= new BenzCarFactory().getCar();
        benz.run();
    }

}
// 工厂放方法模式
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 21:23 2020/5/7
 * @Param
 * @return
 * 一、抽象工厂 对应抽象产品
 * 二、具体的生产工厂 生产具体产品
 * 三、 抽象产品
 * 四、 具体产品
 *
 * 多态理解 父类引用指向子类对象 实现子类重写方法 不能使用 子类自定义的方法
 **/
abstract class Car{
    abstract  void run();

}
class BWM extends Car{

    @Override
    void run() {
        System.out.println("BWM is run" );
    }

    void tt(){
        System.out.println("tt");
    }
}
class Benz extends Car{

    @Override
    void run() {
        System.out.println("Benz is run" );
    }


}
interface CarFactory{
   Car getCar();
}
class BWMCarFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new BWM();
    }
}

class BenzCarFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new Benz();
    }
}
