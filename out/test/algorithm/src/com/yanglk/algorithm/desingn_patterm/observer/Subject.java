package com.yanglk.algorithm.desingn_patterm.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int status;

    public int getStatus() {
        return status;
    }

    // 更改状态通知观察者
    public void setStatus(int status) {
        this.status = status;
        notifyAllObserver();
    }

    // 在构造subject时进行注册
    public void register(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObserver(){
        for (Observer observer : observers) {
            observer.update();
        }
    }


}
