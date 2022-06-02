package com.yanglk.algorithm;

import java.util.Scanner;

public class jianxin58 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i]=sc.nextInt();
        }
        int min=Integer.MAX_VALUE;
        int sum=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j){
                    sum=a[i]+b[j];
                }
                min=Math.min(sum,min);
            }
        }
        System.out.println(sum);
    }
}
