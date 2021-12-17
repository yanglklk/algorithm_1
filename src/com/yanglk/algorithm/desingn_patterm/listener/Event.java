package com.yanglk.algorithm.desingn_patterm.listener;

import com.yanglk.algorithm.offer.Str;

public abstract class Event {
    Listener listener ;
    Integer integer;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
    //static

    // 事件出发动作
    abstract void  dealdate();

}
