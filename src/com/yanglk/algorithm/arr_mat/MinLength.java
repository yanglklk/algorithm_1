package com.yanglk.algorithm.arr_mat;

import com.sun.corba.se.impl.protocol.MinimalServantCacheLocalCRDImpl;

import java.util.Map;

public class MinLength {

    public MinLength() {
    }

    public static void main(String[] args) {
        int[] nums={1,5,3,4,7,8,9,15,12,10};
        System.out.println(new MinLength().getMinLength(nums));
    }
    public int getMinLength(int[] nums){
        int minId=-1;
        int maxId=0;
        int min=nums[nums.length-1];
        int max=nums[0];
        for (int i = nums.length-2;i>=0;i--){
            if (nums[i]>min) {
                minId = i;
            }
            min= Math.min(min,nums[i]);
        }
        if (minId==-1)
            return 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]<max){
                maxId=i;
            }
            max=Math.max(max,nums[i]);
        }
        return maxId-minId+1;
    }
}
