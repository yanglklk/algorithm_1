package com.yanglk.algorithm.xiaozhao_2019.meituan;

import com.yanglk.algorithm.offer.Str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main_(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if (ishui(s.substring(j,j+i+1)))
                    count++;
            }
        }
        System.out.println(count);

    }
    public static boolean ishui(String t){
        int l=t.length();
        for (int i = 0; i < l/2; i++) {
            if (t.charAt(i)!=t.charAt(l-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] num=new int[n];
        int[] sum=new int[n+1];
        int s=0;
        for (int i = 0; i < n; i++) {
            num[i]=sc.nextInt();
            s+=num[i];
            sum[i+1]=s;
        }
        int[][] opt=new int[n][n];
        for (int i = 0; i < n; i++) {
            opt[i][i]=num[i];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j <n; j++) {
                opt[i][j]=Integer.MAX_VALUE;
                for (int k = i; k <j; k++) {
                    opt[i][j]=Math.min(opt[i][k]+opt[k+1][j]+sum[j+1]-sum[i],opt[i][j]);
                }
            }
        }
        System.out.println(opt[0][n-1]-s);

    }

}
