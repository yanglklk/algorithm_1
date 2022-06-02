package com.yanglk.algorithm.xiaozhao_2019.qiniu;

import com.sun.deploy.security.SandboxSecurity;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for (int i = 0; i < m; i++) {
            int s=sc.nextInt();
            int e=sc.nextInt();
            if (map.containsKey(s)){
                Set<Integer> l=map.get(s);
                l.add(e);
                map.put(s,l);
            }
            else {
                Set<Integer> l=new HashSet<>();
                l.add(e);
                map.put(s,l);
            }
            if (map.containsKey(e)){
                Set<Integer> l=map.get(e);
                l.add(s);
                map.put(e,l);
            }
            else {
                Set<Integer> l=new HashSet<>();
                l.add(s);
                map.put(e,l);
            }
        }
        if (m<n-1){
            System.out.println("NO");
            return;
        }
        //int[][] tab=new int[n][n];
        boolean f=bfs(map,n);
        if (f){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }
    static boolean bfs(Map<Integer,Set<Integer>> map,int n){
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)&&map.get(i).size()==n){
                continue;
            }
            queue.add(i);
            set.add(i);
            while (!queue.isEmpty()){
                int item=queue.poll();
                if (map.containsKey(item)){
                    Set<Integer> s=map.get(item);
                    for (Integer si : s) {
                        if (!set.contains(si)){
                            set.add(si);
                            queue.add(si);
                        }
                    }
                }
//                Set<Integer> s=map.get(item);
//                for (Integer si : s) {
//                    if (!set.contains(si)){
//                        set.add(si);
//                        queue.add(si);
//                    }
//                }
            }
            if (set.size()!=n){
                return false;
            }
            queue.clear();
            set.clear();

        }
        return true;
    }
}

