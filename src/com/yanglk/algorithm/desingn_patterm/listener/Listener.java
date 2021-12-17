package com.yanglk.algorithm.desingn_patterm.listener;

import com.yanglk.algorithm.thread.Print;

public interface Listener<T> {


    // 监听方法的回调函数模版
    void invoke(T data);

}
