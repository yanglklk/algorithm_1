package com.learn.leetcode.everyday.dp;

public class MaxProduct {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0]=nums[0];
        min[0]=nums[0];
        int maxVal = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i]<0){
                min[i]=Math.min(Math.max(max[i-1],min[i-1])*nums[i],nums[i]);
                max[i]=Math.max(Math.min(max[i-1],min[i-1])*nums[i],nums[i]);
            }
            else {
                min[i]=Math.min(Math.min(max[i-1],min[i-1])*nums[i],nums[i]);
                max[i]=Math.max(Math.max(max[i-1],min[i-1])*nums[i],nums[i]);
            }
            maxVal = Math.max(maxVal,Math.max(min[i],max[i]));
        }
        return maxVal;
    }

    public int maxProduct1(int[] nums) {
        int n = nums.length;
        int max=nums[0];
        int min=nums[0];
        int maxVal = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = min;
            if (nums[i]<0){
                min=Math.min(Math.max(max,min)*nums[i],nums[i]);
                max=Math.max(Math.min(max,temp)*nums[i],nums[i]);
            }
            else {
                min=Math.min(Math.min(max,min)*nums[i],nums[i]);
                max=Math.max(Math.max(max,temp)*nums[i],nums[i]);
            }
            maxVal = Math.max(maxVal,Math.max(min,max));
        }
        return maxVal;
    }

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int max=nums[0]>0?1:0;
        int min=nums[0]<0?1:0;
        int maxVal = max;
        for (int i = 1; i < n; i++) {
            int temp = max;
            if (nums[i]>0){
                max=max+1;
                min=min==0?0:min+1;
            }
            if (nums[i]<0){
                max=min==0?0:min+1;
                min= temp +1;
            }
            if (nums[i]==0){
                min=0;
                max=0;
            }
            maxVal = Math.max(maxVal,max);
        }
        return maxVal;
    }
}
