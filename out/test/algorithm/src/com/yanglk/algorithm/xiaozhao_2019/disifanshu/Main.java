package com.yanglk.algorithm.xiaozhao_2019.disifanshu;

import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] nums=new int[n][m];
        int k=1;
        for (int j = 0; j < m; j++) {
            int jj=j;
            int ii=0;
            while (ii<n&&jj>=0){
               nums[ii++][jj--]=k++;
            }
        }

        for (int i = 1; i < m; i++) {
            int jj=m-1;
            int ii=i;
            while (ii<n&&jj>=0){
                nums[ii++][jj--]=k++;
            }
        }
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(nums[i][j]+" ");
            }
        }
        System.out.print(sb.substring(0,sb.length()-1));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key=sc.nextInt();
            int val=sc.nextInt();
            if (map.keySet().contains(key)){
                map.get(key).add(val);
            }
            else {
                List<Integer> l=new ArrayList<>();
                l.add(val);
                map.put(key,l);
            }
            if (map.keySet().contains(val)){
                map.get(val).add(key);
            }
            else {
                List<Integer> l=new ArrayList<>();
                l.add(key);
                map.put(val,l);
            }
        }
        Set<Integer> s=new HashSet<>();
        Map<Integer,Integer> cmap=new HashMap<>();

        for (Integer key : map.keySet()) {
            List<Integer> node=map.get(key);
            if (!s.contains(key)) {
                int res=1;
                for (Integer integer : node) {
                    res&=cmap.get(integer);
                }
            }



            }
        }

}
