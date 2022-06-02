package com.yanglk.algorithm.thread;



import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //synchroniusQueueTest();
        //ArrayBlockingQueueTest();
        //LinkedBlockingDequeTest();
        //CallerRunsPolicyTest();
        //DiscardOldestPolicyTest();
        //DiscardPolicyTest();
        //RejectedExecutionHandlerTest();
        //ThreadFactoryTest();
        ThreadPoolExecutorTest();
    }

    private static void synchroniusQueueTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(1,2,1000,
                        TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < (3); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void ArrayBlockingQueueTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(2,4,1000,
                        TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < (8); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void LinkedBlockingDequeTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(3,4,1000,
                        TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < (8); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void CallerRunsPolicyTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(1,2,1000,
                        TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < (3); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void DiscardOldestPolicyTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(1,2,1000,
                        TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < (3); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void DiscardPolicyTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(1,2,1000,
                        TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < (3); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void RejectedExecutionHandlerTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(1, 2, 1000,
                        TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
                        Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("error");
                    }
                });
        for (int i = 0; i < (3); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void ThreadFactoryTest() {
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(1, 2, 1000,
                        TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
                        new ThreadFactory() {
                            @Override
                            public Thread newThread(Runnable r) {
                                System.out.println("创建"+r.hashCode());
                                return new Thread(r,r.hashCode()+"!");
                            }
                        }, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < (3); i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    private static void ThreadPoolExecutorTest() {
        ExecutorService executorService =
                new ThreadPoolExecutor(1,2,1000,
                        TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.CallerRunsPolicy()) {
                    @Override
                    protected void beforeExecute(Thread t, Runnable r) {
                        System.out.println("准备执行："+ ((ThreadTask)r));
                    }

                    @Override
                    protected void afterExecute(Runnable r, Throwable t) {
                        System.out.println("执行完成："+ ((ThreadTask)r));
                    }

                    @Override
                    protected void terminated() {
                        System.out.println("finish");
                    }
                };


        for (int i = 0; i < (3); i++) {
            executorService.execute(new ThreadTask());
        }
    }





}
class ThreadTask implements Runnable{

    public ThreadTask(){

    }
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
    }
}

