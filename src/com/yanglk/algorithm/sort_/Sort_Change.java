package com.yanglk.algorithm.sort_;

import java.util.Arrays;

public class Sort_Change {
    public Sort_Change() {
    }

    public static void main(String[] args) {
        int[] nums={1,2,5,3,4};
        System.out.println(Arrays.toString(new Sort_Change().sort_1(nums)));
    }
    public int[] sort_1(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==i+1)
                continue;
            else {
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
}
