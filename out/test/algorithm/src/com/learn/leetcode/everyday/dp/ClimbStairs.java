package com.learn.leetcode.everyday.dp;

public class ClimbStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int opt1 = 2;
        int opt2 = 1;
        int opt = 0;
        for (int i = 3; i <= n; i++) {
            opt = opt1+ opt2;
            opt2 = opt1;
            opt1 =opt;
        }
        return opt;

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n<2){
            return Math.min(cost[n-1],cost[n-2]);
        }
        int opt1=0;
        int opt2=0;
        int opt =0;
        for (int i = 2; i < n; i++) {
            opt=Math.min(opt1+cost[i-1],opt2+cost[i-2]);
            opt2=opt1;
            opt1=opt;
        }
        return opt;
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        if (n<2){
            return Math.min(cost[n-1],cost[n-2]);
        }
        int[] opt =new int[n+1];
        opt[0] =0;
        opt[1] =0;
        for (int i = 2; i <= n; i++) {
            opt[i]=Math.min(opt[i-1]+cost[n-1],opt[n-2]+cost[n-2]);
        }
        return opt[n];
    }
}
