package com.yanglk.algorithm.thread;

public class Print {
    static String lock="lock";
    static Integer i=0;

    public static void main(String[] args) {
        new Thread(new myThread1()).start();
        new Thread(new myThread2()).start();
    }
    static class myThread1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread() + ": ->" + i++);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }


        }
    }


     static  class myThread2 implements Runnable{
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        if (i%2==1){
                            System.out.println(Thread.currentThread()+": ->"+i++);
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }

    }
}
