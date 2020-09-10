package com.yanglk.algorithm.desingn_patterm.single;
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 21:59 2020/5/7
 * @Param
 * @return
 *
 * 饿汉式
 * 一上来就创建 浪费内存
 *
 **/
public class Single1 {
    // 构造方法私有
    private Single1(){

    };
    // 饿汉 先创建对象
    private static Single1 single1=new Single1();
    // 外部获取方法
    public static Single1 getSingle1(){
        return single1;
    }
}
