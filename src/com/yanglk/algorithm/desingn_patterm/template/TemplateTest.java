package com.yanglk.algorithm.desingn_patterm.template;

public class TemplateTest {
    public static void main(String[] args) {
        Car bwm=new BWM();
        bwm.carMove();
        Car benz=new Benz();
        benz.carMove();
    }
}
// 将那些根据实现类不同的方法 抽象出来
// 将固定的步骤 final 固定下来 封装在一个方法中
abstract class Car{
    abstract void start();
    abstract void stop();
    abstract void run();
    final void carMove(){
        start();
        run();
        stop();
    }
}

// 根据不同的实现类 来实现具体方法 但是步骤已经固定
class BWM extends Car{
    @Override
    void start() {
        System.out.println("电打火");
    }

    @Override
    void stop() {
        System.out.println("刹车");
    }

    @Override
    void run() {
        System.out.println("马路上");
    }
}


class Benz extends Car{
    @Override
    void start() {
        System.out.println("手摇");
    }

    @Override
    void stop() {
        System.out.println("撞墙");
    }

    @Override
    void run() {
        System.out.println("田野里上");
    }
}
