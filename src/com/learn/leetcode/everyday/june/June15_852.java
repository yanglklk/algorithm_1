package com.learn.leetcode.everyday.june;

import javax.security.auth.Subject;

public class June15_852 {
    public static void main(String[] args) {
        new June15_852().countAndSay(4);
    }
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
                return i-1;
            }
        }
        return 1;
    }
    public String countAndSay(int n) {
        StringBuilder returnString = new StringBuilder("1");
        if (n == 1){
            return returnString.toString();
        }
        int i = 1;
        while (i++ < n){
            returnString = countAndSayHelp(returnString);
        }
        return returnString.toString();
    }
    public StringBuilder countAndSayHelp(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            int c=1;
            while (i+1 < sb.length() && sb.charAt(i+1) == sb.charAt(i)){
                c++;
                i++;
            }
            result.append(c);
            result.append(sb.charAt(i));
        }
        return result;
    }
}
