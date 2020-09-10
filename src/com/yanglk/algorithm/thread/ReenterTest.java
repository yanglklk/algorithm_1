package com.yanglk.algorithm.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterTest {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock(true);
        for (int i = 0; i < (10); i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName());
                    lock.unlock();
                }
            }).start();
        }
    }
}
