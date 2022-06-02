package com.learn.leetcode.everyday.dp;

import com.yanglk.algorithm.tree_.Tree;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit3(new int[]{1,3,7,5,10,3},3));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int opt=0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min= Math.min(min,prices[i]);
            opt= Math.max(prices[i]-min,opt);
        }
        return opt;
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int sum=0;
        for (int i = 1; i < n; i++) {
           if (prices[i]<prices[i-1]){
               continue;
           }else {
               sum+=(prices[i]-prices[i-1]);
           }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n==1){
            return 0;
        }
        // opt[i][0] 第i天不持有，opt[i][1] 第i天持有
        int[][] opt= new int[n][2];
        opt[0][0]=0;
        opt[0][1]=-prices[0];
        opt[1][0]=Math.max(0,prices[1]-prices[0]);
        // opt[i-2][0] 可以初始化0
        opt[1][1]=Math.max(-prices[0],0-prices[1]);
        for (int i = 2; i < n; i++) {
            opt[i][0] = Math.max(opt[i-1][0],opt[i-1][1]+prices[i]);
            opt[i][1] = Math.max(opt[i-1][1],opt[i-2][0]-prices[i]);
        }
        return opt[n-1][0];
    }

    public int maxProfit4(int[] prices) {
        int n = prices.length;
        if (n==1){
            return 0;
        }
        int[] opt= new int[2];
        opt[0]=0;
        opt[1]=-prices[0];
        int pre = 0;
        for (int i = 1; i < n; i++) {
            int temp = opt[0];
            opt[0] = Math.max(opt[0],opt[1]+prices[i]);
            opt[1] = Math.max(opt[1],pre-prices[i]);
            pre = temp;
        }
        return opt[0];
    }

    public int maxProfit5(int[] prices) {
        int n = prices.length;
        int[][][] opt = new int[n][3][2];
        opt[0][2][0]= 0;
        opt[0][2][1]= -prices[0];
        opt[0][1][0]= 0;
        opt[0][1][1]= -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 2; j >=1; j--) {
                opt[i][j][0]= Math.max(opt[i-1][j][0],opt[i-1][j][1]+prices[i]);
                opt[i][j][1]= Math.max(opt[i-1][j][1],opt[i-1][j-1][0]-prices[i]);
            }
        }
        return opt[n-1][2][0];
    }



    public int maxProfit6(int[] prices) {
        int n = prices.length;
        int[][] opt = new int[3][2];
        opt[2][0]= 0;
        opt[2][1]= -prices[0];
        opt[1][0]= 0;
        opt[1][1]= -prices[0];
        for (int i = 1; i < n; i++) {
            opt[2][0]= Math.max(opt[2][0],opt[2][1]+prices[i]);
            opt[2][1]= Math.max(opt[2][1],opt[1][0]-prices[i]);
            opt[1][0]= Math.max(opt[1][0],opt[1][1]+prices[i]);
            opt[1][1]= Math.max(opt[1][1],-prices[i]);
        }
        return opt[2][0];
    }

    public int maxProfit7(int[] prices,int k) {
        int n = prices.length;
        if (n<=1){
            return 0;
        }
        int[][][] opt = new int[n][k+1][2];
        for (int i = k; i >=0 ; i--) {
            opt[0][i][0]=0;
            opt[0][i][1]=-prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >=1; j--) {
                opt[i][j][0]= Math.max(opt[i-1][j][0],opt[i-1][j][1]+prices[i]);
                opt[i][j][1]= Math.max(opt[i-1][j][1],opt[i-1][j-1][0]-prices[i]);
            }
        }
        return opt[n-1][k][0];
    }

    public int maxProfit3(int[] prices, int fee) {
        int n = prices.length;
        int sum = 0;
        int min = fee+prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i]+ fee < min) {
                min = prices[i]+fee;
            } else if (prices[i]>min){
                sum+= (prices[i]-min);
                min=prices[i];
            }
        }
        return sum;
    }

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = values[0]+values[1]-1;
        int maxi = values[0];
        // value[j]-j 对于位置j来说 是不变的
        // 只需value[i]+i 最大值
        for (int j = 1; j < n; j++) {
            max = Math.max(values[j]-j+maxi,max);
            maxi = Math.max(values[j] + j, maxi);
        }
        return max;
    }
}
