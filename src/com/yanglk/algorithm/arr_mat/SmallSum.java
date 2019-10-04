package com.yanglk.algorithm.arr_mat;

public class SmallSum {
    public SmallSum() {
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,2,4,6};
        System.out.println(new SmallSum().getMsallSum(nums));
    }
    public int getMsallSum(int[] nums){
        if (nums==null||nums.length==0)
            return 0;
        int sum=0;
        for (int j=nums.length-1;j>0;j--){
            for (int i=0;i<j;i++){
                if (nums[i]<=nums[j])
                    sum+=nums[i];
            }
        }
        return sum;
    }
}
