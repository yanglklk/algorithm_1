package com.yanglk.algorithm.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadPool01 {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Random random=new Random();
        ExecutorService executorService=new ThreadPoolExecutor(2,5,0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(),new ThreadPoolExecutor.DiscardPolicy());
        //ExecutorService executorService=Executors.newCachedThreadPool();
        //ExecutorService executorService=Executors.newFixedThreadPool(50);
        //ExecutorService executorService=Executors.newSingleThreadExecutor();

        //new SynchronousQueue<>()
//        for (int i = 0; i < (10000); i++) {
//            executorService.execute(new Task1(list,random.nextInt()));
//        }
//        executorService.shutdown();

        System.out.println(new Date().getTime());


    }
}
class Task1 implements Runnable{
    List list=null;
    int random=0;
    public Task1(List list,int random){
        this.list=list;
        this.random=random;
    }

    @Override
    public void run() {
       System.out.println(Thread.currentThread().getName()+"is runing insert"+ random);
        list.add(random);
    }
}
