package com.yanglk.algorithm.offer;

public class Number {
    public static void main(String[] args) {

    }
    public int NumberOf1(int n) {
        char[] chars=Integer.toBinaryString(n).toCharArray();
        int num=0;
        for (char aChar : chars) {
            if (aChar=='1')
                num++;
        }
        return num;

    }

    public double Power(double base, int exponent) {
        if (base==0)
            return 0.0;
        if (exponent==0)
            return 1.0;
        return Math.pow(base,exponent);
    }
}
