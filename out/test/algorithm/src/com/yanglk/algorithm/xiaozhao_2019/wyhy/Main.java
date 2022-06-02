package com.yanglk.algorithm.xiaozhao_2019.wyhy;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        for (int i = k; i > 0; i--) {
            Set<Integer> set=new HashSet<>();
            int n=sc.nextInt();
            for (int j = n; j > 0; j--) {
                int t=sc.nextInt();
                int c=0;
                while (t>0){
                    c++;
                    t-=(~t+1)&(t);
                }
                set.add(c);
            }
            System.out.println(set.size());
        }
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int q=sc.nextInt();
        for (int i = 0; i < q; i++) {
            int y=sc.nextInt();
            if (y<min){
                System.out.println(1);
                continue;
            }
            if (y>=max){
                System.out.println(0);
                continue;
            }
            int lastindex=-2;
            int c=0;
            boolean f=false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]>y){
                    f=true;
                    if (j!=(lastindex+1)){
                        c++;
                    }
                   lastindex=j;
                }
            }

            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();
            int t=sc.nextInt();
            int m1=sc.nextInt();
            int t1=sc.nextInt();
            int m2=sc.nextInt();
            int t2=sc.nextInt();
            boolean f1=true;
            boolean f2=true;
            int c=0;
            for (int ti = 0; ti<t; ti++) {
                if (ti>0&&ti%t1==0){
                    f1=!f1;
                }
                if (ti>0&&ti%t2==0){
                    f2=!f2;
                }
                if (f1==false&&f2==false)
                    continue;
                if (f1==true&&f2==true){
                    c+=(m1-m2);
                }
                if (f1==true&&f2==false){
                    c+=m1;
                }
                if (f1==false&&f2==true){
                    c-=m2;
                }
                c=Math.max(0,c);
                c=Math.min(m,c);
            }
            System.out.println(c);
        }
    }
}


