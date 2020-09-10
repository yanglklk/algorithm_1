package com.yanglk.algorithm.xiaozhao_2019.ali320;

public class Main3 {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    synchronized (b){

                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    synchronized (a){

                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
class A{}
class B{}