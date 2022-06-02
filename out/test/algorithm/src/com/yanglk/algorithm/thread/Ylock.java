package com.yanglk.algorithm.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Ylock implements Lock {
    static int s=0;
    @Override
    public void lock() {
        synchronized (this){
            s=1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this){
            s=0;
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
