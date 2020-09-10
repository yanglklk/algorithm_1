package com.yanglk.algorithm.xiaozhao_2019.pdd;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < (n / 2); i++) {
            int s=nums[i]+nums[n-i-1];
            min=Math.min(min,s);
            max=Math.max(max,s);
        }
        System.out.println(max-min);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt();
        int p=sc.nextInt();
        int b=sc.nextInt();
        if (h<=0){
            System.out.println(0);
            return;
        }
        if (p>=h){
            System.out.println(1);
            return;
        }
        if (b>=h){
            System.out.println(2);
            return;
        }

        if (h>b&&b>p*2){
            int[] opt=new int[h+1];
            for (float i = (float) 1.0; i < b; i++) {
                opt[(int) i]= (int) Math.ceil(i/p);
            }
            for (int i = b; i <= h; i++) {
                opt[i]=Math.min(opt[i-p]+1,opt[i-b]+2);
            }
            System.out.println(opt[h]);
        }
        if (2*p>=b){
            System.out.println((int) Math.ceil((float)h/p));
        }



    }
}
