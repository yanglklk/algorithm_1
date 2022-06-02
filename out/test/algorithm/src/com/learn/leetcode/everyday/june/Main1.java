package com.learn.leetcode.everyday.june;

import com.utils.IntToBitArray;

public class Main1 {
    public static void main(String[] args) {
        int code1 = (int) (Math.pow(2,16)+ Math.pow(2,18)+ Math.pow(2,20)) +19;
        int code2 = (int) (Math.pow(2,17)+ Math.pow(2,18)+ Math.pow(2,20)) +35;
        int code11 = code1^(code1>>16);
        int code22 = code2^(code2>>16);
        int code111 = code1&7;
        int code222 = code2&7;
        int code1111 = code11&7;
        int code2222 = code22&7;
        System.out.println("code1 :" +IntToBitArray.toBitArray(code1));
        System.out.println("code11 :" +IntToBitArray.toBitArray(code11));
        System.out.println("code2 :" +IntToBitArray.toBitArray(code2));
        System.out.println("code22 :" +IntToBitArray.toBitArray(code22));
        System.out.println("假设表长length是8 ");
        System.out.println("code1 &  7（111） :"+ code111 +"  code2 &  7（111） :"+ code222);
        System.out.println("code11 &  7（111） :"+ code1111 +"  code22 &  7（111） :"+ code2222);


    }
}
