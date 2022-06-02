package com.yanglk.algorithm.xiaozhao_2019.pdd1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        int k=Integer.parseInt(ss[1]);
        char[] chars=sc.nextLine().toCharArray();
        int[] nums=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t=chars[i]-'0';
            nums[i]=t;
            if (map.containsKey(t)){
                map.put(t,map.get(t)+1);
            }
            else map.put(t,1);
        }
        for (int i = 0; i < (10); i++) {
            if (!map.containsKey(i)){
                map.put(i,0);
            }
        }
        int idx=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < (10); i++) {
            int sum=dis(map,k,i);
            if (sum<min){
                min=sum;
                idx=i;
            }
        }
        int[] ints=fix(map,nums,k,idx);
        System.out.println(min);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(ints[i]);
        }

    }
    public static int dis(Map<Integer,Integer> map,int k,int t){
        int ret=0;
        if (map.get(t)>=k)
            return ret;
        k-=map.get(t);
        for (int i = 1; i < (10); i++) {
            if (t+i<10){
                if (map.get(t+i)>=k){
                    ret+=i*k;
                    return ret;
                }
                else{
                    k-=map.get(t+i);
                    ret+=i*map.get(t+i);
                }
            }
            if (t-i>=0){
                if (map.get(t-i)>=k){
                    ret+=i*k;
                    return ret;
                }
                else{
                    k-=map.get(t-i);
                    ret+=i*map.get(t-i);
                }
            }

        }
        return  ret;
    }
    public static int[] fix(Map<Integer,Integer> map,int[] nums,int k,int idx){

        if (map.get(idx)>=k)
            return nums;
        k-=map.get(idx);
        for (int i = 1; i < (10); i++) {
            if (idx+i<10){
                for (int j = 0; j < nums.length; j++) {
                    if (k==0)
                        return nums;
                    if (nums[j]==idx+i){
                        nums[j]=idx;
                        k--;
                    }
                }
            }
            if (idx-i>=0){
                for (int j = nums.length-1; j >=0; j--) {
                    if (k==0)
                        return nums;
                    if (nums[j]==idx-i){
                        nums[j]=idx;
                        k--;
                    }

                }
            }
        }
        return nums;
    }



}
