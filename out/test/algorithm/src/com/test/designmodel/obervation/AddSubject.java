package com.test.designmodel.obervation;

// 增加订单主题
public class AddSubject extends Subject{
    @Override
    void setStatus(Integer status) {
        this.status=++status;
        notifyAllObservor();
    }
}
