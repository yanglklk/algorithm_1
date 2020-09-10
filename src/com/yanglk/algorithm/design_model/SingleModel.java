package com.yanglk.algorithm.design_model;

import jdk.nashorn.internal.ir.IfNode;

import java.sql.SQLOutput;

public class SingleModel {


    public static void main(String[] args) {
        Single s1=Single.getSingle();
        Single s2=Single.getSingle();
        System.out.println(s1);
        System.out.println(s2);
    }

}
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 12:04 2020/3/24
 * @Param
 * @return
 * 单例模式，只允许创建一个实例 例如数据库连接池 线程池
 * 多线程会存在问题
 *
 **/

class Single{
    private static Single single=null;
    private Single(){

    }
    public static Single getSingle(){
        if (single==null){
            single=new Single();
        }
        return single;
    }

}
