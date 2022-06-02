package com.yanglk.algorithm.leetcode;

public class MajorElement {
    public static void main(String[] args) {
        int[] nums={8,8,7,7,7};
        MajorElement me=new MajorElement();
        me.majorityElement(nums);
    }
    public int majorityElement(int[] nums){

        int m=nums[0];
        int c=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==m){
                c++;
                continue;
            }
            if (nums[i]!=m){
                if (c>0){
                    c--;
                }
                if (c==0){
                    m=nums[i];
                    c=1;
                }
            }
        }
        return m;
    }
}
