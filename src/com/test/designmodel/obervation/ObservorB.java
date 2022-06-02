package com.test.designmodel.obervation;

// 微信订阅者
public class ObservorB extends Observor{

    public ObservorB(Subject subject) {
        this.subject = subject;
        this.subject.addObservor(this);
    }
    //
    @Override
    public void update() {
        System.out.println("ObservorB update: "+ this.subject.getStatus());
    }
}
