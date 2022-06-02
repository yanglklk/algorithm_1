package com.test.jvmTest.lockTest;

import com.test.jvmTest.A;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class LockTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        int threadNum = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executorService.execute(new AddMoneyThread(account,1));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
            System.out.println(account.getAmount());
        }
    }


}
