package com.test.designmodel.obervation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 抽象主题
public abstract class Subject {
    // 主题下 的订阅者/观察者列表
    List<Observor> list = new ArrayList<>();
    public Integer status;

    public Integer getStatus() {
        return status;
    }

    abstract void setStatus(Integer status);

    // 增加订阅
    public void addObservor(Observor observor){
        list.add(observor);
    }
    // 减少订阅
    public void romoveObervor(Observor observor){
        list.remove(observor);
    }
    // 消息通知
    public void notifyAllObservor(){
        for (Observor observor : list) {
            observor.update();
        }
    }
}
