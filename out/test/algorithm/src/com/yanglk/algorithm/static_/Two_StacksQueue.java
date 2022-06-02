package com.yanglk.algorithm.static_;


import java.util.Stack;

public class Two_StacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Two_StacksQueue(){
        this.stackPush=new Stack<>();
        this.stackPop= new Stack<>();
    }

    public void pushTopop(){
        if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
    public void add(int pushInt){
        stackPush.push(pushInt);
        pushTopop();
    }
    public int peek(){
        if (stackPop.empty()&&stackPush.empty()){
            throw new  RuntimeException("Queue is empty");
        }
        pushTopop();
        return stackPop.peek();
    }

    public int poll(){
        if (stackPop.empty()&&stackPush.empty()){
            throw new  RuntimeException("Queue is empty");
        }
        pushTopop();
        return stackPop.pop();
    }
}
