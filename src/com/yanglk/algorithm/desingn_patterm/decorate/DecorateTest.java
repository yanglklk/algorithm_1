package com.yanglk.algorithm.desingn_patterm.decorate;
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 10:54 2020/5/8
 * @Param
 * @return
 *
 * 1 产品接口
 * 2 具体产品
 * 3 抽象产品装饰器 继承自产品接口 通过组合 传入产品 重写方法
 * 4 具体装饰器 添加增强内容的方法 重写方法
 * 拓展的逻辑可以自定义 添加或消除
 *
 * 增强三种方式
 * 1 继承  会将顺序写死，增加或删除破坏继承逻辑顺序 难以维护
 * 2 代理  生成代理对象 在目标方法前后增强内容
 * 3 包装器 通过装饰器 对对象层层包装 每一层的包装没有逻辑顺序 便于维护
 *
 **/
public class DecorateTest {


    public static void main(String[] args) {
        Car car=new StopCar(new StartCar(new BWM()));
        car.run();
    }
}


// 抽象产品
interface Car{
     void run();

     void didi();
}
// 具体产品实例
class BWM implements Car {

    @Override
    public void run() {
        System.out.println("BWM is run");
    }

    @Override
    public void didi() {
        System.out.println("didididi");
    }
}


abstract class DecorateCar implements Car{

    //组合 要包装的对象
    private Car car;
    public DecorateCar(Car car){
        this.car=car;
    }
    // 重写要增强的方法
    // 即使不增强也要重写 这里不重写 后面的非抽象子类也要重写
    @Override
    public void run() {
        car.run();
    }
    //


    @Override
    public void didi() {
        car.didi();
    }
}
//
class StopCar extends DecorateCar{
    StopCar(Car car) {
        super(car);
    }
   // 具体要增强的内容
    public void stopCar(){
        System.out.println( "car is stop");
    }
    //重写增强方法 加入要增强的内容
    @Override
    public void run() {
        super.run();
        this.stopCar();
    }
}

class StartCar extends DecorateCar{
    StartCar(Car car) {
        super(car);
    }

    public void startCar(){
        System.out.println( "car is start");
    }

    @Override
    public void run() {
        this.startCar();
        super.run();
    }
}


