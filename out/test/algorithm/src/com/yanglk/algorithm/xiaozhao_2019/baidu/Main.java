package com.yanglk.algorithm.xiaozhao_2019.baidu;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.lang.management.GarbageCollectorMXBean;
import java.util.*;

public class Main {
    public static void main1(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            long t=sc.nextLong();
            char[] chars=String.valueOf(t).toCharArray();
            int l=chars.length;
            int c=0;
            for (int i1 = 0; i1 < l; i1++) {
                if (chars[i1]=='0'||t%(chars[i1]-'0')==0){
                    c++;
                }
            }
            if (c==0){
                System.out.println("S");
            }
            else if (c==l){
                System.out.println("G");
            }
            else System.out.println("H");
        }
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            int c=0;
            for (int l = 0; l <= i; l++) {
                for (int r = i+1; r < n; r++) {
                    if (nums[l]!=nums[r]){
                        c++;
                    }
                }
            }
            System.out.printf("%d ",c);
        }

    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        Map<Integer,Integer>[] maps=new HashMap[n];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t=sc.nextInt();
            nums[i]=t;
            if (map.containsKey(t)){
                map.put(t,map.get(t)+1);
            }
            else {
                map.put(t,1);
            }
            Map<Integer,Integer> mapt=new HashMap<>();
            mapt.putAll(map);
            maps[i]=mapt;
        }

        Map<Integer,Integer>[] mape=new HashMap[n];
        map.clear();
        for (int i = n-1; i >=0; i--) {
            int t=nums[i];
            if (map.containsKey(t)){
                map.put(t,map.get(t)+1);
            }
            else {
                map.put(t,1);
            }
            Map<Integer,Integer> mapt=new HashMap<>();
            mapt.putAll(map);
            mape[i]=mapt;
        }
        for (int i = 0; i < maps.length-1; i++) {
            Map<Integer,Integer> smap=maps[i];
            Map<Integer,Integer> emap=mape[i+1];
            int c=0;
            for (Integer key : smap.keySet()) {
                if (emap.containsKey(key)){
                    c+=(smap.get(key)*(n-i-1-emap.get(key)));
                }
                else {
                    c+=(smap.get(key)*(n-i-1));
                }
            }
            System.out.printf("%d ",c);
        }
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        int last=Integer.MAX_VALUE;
        long sum=0;
        for (int i = 0; i < n; i++) {
            int t=sc.nextInt();
            nums[i]=t;
            if (t-last>0){
                sum+=(t-last);
            }
            last=t;
        }
        if (n==1){
            System.out.println(0+" "+0);
            return;
        }
        int i=0;
        int j=1;
        int c=0;
        for (; j < n; ) {
            for (i = j; i < n; i++) {
                if (nums[i]<nums[i-1]){
                    break;
                }
            }
            if (i!=j){
                c+=2;
            }
            j=i+1;
        }
        System.out.println(sum+" "+ c);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] chars=sc.nextLine().toCharArray();
        int mod=1000000007;
        long cy=0;
        long c=0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i]=='y'){
                cy=(cy+1)%mod;
            }else {
                c=(cy+cy)%mod;
                cy=(cy*2)%mod;
            }
        }
        System.out.println(c);
    }
}
