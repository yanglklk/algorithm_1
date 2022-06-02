package com.yanglk.algorithm.xiaozhao_2019.pdd1;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] nums=new int[n];
        List<Long> l=new ArrayList<>();
        int c=0;
        for (int i = 0; i < n; i++) {
            int t=sc.nextInt();
            nums[i]=t;
            l.add((long) t);
            if (t%m==0)
                c++;
        }



        for (int i = 1; i < n; i++) {
            List<Long> l1=new ArrayList<>();
            for (int i1 = 0; i1 < l.size()-1; i1++) {
                long t=(long) (l.get(i1)+nums[i+i1]);
                if (t%m==0)
                    c++;
                l1.add(t);
            }
            l=l1;
        }
        System.out.println(c);
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int c=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n-i; j++) {
                int sum=0;
                for (int k = 0; k < i; k++) {
                    sum+=nums[j+k];
                }
                if (sum%m==0)
                    c++;
            }
        }
        System.out.println(c);
    }
}
