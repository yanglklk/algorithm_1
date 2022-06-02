package com.yanglk.algorithm.xiaozhao_2019.meituan.mt319;

import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.yanglk.algorithm.offer.Array;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list2.add(sc.nextInt());
        }
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Collections.sort(list2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        if (n<3){
            int sum1=0;
            int sum2=0;
            for (int i = 0; i < n; i++) {
                sum1+=list1.get(i);
                sum2+=list2.get(i);
            }
            System.out.println(Math.max(sum2,sum1));
            return;
        }
        List<Integer> ll1=new ArrayList<>();
        List<Integer> ll2=new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i+1; j < list1.size(); j++) {
                for (int k = j+1; k < list1.size(); k++) {
                    int max1=list1.get(i)+list1.get(j)+list1.get(k);
                    int max2=list2.get(i)+list2.get(j)+list2.get(k);
                   ll1.add(max1);
                   ll2.add(max2);
                }
            }

        }
        Collections.sort(ll1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Collections.sort(ll2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < ll1.size(); i++) {
            if (ll1.get(i)>ll2.get(i)){
                System.out.println(ll1.get(i));
                return;
            }
            if (ll1.get(i)<ll2.get(i)){
                System.out.println(ll2.get(i));
                return;
            }
        }

        int max1=list1.get(0)+list1.get(1)+list1.get(2);
        System.out.println(max1);


    }
}
