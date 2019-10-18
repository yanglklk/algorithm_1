package com.yanglk.algorithm.leetcode;

public class MaxSlidingWindow {
    public static void main(String[] args) {

    }
    public int  maxSlidingWindow(int[] nums,int k){
        int[] res=new int[nums.length-k+1];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max=Math.max(nums[i],max);
        }

        int l=0;
        int r=k;
        for ( ; r < nums.length; r++,l++) {

        }
        return max;
    }
}
