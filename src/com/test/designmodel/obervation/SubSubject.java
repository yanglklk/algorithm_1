package com.test.designmodel.obervation;

// 减少订单主题
public class SubSubject extends Subject{
    @Override
    void setStatus(Integer status) {
        this.status=--status;
        notifyAllObservor();
    }
}
