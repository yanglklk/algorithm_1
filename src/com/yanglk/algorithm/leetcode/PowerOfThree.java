package com.yanglk.algorithm.leetcode;

public class PowerOfThree {


    public boolean powerOfThree(int n){
        return (Math.log10(n)/Math.log10(3)%1==0);
    }
    public boolean powerOfThree1(int n){
        return (n>0 && 1162261467%n==0);
    }

}
