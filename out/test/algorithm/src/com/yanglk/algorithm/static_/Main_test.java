package com.yanglk.algorithm.static_;



import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Stack;

public class Main_test {
    public static void main(String[] args) {

//        Stack<Integer> tsq=new Stack<>();
//        Reverse_stack s=new Reverse_stack();
//        tsq.push(1);
//        tsq.push(2);
//        tsq.push(3);
//        tsq.push(4);
//
//        s.reverse_Stack(tsq);
        MyQueue myStack=new MyQueue();
        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        System.out.println(myStack.empty());

//        System.out.println(myStack.top());
//        System.out.println(myStack.pop());
//        myStack.push(5);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());

//        int[] nums=new int[]{2,3,8,1,0,7,3};
//        System.out.println(Arrays.toString(new Solution().nextGreaterElement1(nums)));
//        String s="3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
//        System.out.println(new Solution().decodeString(s));
        String[] ops={"5","2","C","D","+"};
        System.out.println(new Solution().calPoints(ops));


    }
}
