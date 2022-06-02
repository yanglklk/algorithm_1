package com.yanglk.algorithm.desingn_patterm.listener;

import com.yanglk.algorithm.desingn_patterm.observer.Subject;
import com.yanglk.algorithm.offer.Str;

public class AEvent extends Event{

    // 事件源是对于每个类型的事件的
    EvenSourse evenSourse = new EvenSourse();

    AEvent(String name,Listener listener){
        this.listener =listener;
        evenSourse.register(name,listener);
    }
    public void print(){
        System.out.println("ppp");
        dealdate();
    }

    // 出发动作后 通知监听者
    @Override
    public void dealdate() {
        listener.invoke(this.integer);
    }
}
