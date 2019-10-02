package com.yanglk.algorithm.static_;

public class Main_test {
    public static void main(String[] args) {

        Two_StacksQueue tsq=new Two_StacksQueue();
        tsq.add(1);
        tsq.add(2);
        tsq.poll();
        tsq.add(3);
        tsq.add(4);
        tsq.peek();
        tsq.poll();
        tsq.poll();
        tsq.poll();
        tsq.peek();

    }
}
