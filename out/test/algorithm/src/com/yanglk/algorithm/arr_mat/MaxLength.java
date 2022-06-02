package com.yanglk.algorithm.arr_mat;

import java.util.HashMap;
import java.util.Map;

public class MaxLength {
    public MaxLength() {
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,3};
        System.out.println(new MaxLength().getMaxLength_2(nums,6));
    }

    public int getMaxLength_1(int[] nums,int k){
        //all nums is positive number
        if (nums==null||nums.length==0||k<=0)
            return 0;
        int left=0;
        int right=0;
        int sum=nums[0];
        int len=0;
        while (right<nums.length){
            if (sum==k){
                len=Math.max(len,right-left+1);
                sum=sum-nums[left];
                left++;
                continue;
            }
            if (sum<k){
                right++;
                if (right<nums.length)
                    sum+=nums[right];
                continue;
            }
            if (sum>k){
                sum=sum-nums[left];
                left++;
                continue;
            }
        }
        return len;
    }

    public int getMaxLength_2(int[] nums,int k){
        if (nums==null||nums.length==0||k<=0)
            return 0;
        int sum=0;
        int len=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
//        for (int i=0;i<nums.length;i++){
//            sum+=nums[i];
//            if (!map.containsKey(sum))
//                map.put(sum,i);
//        }
//        sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (!map.containsKey(sum))
                map.put(sum,i);
            if (map.containsKey(sum-k)){
                int j=map.get(sum-k);
                len=Math.max(len,i-j);
            }
        }
        return len;
    }

    public int getMaxLength_2_0(int[] nums){
        if (nums==null||nums.length==0)
            return 0;
        int sum=0;
        int len=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for (int i=0;i<nums.length;i++){

            if (nums[i]>0)
                nums[i]=1;
            if (nums[i]<0)
                nums[i]=-1;
            sum+=nums[i];
            if (!map.containsKey(sum))
                map.put(sum,i);
        }
        sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum)){
                int j=map.get(sum);
                len=Math.max(len,i-j);
            }
        }
        return len;
    }
}
