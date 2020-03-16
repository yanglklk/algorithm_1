package com.yanglk.algorithm.static_;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;
    Queue<Integer> help;
    public MyStack(){
        queue=new LinkedList<>();
        help=new LinkedList<>();
    }
    public void push(int x){
        help.clear();
        help.add(x);
        while (!queue.isEmpty()){
            help.add(queue.poll());
        }
        queue.clear();
        while (!help.isEmpty()){
            queue.add(help.poll());
        }

    }
    public int pop(){
        if (!queue.isEmpty())
            return queue.poll();
        else {
            throw new RuntimeException();
        }
    }
    public int top(){
        if (!queue.isEmpty())
            return queue.peek();
        else {
            throw new RuntimeException();
        }

    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
