package com.learn.leetcode.everyday;

public class March26_1043 {
    public static void main(String[] args) {
        new March26_1043().maxSumAfterPartitioning(new  int[]{1,15,7,9,2,5,10},3);

    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        for (int i = 1; i < k; i++) {
            dp[i] = dp[i-1]+arr[i];
            dp[i] = Math.max(dp[i],(i+1)*maxNum(0,i+1,arr));
        }
        for (int i = k; i < len; i++) {
            dp[i] = dp[i-1]+arr[i];
            for (int j = 1; j <= k; j++) {
                dp[i] = Math.max(dp[i],dp[i-j]+(j)*maxNum(i-j+1,i+1,arr));
            }
        }
        return dp[len-1];
    }
    public int maxNum(int start, int end, int[] arr){
        int max=arr[start];
        for (int i = start; i < end; i++) {
            max=Math .max(max,arr[i]);
        }
        return max;
    }
}
