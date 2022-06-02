package com.yanglk.algorithm.xiaozhao_2019.tengxun426;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int k=sc.nextInt();
        sc.nextLine();
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i1 = 0; i1 < k; i1++) {
            String[] ss=sc.nextLine().split(" ");
            if (ss[0].equals("add")){
                int t=Integer.parseInt(ss[1]);
                queue.add(t);
            }
            if (ss[0].equals("poll")){
                if (queue.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    queue.poll();
                }
                //queue.poll();
            }
            if (ss[0].equals("peek")){
                if (queue.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.peek());
                }
                //System.out.println(queue.peek());
            }

        }

    }
    static Stack<Integer> stack=new Stack<>();
    static Stack<Integer> help=new Stack<>();
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);

        int k=sc.nextInt();
        sc.nextLine();

        for (int i1 = 0; i1 < k; i1++) {
            String[] ss=sc.nextLine().split(" ");
            if (ss[0].equals("add")){
                int t=Integer.parseInt(ss[1]);
                push(t);
            }
            if (ss[0].equals("poll")){
                if (empty()){
                    System.out.println(-1);
                }
                else {
                    pop();
                }
                //queue.poll();
            }
            if (ss[0].equals("peek")){
                if (empty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(top());
                }
                //System.out.println(queue.peek());
            }

        }

    }
    public static void push(int x){
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
    public static int pop(){
        if (!stack.empty()){
            return stack.pop();
        }
        else{
            throw new RuntimeException();
        }
    }
    public static int top(){
        if (!stack.empty()){
            return stack.peek();
        }
        else{
            throw new RuntimeException();
        }
    }
    public static boolean empty(){
        return stack.empty();
    }
}
