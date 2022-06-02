package com.yanglk.algorithm.desingn_patterm.single;
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 22:05 2020/5/7
 * @Param
 * @return
 *
 * 简单懒汉
 * 线程安全问题
 **/
public class Single2 {
    // 构造方法私有
    private Single2(){

    };
    // 懒汉 不创建对象
    private static Single2 single2=null;
    // 外部获取方法
    public static Single2 getSingle1(){
        //用的时候没有再创建
        if (single2==null){
            single2=new Single2();
        }
        return single2;
    }

}
