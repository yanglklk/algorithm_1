package com.yanglk.algorithm.arr_mat;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class LIL {
    public LIL() {
    }

    public static void main(String[] args) {
        int[] nums={5,5,3,2,6,4,2};
        System.out.println(new LIL().getLIL2(nums));
    }
    public int getLIL2(int[] nums){
        int maxL=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int max=nums[i];
            int min=nums[i];
            int j=i;
            for (;j<nums.length;j++){
                if (set.contains(nums[j]))
                    break;
                set.add(nums[j]);
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
            }
            if (max-min==j-i)
                maxL=Math.max(maxL,(j-i+1));
            set.clear();
        }
        return maxL;
    }

}
