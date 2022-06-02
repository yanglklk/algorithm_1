package com.yanglk.algorithm.thread;

import com.yanglk.algorithm.offer.Str;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable01 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "yanglk";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<>(new Callable01());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
