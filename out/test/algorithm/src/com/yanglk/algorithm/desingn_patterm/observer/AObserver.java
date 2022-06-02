package com.yanglk.algorithm.desingn_patterm.observer;

public class AObserver implements Observer{

    private Subject subject;

    public AObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Integer.toBinaryString "+Integer.toBinaryString(subject.getStatus()));
    }
}
