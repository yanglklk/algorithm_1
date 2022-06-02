package com.yanglk.algorithm.static_;

import java.util.Stack;

public class Reverse_stack {

    public Reverse_stack() {

    }


    public int get_Stack_base(Stack<Integer> stack){
        int result= stack.pop();
        if (stack.empty()){
            return result;
        }
        int last=get_Stack_base(stack);
        stack.push(result);
        return last;
    }

    public void reverse_Stack(Stack<Integer> stack){
       if (stack.empty()){
           return;
       }
       int last=get_Stack_base(stack);
       reverse_Stack(stack);
       stack.push(last);

    }
}
