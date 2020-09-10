package com.yanglk.algorithm.xiaozhao_2019.aqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        int nt=t.length();
        int ns=s.length();
        int i=0;
        while (i<nt-1){
            System.out.print(0+" ");
            i++;
        }
        i++;
        int last=0;
        for (; i <= ns; i++) {
            if (s.substring(i-nt,i).equals(t)){
                last++;
            }
            System.out.print(last+" ");
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n-1];
        for (int i = 0; i < n-1; i++) {
            nums[i]=sc.nextInt();
        }
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int[] vis=new int[n];
        bp(nums,n,lists,list,vis);
        System.out.println(lists.size());

    }
    public static void bp(int[] nums, int n, List<List<Integer>> lists,List<Integer> list,int[] vis){
        if (list.size()==n){
            List<Integer> l=new ArrayList<>();
            l.addAll(list);
            lists.add(l);
            return;
        }
        for (int i = 0; i < n; i++) {
//            if (vis[i]==0){
//                int t=list.size()-1;
//                if (t==-1||(nums[t]==0&&list.get(t)<(i+1)||nums[t]==1&&list.get(t)>(i+1))){
//                    list.add(i + 1);
//                    vis[i] = 1;
//                    bp(nums, n, lists, list, vis);
//                    list.remove(list.size() - 1);
//                    vis[i] = 0;
//                }
//            }
            if (list.size()>=1){
                if (vis[i]==0){
                    int t=list.size()-1;
                    if (nums[t]==0&&list.get(t)<(i+1)||nums[t]==1&&list.get(t)>(i+1)) {
                        list.add(i + 1);
                        vis[i] = 1;
                        bp(nums, n, lists, list, vis);
                        list.remove(list.size() - 1);
                        vis[i] = 0;
                    }
                }
            }
            else {
                if (vis[i]==0){
                    list.add(i+1);
                    vis[i]=1;
                    bp(nums,n,lists,list,vis);
                    list.remove(list.size()-1);
                    vis[i]=0;
                }
            }


        }

    }

}
