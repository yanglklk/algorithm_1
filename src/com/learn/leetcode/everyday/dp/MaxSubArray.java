package com.learn.leetcode.everyday.dp;

public class MaxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int opt0=nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            opt0=Math.max(opt0+nums[i],nums[i]);
            max= Math.max(max,opt0);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max= nums[0],min=nums[0],optMin =0,optMax =0,sum=0;
        for (int num : nums) {
            optMax=Math.max(optMax+num,num);
            max= Math.max(max,optMax);
            optMin= Math.min(optMin+num,num);
            min= Math.min(min,optMin);
            sum+=num;
        }
        return Math.max(sum-min==0? max:sum-min,max);
    }
}
