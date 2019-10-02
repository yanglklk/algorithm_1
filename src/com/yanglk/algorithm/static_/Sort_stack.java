package com.yanglk.algorithm.static_;

import java.util.Stack;

public class Sort_stack {
    public Sort_stack() {
    }

    Stack<Integer> stack= new Stack<>();
    Stack<Integer> help= new Stack<>();
    public void sortStack(){
        while (!stack.empty()){
            int cur=stack.pop();
            while (!help.empty()&&help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.empty()){
            stack.push(help.pop());
        }
    }
}
