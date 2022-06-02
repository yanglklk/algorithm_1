package com.yanglk.algorithm.desingn_patterm.observer;

public class TestObserver {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer Aobserver = new AObserver(subject);
        Observer Bobserver = new BObserver(subject);

        System.out.println("subject.setStatus: "+ 10);
        subject.setStatus(10);
        System.out.println("subject.setStatus: "+ 15);
        subject.setStatus(15);
    }
}
