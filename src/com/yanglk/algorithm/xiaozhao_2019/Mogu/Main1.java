package com.yanglk.algorithm.xiaozhao_2019.Mogu;

import com.sun.scenario.effect.Merge;

import java.util.Scanner;

public class Main1 {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int n=Integer.parseInt(s[0])+1;
        int m=Integer.parseInt(s[1])+1;
        int[][] opt=new int[n][m];
        for (int i = 0; i < m; i++) {
            opt[0][i]=1;
        }
        for (int i = 0; i < n; i++) {
            opt[i][0]=1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                opt[i][j]=opt[i][j-1]+opt[i-1][j];
            }
        }
        System.out.println(opt[n-1][m-1]);

    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        int l=s.length();
        if (l<k||k<0){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i <= l - k; i++) {
            System.out.print(s.substring(i,i+k)+" ");
        }
            
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        String a=s[0];
        String b=s[1];
        int la=a.length();
        int lb=b.length();
        int f=0;
        StringBuffer res=new StringBuffer();
        if (la<=lb){
            StringBuffer sa=new StringBuffer(a);
            for (int i = 0; i < lb - la; i++) {
                sa.insert(0,'0');
            }

            for (int i = lb-1; i >=0 ; i--) {
                int ai=sa.charAt(i)-'0';
                int bi=b.charAt(i)-'0';
                int t=ai+bi+f;
                if (t<2){
                    res.insert(0,t);
                }
                else {
                    res.insert(0,0);
                    f=1;
                }
            }
        }
        if (la>lb){
            StringBuffer sb=new StringBuffer(b);
            for (int i = 0; i < la - lb; i++) {
                sb.insert(0,'0');
            }

            for (int i = la-1; i >=0 ; i--) {
                int ai=a.charAt(i)-'0';
                int bi=sb.charAt(i)-'0';
                int t=ai+bi+f;
                if (t<2){
                    res.insert(0,t);
                }
                else {
                    res.insert(0,0);
                    f=1;
                }
            }
        }
        if (f==1){
           res.insert(0,1);
        }
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int k=Integer.parseInt(ss[0]);
        int n=Integer.parseInt(ss[1]);
        int[][] nums=new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] temp=new int[n];
            String[] s=sc.nextLine().split(" ");
            for (int i1 = 0; i1 < n; i1++) {
                temp[i1]=Integer.parseInt(s[i1]);
            }
            nums[i]=temp;
        }
        int i=0;
        int j=0;
        int[] temp=nums[0];
        for (int i1 = 1; i1 < n; i1++) {
            temp= merge(temp,nums[i1]);
        }
        System.out.println(temp[k-1]);

    }
    public static int[] merge(int[] a,int[] b){
        int la=a.length;
        int lb=b.length;
        int i=0;
        int j=0;
        int k=0;
        int[] res=new int[la+lb];
        while (i<la&&j<lb){
            if (a[i]<b[j]){
                res[k++]=a[i++];
            }
            else res[k++]=b[j++];
        }
        if (i<la){
            while (i<la){
                res[k++]=a[i++];
            }
        }
        if (j<lb){
            while (j<lb){
                res[k++]=b[j++];
            }
        }
        return res;
    }


}
