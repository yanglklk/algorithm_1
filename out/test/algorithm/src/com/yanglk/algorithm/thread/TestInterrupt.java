package com.yanglk.algorithm.thread;

import java.util.concurrent.TimeUnit;

public class TestInterrupt implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        Thread test=new Thread(new TestInterrupt());
        test.start();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("调用interrupt()");
        test.interrupt();
        System.out.println("中断状态："+test.isInterrupted());
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        long time = System.currentTimeMillis();
        System.out.println("线程正在运行");
        while ((System.currentTimeMillis() - time < 1000)) {}
        System.out.println("清除线程的中断状态:" + Thread.interrupted());
        System.out.println("线程是否中断:" +Thread.currentThread().isInterrupted());
        while ((System.currentTimeMillis() - time < 5000)) {}
        System.out.println("线程运行完成");
    }

}
