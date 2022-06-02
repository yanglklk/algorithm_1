package com.test.designmodel.obervation;

// 短信订阅者
public class ObservorA extends Observor{

    public ObservorA(Subject subject) {
        this.subject = subject;
        this.subject.addObservor(this);
    }

    // 订阅者接收变动后的动作
    @Override
    public void update() {
        System.out.println("ObservorA update: "+ this.subject.getStatus());
    }
}
