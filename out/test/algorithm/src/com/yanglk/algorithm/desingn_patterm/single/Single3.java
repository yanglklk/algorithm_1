package com.yanglk.algorithm.desingn_patterm.single;
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 22:24 2020/5/7
 * @Param
 * @return
 *
 * 双重锁机制
 * volatile 防止指令重排 解决初始化非原子操作
 **/
public class Single3 {
    // 构造方法私有
    private Single3(){

    }
    // 懒汉 不创建对象
    //使用volatile 防止指令重排 栈中引用指向堆区域 与 堆中对象初始化会重排

    private volatile  static Single3 single3=null;
    // 外部获取方法
    public static Single3 getSingle1(){
        //用的时候没有再创建
        // 这个判断是提高性能
        if (single3==null){
            synchronized (Single3.class){
                // 这里防止第二个进入的线程 再创建对象
                if (single3==null){
                    single3=new Single3();
                }
            }

        }
        return single3;
    }

}
