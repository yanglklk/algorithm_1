package com.yanglk.algorithm.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SynTest {
    static  int m=0;
    public static void main(String[] args) throws InterruptedException {
       Thread[] threads=new Thread[100];
       Object o=new Object();
       ReentrantLock lock=new ReentrantLock();
        //Ylock lock=new Ylock();
        for (int i = 0; i < (100); i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public  void run() {
                    synchronized (this) {
                        for (int i1 = 0; i1 < (100); i1++) {
                            try {
                                Thread.sleep(0);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            m++;
                        }
                    }
                }
            });
            threads[i].start();


        }

//        for (int i = 0; i < (100); i++) {
//            threads[i]=new Thread(new Runnable() {
//                @Override
//                public  void run() {
//                    try {
//                        lock.lock();
// //synchronized (this){
// //           s=1;
// //       }
// 在加锁时只是锁lock对象 lock虽然线程共享
// 但是只是在syn块中设置1 设置完就释放了锁 另一个线程又在加上锁
//  之后就去执行 循环加到100 中间还是会有竞争
// 锁的范围不会涉及到循环加
//                        for (int i1 = 0; i1 < (100); i1++) {
//                            try {
//                                Thread.sleep(1);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            m++;
//                        }
//                    }finally {
//                        lock.unlock();
//                    }
//
//                    }
//
//            });
//
//        }
//        for (Thread thread : threads) {
//            thread.start();
//        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(m);
    }

}
