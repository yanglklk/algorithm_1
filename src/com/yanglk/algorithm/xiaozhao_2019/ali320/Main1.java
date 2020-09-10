package com.yanglk.algorithm.xiaozhao_2019.ali320;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] nums=new int[10];
        int sum=0;
        for (int i = 0; i < (10); i++) {
            nums[i]=sc.nextInt();
            sum+=nums[i];
        }
        System.out.println(sum);

    }
}
