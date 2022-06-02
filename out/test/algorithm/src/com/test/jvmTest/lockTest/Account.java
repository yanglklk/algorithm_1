package com.test.jvmTest.lockTest;

import com.test.jvmTest.A;
import sun.security.provider.certpath.PKIXTimestampParameters;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private Lock lock = new ReentrantLock();

    private Integer amount ;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Account(Integer amount) {
        this.amount = amount;
    }

    public  void  addMoney0(int add){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amount+=add;
    }

    public synchronized void  addMoney(int add){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amount+=add;
    }

    public void  addMoney1(int add){
        synchronized (this){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount+=add;
        }

    }

    public void  addMoney2(int add){
        lock.lock();
        try {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount+=add;
        }finally {
            lock.unlock();
        }

    }

}
