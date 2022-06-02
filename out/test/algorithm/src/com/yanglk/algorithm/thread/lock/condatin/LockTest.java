package com.yanglk.algorithm.thread.lock.condatin;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        final  Buffer buffer=new Buffer();
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run");
                for (int i = 0; i < (20); i++) {
                    System.out.println(" putting");
                    buffer.put(Integer.valueOf(i));
                }
            }
        };

        Runnable r2=new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 run");
                for (int i = 0; i < (20); i++) {
                    System.out.println(" getting");
                    System.out.println(buffer.get());
                }
            }
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t1.start();
    }

    static class Buffer{
        ReentrantLock lock=new ReentrantLock();
        Condition put_con=lock.newCondition();
        Condition get_con=lock.newCondition();
        Object[] buffer=new Object[15];
        int putptr/*写索引*/, getptr/*读索引*/, count/*队列中存在的数据个数*/;

        public void put(Object a){
            try {
                System.out.println("try lock");
                lock.lock();
                System.out.println("lock success");
                while (count==buffer.length){
                    System.out.println(" buffer full");
                    put_con.await();
                }
                buffer[putptr]=a;
                putptr=++putptr==buffer.length? 0:putptr;
                count++;
                System.out.println(" put success");
                get_con.signal();

            }catch (Exception e){

            }
            finally {
                lock.unlock();
            }
        }

        public Object get(){
            Object o=null;
            try {
                System.out.println("try lock");
                lock.lock();
                System.out.println("lock success");
                while (count==0){
                    System.out.println(" buffer full");
                    get_con.await();
                }
                o=buffer[getptr];
                getptr=++getptr==buffer.length? 0:getptr;
                count--;
                System.out.println(" put success");
                put_con.signal();

            }catch (Exception e){

            }
            finally {
                lock.unlock();
                return o;
            }

        }
    }
}
