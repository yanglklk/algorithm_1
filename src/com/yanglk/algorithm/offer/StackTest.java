package com.yanglk.algorithm.offer;

import java.util.Stack;

public class StackTest {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack();
        int i=0;
        int j=0;
        while (i<pushA.length){
            if (pushA[i]!=popA[j]){
                stack.push(pushA[i]);
            }
            else {
                while (!stack.empty()&&j<popA.length&&stack.peek()==popA[++j]){
                    stack.pop();
                }
            }
            i++;
        }
        return stack.empty();
    }
}
