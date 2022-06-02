package com.yanglk.algorithm.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        MyThread t1=new MyThread(lock);
        MyThread t2=new MyThread(lock);
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
class MyThread extends Thread {
    ReentrantLock lock;
    Semaphore s =new Semaphore(3);




    //@Override
//    public void run() {
//        super.run();
//        for (int i = 0; i < 500000; i++) {
//            if (this.interrupted()) {
//                System.out.println("should be stopped and exit");
//                break;
//            }
//            System.out.println("i=" + (i + 1));
//        }
//        System.out.println("this line is also executed. thread does not stopped");//尽管线程被中断,但并没有结束运行。这行代码还是会被执行
//    }
    MyThread(ReentrantLock lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        Semaphore s =new Semaphore(3);
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            lock.lock();
            //Thread.sleep(500);
            for (int i = 0; i < (500000); i++) {
                System.out.println(i);
            }
            System.out.println(this.getName()+this.isInterrupted());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}