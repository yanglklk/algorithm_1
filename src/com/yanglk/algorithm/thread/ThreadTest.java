package com.yanglk.algorithm.thread;

import java.util.concurrent.Callable;

public class ThreadTest {
    public static void main(String[] args) {
        //二者并无区别，需要对共享变量c同步
        //都是创建一个线程对象，然后new Thread（），相当于多个线程做一个任务
        T1 t=new T1();
        for (int i = 0; i < (100); i++) {
           new Thread(t,"thread -"+i).start();
        }

        R1 r=new R1();
        for (int i = 0; i < (100); i++) {
            new Thread(r,"runanble -"+i).start();
        }

    }
}
class R1 implements Runnable{
    private int c=100;
    @Override
    public synchronized void run() {
        c--;
        System.out.println(Thread.currentThread().getName()+" :"+c);
    }
}
class  T1 extends Thread{
    int c=100;
    @Override
    public void run() {
        c--;
        System.out.println(Thread.currentThread().getName()+" :"+c);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
