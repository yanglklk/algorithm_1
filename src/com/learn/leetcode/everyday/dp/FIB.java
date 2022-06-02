package com.learn.leetcode.everyday.dp;

public class FIB {
    public static void main(String[] args) {

    }
    public int fib(int n) {
        int[] opt =new int[n+1];
        opt[0]=0;
        opt[1]=1;
        for (int i = 2; i <= n; i++) {
            opt[i]=opt[i-1]+opt[i-2];
        }
        return opt[n];
    }

    public int fib1(int n) {
        if(n<2){
            return n;
        }
        int opt1 = 1;
        int opt2 = 0;
        int opt = 0;
        for (int i = 2; i <= n; i++) {
            opt = opt1+ opt2;
            opt2 = opt1;
            opt1 =opt;
        }
        return opt;
    }

    public int fib2(int n) {
        if(n<2){
            return n;
        }
       return fib(n-1)+fib(n-2);
    }

    public int tribonacci(int n) {
        if(n<2){
            return n;
        }
        if (n==2){
            return 1;
        }
        int opt1 = 1;
        int opt2 = 1;
        int opt3 = 0;
        int opt = 0;
        for (int i = 3; i <= n; i++) {
            opt = opt1+ opt2+opt3;
            opt3 = opt2;
            opt2 = opt1;
            opt1 =opt;
        }
        return opt;
    }
}
