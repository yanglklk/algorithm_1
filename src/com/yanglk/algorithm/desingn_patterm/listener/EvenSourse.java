package com.yanglk.algorithm.desingn_patterm.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenSourse {
    private Map<String, Listener> listenerMap = new HashMap<>();

    // 监听者的注册
    public void register(String listenerName,Listener listener){
        if (listenerMap.keySet().contains(listenerName)){
            System.out.println("注册名已存在，请重新选择");
        }
        listenerMap.put(listenerName,listener);
    }


    // 监听者移除
    public void remove(String listenerName){
        listenerMap.remove(listenerName);
    }


}
