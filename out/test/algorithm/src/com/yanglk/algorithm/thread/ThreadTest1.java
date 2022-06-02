package com.yanglk.algorithm.thread;

public class ThreadTest1 {


    public static void main(String[] args) {
        //创建一个对象 分别 new Thread（） 启动多个线程做一件事 做100次自减
        //共享K 需要同步
//        T2 t=new T2();
//        for (int i = 0; i < (3); i++) {
//            new Thread(t).start();
//        }

        // 三个线程分别做从100 自减操作，不会共享 相当于做300次
        T2 t2_1=new T2();
        T2 t2_2=new T2();
        T2 t2_3=new T2();
        new Thread(t2_1).start();
        new Thread(t2_2).start();
        new Thread(t2_3).start();
    }
}
class T2 implements  Runnable{
    int k=100;
    @Override
    public void run() {
        while (k>0){
            System.out.println(Thread.currentThread().getName()+" "+k--);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
