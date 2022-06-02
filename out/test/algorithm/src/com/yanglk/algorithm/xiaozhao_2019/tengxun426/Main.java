package com.yanglk.algorithm.xiaozhao_2019.tengxun426;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k=sc.nextInt();
            sc.nextLine();
            Queue<Integer> queue=new LinkedList<>();
            for (int i1 = 0; i1 < k; i1++) {
                String[] ss=sc.nextLine().split(" ");
                if (ss[0].equals("PUSH")){
                    int t=Integer.parseInt(ss[1]);
                    queue.add(t);
                }
                if (ss[0].equals("POP")){
                    if (queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else {
                        queue.poll();
                    }
                }
                if (ss[0].equals("TOP")){
                    if (queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(queue.peek());
                    }
                }
                if (ss[0].equals("SIZE")){
                    System.out.println(queue.size());
                }
                if (ss[0].equals("CLEAR")){
                    queue.clear();
                }
            }
        }
    }
}
