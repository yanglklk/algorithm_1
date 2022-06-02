package com.learn.leetcode.everyday.june;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    //实例化Lock对象
    Lock lock = new ReentrantLock();

    /**
     * @param args
     */
    public static void main(String[] args) {
        //实例化本类对象，目的是调用runThread方法
        LockTest tl = new LockTest();
        //匿名对象创建线程1，并重写run方法，启动线程
        new Thread(){
            public void run(){

                tl.runThread(Thread.currentThread());
            }
        }.start();
//        try {
//            //执行的代码
//            Thread.sleep(20000);
//        } catch (Exception e) {
//            //异常处理内容，比如中断异常
//        }
        //匿名对象创建线程2，并重写run方法，启动线程
        new Thread(){
            public void run(){

                tl.runThread(Thread.currentThread());
            }
        }.start();


    }
    //线程共同调用方法
    public void runThread(Thread t){
        //lock对象调用LockTest(long time , TimeUnit unit)方法尝试获取锁
        try {
            //注意，这个方法需要抛出中断异常
            // 由于是可重入锁 有的线程可以拿到两次锁 ，只释放一次，其他线程不能再拿到锁。
            // 但是线程1 执行时候，可能线程0 还在执行代码，这里就是睡眠，第一次拿不到锁，第二次拿到了，再释放两次锁也会有异常
            boolean f = lock.tryLock(0,TimeUnit.MILLISECONDS);
            if(lock.tryLock(10000L, TimeUnit.MILLISECONDS)){
                //获锁成功代码段
                System.out.println("线程"+t.getName()+"获取锁成功");
                try {
                    //执行的代码
                    Thread.sleep(5000);
                } catch (Exception e) {
                    //异常处理内容，比如中断异常
                } finally {
                    //获取锁成功之后，一定记住加finally并unlock()方法,释放锁
                    System.out.println("线程"+t.getName()+"释放锁");
                    lock.unlock();
                    // 但是线程1 执行时候，可能线程0 还在执行代码，这里就是睡眠，第一次拿不到锁，第二次拿到了，再释放两次锁也会有异常
                    lock.unlock();

                }
            }else{
                //获锁失败代码段
                //具体获取锁失败的回复响应

                System.out.println("线程"+t.getName()+"获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
