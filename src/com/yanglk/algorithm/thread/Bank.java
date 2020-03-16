package com.yanglk.algorithm.thread;

public class Bank {



    public static void main(String[] args) throws InterruptedException {
        Count count=new Count(100);
        Thread p1=new Thread(new PutM(count));
        Thread p2=new Thread(new PutM(count));
        Thread g1=new Thread(new GetM(count));
        Thread g2=new Thread(new GetM(count));
        p1.start();
        p2.start();
        g1.start();
    //    g2.start();
        Thread.sleep(5000);
        System.out.println(count.money);
    }
}
class Count{
    int money;
    public Count(int money){
        this.money=money;
    }
}
class PutM implements Runnable{

    Count count;
    public PutM(Count c){
        this.count=c;
    }
    @Override
    public void run() {
       // synchronized (count){
            for (int i = 0; i < (10); i++) {
                count.money++;
            }

        //}
    }
}

class GetM implements Runnable{

    Count count;
    public GetM(Count c){
        this.count=c;
    }
    @Override
    public void run() {
        synchronized (count){
            for (int i = 0; i < (15); i++) {
                count.money--;
            }
        }
    }
}

