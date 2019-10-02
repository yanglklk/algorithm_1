package com.yanglk.algorithm.static_;

import java.util.Stack;

public class Main_test {
    public static void main(String[] args) {

        Stack<Integer> tsq=new Stack<>();
        Reverse_stack s=new Reverse_stack();
        tsq.push(1);
        tsq.push(2);
        tsq.push(3);
        tsq.push(4);

        s.reverse_Stack(tsq);


    }
}
