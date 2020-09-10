package com.yanglk.algorithm.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest02 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock(true);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t1");
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        t1.start();
        Thread.sleep(10);
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t2");
                lock.unlock();
            }
        });
        t2.start();
        Thread.sleep(10);
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t3");
                lock.unlock();
            }
        });
        t3.start();
    }
}
