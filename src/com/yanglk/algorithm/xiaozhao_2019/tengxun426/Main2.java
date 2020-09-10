package com.yanglk.algorithm.xiaozhao_2019.tengxun426;

import java.util.Scanner;

public class Main2 {
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

        System.out.println(-1);
    }
    public static int changeIndex(int[] a,int[] b){
        for (int i = 0; i < a.length-1; i++) {
            if (a[i]>a[i+1]&&b[i]>b[i+1]){
               return i;
            }
        }
        return -1;
    }
}
