package com.yanglk.algorithm.xiaozhao_2019.youzan;


import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(";");
        String A=ss[0];
        String B=ss[1];
        if (A.length()!=B.length()){
            System.out.println(false);
            return;
        }

        for (int i = 1; i < A.length(); i++) {
            String sa1=A.substring(0,i);
            String sa2=A.substring(i);
            if (B.equals(sa2+sa1)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.substring(1,s.length()-1);
        String[] ss=s.split(",");
        int[] nums=new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        int index=0;
//        Set<Integer> set =new HashSet<>();
//        set.add(index);
//        while (index>=0&&index<=nums.length-1){
//            index+=nums[index];
//            if (set.contains(index)){
//                System.out.println(false);
//                return;
//            }
//        }
        int c=0;
        while (c<nums.length){
            c++;
            index+=nums[index];
            if (index<0||index>=nums.length){
                System.out.println(true);
                return;
            }

        }
        System.out.println(false);

    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.substring(1,s.length()-1);
        String[] ss=s.split(",");
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            int t=Integer.parseInt(ss[i]);
            if (map.keySet().contains(t)){
                int k=map.get(t);
                map.put(t,k+1);

            }else {
                map.put(t,1);
            }
        }
        int n=(int) Math.ceil(ss.length/2.0);
        for (Integer integer : map.keySet()) {
            if (map.get(integer)>=n){
                System.out.println(integer);
                return;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.substring(1,s.length()-1);
        String[] ss=s.split(",");
        PriorityQueue<Integer> pq=new PriorityQueue<>(3);

        for (int i = 0; i < ss.length; i++) {
            int t=Integer.parseInt(ss[i]);
            if (pq.size()<3){
                pq.add(t);
            }
            else {
                if (t>pq.peek()){
                    pq.poll();
                    pq.add(t);
                }
            }
        }
        System.out.println(pq.peek());


    }
}
