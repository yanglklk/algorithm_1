package com.learn.leetcode.everyday.june;

public class June16_877 {
    public static void main(String[] args) {

    }
    protected boolean stoneGame(int[] piles) {
        int n = piles.length;
       // dp[i][j] 是i到j之间 当前玩家与另一个玩家的最大差值
        // 当前能搞的最大差值就是 我选i dp[i+1][j] 对方 i+1 到 j 与我的差值 ，表示他-我 ，结合起来就是 我选i + 我- 他
        // 或者 我选j 对方i到j-1
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] =Math.max(piles[i]- dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] > 0;
    }
    //其实先手是必胜的，因为两人其实是分别取奇数位 和偶数位
    // 1 2 3 4 5 6 7 8
    // 先手可以选择是 1 3 5 7  还是2 4 6 8  哪个大选哪个
    // 选了1 对方只能是 2 8 开头 ，选了8 对方只能 1 7 开头
    // 只要先计算那个和更大选择就可以

}
