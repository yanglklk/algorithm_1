package com.yanglk.algorithm.xiaozhao_2019.ea429;

import com.yanglk.algorithm.offer.Str;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger[] opt=new BigInteger[n+1];
        opt[0]=BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            BigInteger t1=BigInteger.valueOf((4*i-2));
            BigInteger t2=BigInteger.valueOf((i+1));
            opt[i]=(opt[i-1].multiply(t1)).divide(t2);
        }
        System.out.println(opt[n]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(",");
        int s=Integer.parseInt(ss[0]);
        int e=Integer.parseInt(ss[1]);
        int sp=(int)Math.ceil(Math.log(s)/Math.log(2));
        int ep=(int)Math.floor(Math.log(e)/Math.log(2));
        BigInteger count=new BigInteger("0");
        for (int i = sp; i < ep; i++) {

            int z=((i+1)/2)-1;
            BigInteger b1=fun(i);
            BigInteger b2=fun(z);
            BigInteger b3=fun(i-z);
            BigInteger num=b1.divide(b2.multiply(b3));
            count=count.add(num);
        }
        int e1=(int) Math.pow(2,ep);
        int s1=(int) Math.pow(2,sp);
        if (ep%2==1){
            int c=0;
            for (int i = e1; i <= e; i++) {
                c=count1(i);
                if (c==((ep+1)/2)){
                    count=count.add(BigInteger.valueOf(1));
                }
            }
        }
        if (sp%2==1){
            int c=0;
            for (int i = s; i <sp; i++) {
                c=count1(i);
                if (c==((sp+1)/2)){
                    count=count.add(BigInteger.valueOf(1));
                }
            }
        }
        System.out.println(count);

    }
    static BigInteger fun(int n){
        BigInteger res=BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            res=res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
    static int count1(int n){
        int c=0;
        while (n!=0){
            n-=n&(~n+1);
            c++;
        }
        return c;
    }


}
