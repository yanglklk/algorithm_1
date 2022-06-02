package com.yanglk.algorithm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {


    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();

        int[] count={0};
        Runnable r=new Runnable() {
            @Override
            public  void run() {
                    lock.lock();
                    try {
                        Thread.sleep(100);
                        int a = count[0];
                        a++;
                        count[0] = a;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

            }
        };
        ///*
        for (int i = 0; i < (10); i++) {
            new Thread(new Runnable() {

                Lock lock1=new ReentrantLock();
                @Override
                public synchronized void run() {
                    lock1.lock();
                    //synchronized (count){
                        try {
                            Thread.sleep(100);
                            int a=count[0];
                            a++;
                            count[0]=a;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock1.unlock();
                        }
                }


                //}
            }).start();
        }
        //*/
//        for (int i = 0; i < (10); i++) {
//            new Thread(r).start();
//        }
        Thread.sleep(7000);
        System.out.println(count[0]);

    }


}
