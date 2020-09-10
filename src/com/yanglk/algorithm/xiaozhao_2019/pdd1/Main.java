package com.yanglk.algorithm.xiaozhao_2019.pdd1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        long sum=0;
        int j = n-1;
        for (; j > 2; j--) {
            sum+=nums[j--];
            sum+=nums[j--];
        }
        while (j>=0){
            sum+=nums[j--];
        }
        System.out.println(sum);
    }
}
