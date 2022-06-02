package com.learn.leetcode.everyday.june;

public class June23_1009 {
    public static void main(String[] args) {
        June23_1009 June23_1009 = new June23_1009();
        System.out.println(June23_1009.bitwiseComplement(1));
    }
    public int bitwiseComplement(int n) {
        if (n==0) return 1;
        int maxVal = (int) Math.pow(2,Math.floor(Math.log(n)/Math.log(2))+1);
        return n ^ (maxVal-1);
    }
}
