package com.learn.leetcode.everyday.thread;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {




    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Test().missingNumber(new int[]{3,0,1});

    }

    public void testMQ(){
        Queue<Integer> buffer = new LinkedList<>();

        Runnable producer = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                addData();
            }

            public void addData()  {
                try {
                    while (true){
                        synchronized (buffer){
                            while (buffer.size()==10){
                                System.out.println("Queue is full, Consumer[" + Thread.currentThread().getName() + "] thread is waiting for Producer");
                                buffer.wait();
                            }
                            System.out.println("[" + Thread.currentThread().getName() + "] Producing value : " + count);
                            buffer.add(count++);
                            buffer.notifyAll();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                getData();
            }
            public void getData()  {
                try {
                    while (true){
                        synchronized (buffer){
                            while (buffer.isEmpty()){
                                System.out.println("Queue is empty, Consumer[" + Thread.currentThread().getName() + "] thread is waiting for Producer");
                                buffer.wait();
                            }
                            System.out.println("getData: "+buffer.poll());
                            buffer.notifyAll();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        };

        Thread t1 = new Thread(producer,"producer");
        Thread t2 = new Thread(consumer,"consumer");

        t1.start();
        t2.start();

    }

    public void testMQ1(){
        Queue<Integer> buffer = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition emptyCondition = lock.newCondition();
        Condition fullCondition = lock.newCondition();


        Runnable producer = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                addData();
            }

            public void addData()  {
                try {
                    while (true){
                        lock.lock();
                        {
                            while (buffer.size()==10){
                                System.out.println("Queue is full, Consumer[" + Thread.currentThread().getName() + "] thread is waiting for Producer");
                                fullCondition.await();
                            }
                            System.out.println("[" + Thread.currentThread().getName() + "] Producing value : " + count);
                            buffer.add(count++);
                            emptyCondition.signalAll();
                            fullCondition.signalAll();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                        lock.unlock();
                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                getData();
            }
            public void getData()  {
                try {
                    while (true){
                        lock.lock();
                        {
                            while (buffer.isEmpty()){
                                System.out.println("Queue is empty, Consumer[" + Thread.currentThread().getName() + "] thread is waiting for Producer");
                                emptyCondition.await();
                            }
                            System.out.println("getData: "+buffer.poll());
                            fullCondition.signalAll();
                            emptyCondition.signalAll();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                        lock.unlock();
                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        };

        Thread t1 = new Thread(producer,"producer");
        Thread t2 = new Thread(consumer,"consumer");

        t1.start();
        t2.start();

    }

    public void testMQ2(){
        LinkedBlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(10);



        Runnable producer = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                addData();
            }

            public void addData()  {
                try {
                    while (true){

                        {

                            System.out.println("[" + Thread.currentThread().getName() + "] Producing value : " + count);
                            buffer.add(count++);

                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                getData();
            }
            public void getData()  {
                try {
                    while (true){
                            System.out.println("getData: "+buffer.poll());

                            Thread.sleep(new Random().nextInt(1000));

                    }
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        };

        Thread t1 = new Thread(producer,"producer");
        Thread t2 = new Thread(consumer,"consumer");

        t1.start();
        t2.start();


    }

    private void extracted() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                print();
            }
            public void print(){
                System.out.println("hell0");
            }
        }).start();

        new Thread(()->print1()).start();

    }
    public void print1(){
        System.out.println("hell0");
    }

    public void testQueue(){
        SynchronousQueue<Integer> synchronousQueue =new SynchronousQueue<>();


        new Thread(()->{
            int i=0;
            while (true){
                synchronousQueue.add(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{

            while (true){
                System.out.println(synchronousQueue.poll());
            }
        }).start();
    }

    public void testThreadLocal(){
        ThreadLocal< List<Integer>> local = ThreadLocal.withInitial(()-> new ArrayList<>());

        Thread t1 = new Thread(() -> {
            List<Integer> list = local.get();
            int i = 10;
            while (i > 0) {
                list.add(i--);
            }
            local.set(list);
            local.get().forEach(System.out::println);
        });

        Thread t2 = new Thread(() -> {
            List<Integer> list = local.get();
            int i = 10;
            while (i < 20) {
                list.add(i++);
            }
            local.set(list);
            local.get().forEach(System.out::println);
        });

        t1.start();
        t2.start();


        // count.forEach(System.out::println);


    }

    public void testExecutor(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Acc acc = new Acc();
        Runnable runnable = new Runnable() {

            @Override

            public void run() {
                    for (int i = 0; i < (100); i++) {
                        synchronized (acc){
                            acc.a++;
                        }

                    }
            }
        };
        for (int i = 0; i < (100); i++) {
            executor.submit(runnable);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.println(acc.a);
    }

    public void testCallAble() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Acc acc = new Acc();
        Callable<Acc> callable = new Callable<Acc>() {
            @Override
            public Acc call() throws Exception {
                for (int i = 0; i < (100); i++) {
                    acc.a++;
                }
                System.out.println(Thread.currentThread().getName()+" ===== "+acc.getA());
                //  主线程使用submit.get() 这里没有返回主线程就无法提交新的任务。
                //Thread.sleep(5000);
                return acc;

            }
        };

        for (int i = 0; i < (100); i++) {
            FutureTask<Acc> futureTask = new FutureTask<>(callable);
            new Thread(futureTask).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(acc.a);

        acc.setA(0);

        for (int i = 0; i < (100); i++) {
            Future<Acc> submit = executor.submit(callable);

            // submit.get() 需要等线程执行完返回 主线程阻塞住了，没有再去创建新的线程
            // System.out.println(Thread.currentThread().getName()+" ===== "+submit.get().getA());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(acc.a);

    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] tep = new int[n+1];
        for (int i = 0; i < n; i++) {
            tep[nums[i]]=1;
        }
        for (int i = 0; i < tep.length; i++) {
            if (tep[i]==0){
                return i;
            }
        }
        return -1;

    }


}
class Acc{
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
