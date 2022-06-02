package com.yanglk.algorithm.xiaozhao_2019.zhaohang429;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
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
        }
        Arrays.sort(nums);
        boolean f=true;
        int c=0;
        while (true){
            for (Integer key : map.keySet()) {
                if (map.get(key) >= k) {
                    System.out.println(c);
                    return;
                }
            }
            int t=0;
            if (f){
                t=nums[n-1];
                map.put(t,map.get(t)-1);
                nums[n-1]--;
                t=nums[n-1];
            }else {
                t=nums[0];
                nums[0]++;
                map.put(t,map.get(t)-1);
                t=nums[0];
            }
            if (map.containsKey(t)){
                map.put(t,map.get(t)+1);
            }
            else {
                map.put(t,1);
            }
            f=!f;
            c++;
            Arrays.sort(nums);
        }

    }
}
