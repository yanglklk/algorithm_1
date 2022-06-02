package com.yanglk.algorithm.desingn_patterm.observer;

public class BObserver implements Observer{

    private Subject subject;

    // 在构造的时候将要观察的对象存入
    public BObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Integer.toOctalString "+Integer.toOctalString(subject.getStatus()));
    }
}
