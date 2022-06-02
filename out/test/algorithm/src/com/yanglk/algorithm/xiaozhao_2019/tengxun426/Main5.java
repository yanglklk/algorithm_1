package com.yanglk.algorithm.xiaozhao_2019.tengxun426;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            long x=sc.nextLong();
            int k=sc.nextInt();
            System.out.println(findfather(x,k));
        }
    }
    public static long findfather(long x,int k){
        int d=(int)(Math.log(x)/Math.log(2));
        if (k>=d+1){
            return -1;
        }
        long f=x;
        while (f>=Math.pow(2,k)){
            if (f%2==0)
                f=f/2;
            else f=(f-1)/2;
        }
        return f;
    }
}
