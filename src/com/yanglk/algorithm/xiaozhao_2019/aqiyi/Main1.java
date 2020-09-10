package com.yanglk.algorithm.xiaozhao_2019.aqiyi;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main1 {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        int k=sc.nextInt();
        int max=0;

        for (int xi = 0; xi < x; xi++) {
            for (int yi = 0; yi < y; yi++) {
                for (int zi = 0; zi < z; zi++) {
                    if ((xi+yi+zi)==k){
                        max=Math.max((xi+1)*(yi+1)*(zi+1),max);
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<Long> list=new ArrayList<>();
        for (int i = 0; i < (n * n); i++) {
            list.add(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            long b=sc.nextLong();
            list.set(a-1,b);
            List<Long> l1=new ArrayList<>();
            l1.addAll(list);
//            l1.set(a-1,b);
            boolean f=true;
            for (int i1 = 0; i1 < n; i1++) {
                List<Long> l=new ArrayList<>();
                for (int j = 0; j < l1.size(); j+=2) {
                    if (f){
                        l.add(l1.get(j)|l1.get(j+1));
                    }
                    else {
                        l.add(l1.get(j)^l1.get(j+1));
                    }
                }
                l1.clear();
                l1.addAll(l);
                f=!f;
            }
            System.out.println(l1.get(0));
        }
    }

    public static void main(String[] args) {
        int a= (int) Math.pow(2,30);
        System.out.println(a);
    }
}
