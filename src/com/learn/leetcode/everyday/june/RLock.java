package com.learn.leetcode.everyday.june;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface RLock extends Lock {
    void lockInterruptibly(long var1, TimeUnit var3) throws InterruptedException;

    boolean tryLock(long var1, long var3, TimeUnit var5) throws InterruptedException;

    void lock(long var1, TimeUnit var3);

    boolean forceUnlock();

    boolean isLocked();

    boolean isHeldByCurrentThread();

    int getHoldCount();
}
