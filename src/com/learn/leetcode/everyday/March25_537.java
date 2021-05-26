package com.learn.leetcode.everyday;

public class March25_537 {
    public static void main(String[] args) {
        new March25_537().complexNumberMultiply("1+-1i","1+-1i");
    }
    public String complexNumberMultiply(String num1, String num2) {
        int[] a1b1 = parseComplexNumber(num1);
        int[] a2b2 = parseComplexNumber(num2);
        int a1 = a1b1[0];
        int b1 = a1b1[1];
        int a2 = a2b2[0];
        int b2 = a2b2[1];
        int c1 = (a1*a2)-(b1*b2);
        int c2 = (a1*b2)+(a2*b1);
        StringBuilder returnStr=new StringBuilder(String.valueOf(c1));
        returnStr.append("+");
        returnStr.append(String.valueOf(c2));
        returnStr.append("i");
        return returnStr.toString();
    }
    public int[] parseComplexNumber(String num){
        String[] nums=num.split("\\+");
        Integer a = Integer.valueOf(nums[0]);
        Integer b = Integer.valueOf(nums[1].substring(0,nums[1].length()-1));
        return new int[]{a,b};
    }
}
