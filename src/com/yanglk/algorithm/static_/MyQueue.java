package com.yanglk.algorithm.static_;

import jdk.nashorn.internal.ir.IfNode;

import javax.print.attribute.standard.PrinterURI;
import java.security.PublicKey;
import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> help;
    public MyQueue(){
        stack=new Stack<>();
        help=new Stack<>();
    }
    public void push(int x){
        help.clear();
        while (!stack.empty()){
            help.push(stack.pop());
        }
        stack.clear();
        stack.push(x);
        while (!help.empty()){
            stack.push(help.pop());
        }
    }
    public int pop(){
        if (!stack.empty()){
            return stack.pop();
        }
        else{
            throw new RuntimeException();
        }
    }
    public int top(){
        if (!stack.empty()){
            return stack.peek();
        }
        else{
            throw new RuntimeException();
        }
    }
    public boolean empty(){
        return stack.empty();
    }
}
