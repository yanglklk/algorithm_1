package com.learn.leetcode.everyday;

public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int count =0;
        for (int i = 0; i < n-k; i++) {
            int ki= Integer.valueOf(numStr.substring(i,i+k));
            if ( ki!=0 && num%ki==0 ){
                count++;
            }
        }
        return count;
    }
}
