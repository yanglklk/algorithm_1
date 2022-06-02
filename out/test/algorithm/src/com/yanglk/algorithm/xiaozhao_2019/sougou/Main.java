package com.yanglk.algorithm.xiaozhao_2019.sougou;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int max=Integer.MIN_VALUE;
        int[] nums=new int[n];
        int index=-1;
        for (int i = 0; i < n; i++) {
            int t=sc.nextInt();
            nums[i]=t;
            if (t>max){
                max=t;
                index=i;
            }
        }
        int[] num=new int[n-1];
        for (int i = 0; i < (n - 1); i++) {
            num[i]=nums[(i+index+1)%n];
        }
        int maxa=max;
        int maxb=0;
        int i=0;
        int j=num.length-1;
        boolean flag=false;
        while (i<=j){
            if (num[i]<num[j]){
                if (flag){
                    maxa+=num[j--];
                }
                else {
                    maxb+=num[j--];
                }
            }
            else {
                if (flag){
                    maxa+=num[i++];
                }
                else {
                    maxb+=num[i++];
                }
            }
            flag=!flag;
        }
        System.out.println(Math.abs(maxa-maxb));

    }


}
