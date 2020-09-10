package com.yanglk.algorithm.other_;

public class ExtendTest {
    public static void main(String[] args) {
        Parent p=new Parent();
        Parent pp=new Parent();
    }

}
class Parent{
    static int a;
    static {
        System.out.println(a);
        System.out.println("晶态");
    }
    {
        System.out.println("非晶态");
    }
    public Parent(){
        System.out.println("ppp");
    }

}
