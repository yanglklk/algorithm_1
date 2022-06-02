package com.yanglk.algorithm.xiaozhao_2019.meituan.mt319;

import com.yanglk.algorithm.offer.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main__(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       // List<Integer> list=new ArrayList<>();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
         //   list.add(sc.nextInt());
            nums[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
//            int tt=list.get(i);
//            list.remove(i);
//            Integer[] t=new Integer[n-1];
//            t =list.toArray(t);
//            max=Math.max(max,largest(t,));
//            list.add(i,tt);
            max=Math.max(max,largest(nums,i));
        }
        System.out.println(max);

    }
    public static int largest(int[] nums,int k){
        int l=nums.length;
        int[] opt=new int[l];
        opt[0]=1;
        for (int i = 1; i < opt.length; i++) {
            if (i==k){
               continue;
            }
            if (i==k+1){
                if (i>2&&nums[i]>nums[i-2]){
                    opt[i]=opt[i-2]+1;
                }
                else {
                    opt[i]=1;
                }
            }
            else {
                if (nums[i]>nums[i-1]){
                    opt[i]=opt[i-1]+1;
                }
                else {
                    opt[i]=1;
                }
            }

        }
        Arrays.sort(opt);
        return opt[l-1];
    }

    public static int largest1(int[] nums,int k){
        int l=nums.length;
        int[] opt=new int[l];
        opt[0]=1;
        k=-1;
        for (int i = 1; i < opt.length; i++) {
            if (nums[i]>nums[i-1]){
                opt[i]=opt[i-1]+1;
            }
            else {
                if (k!=-1){
                    k=i-1;
                    opt[i]=opt[i-1]-k;
                }
                else {
                    opt[i]=opt[i-1];
                    k=i-1;
                }
            }

        }
        Arrays.sort(opt);
        return opt[l-1];
    }




}
