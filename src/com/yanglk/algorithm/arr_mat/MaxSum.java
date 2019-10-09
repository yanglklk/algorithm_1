package com.yanglk.algorithm.arr_mat;

import java.util.Arrays;

public class MaxSum {
    public MaxSum() {
    }

    public static void main(String[] args) {
        int[] nums={9,8,3,2,4,6};
        double[] nums1={-2.5,4,0,-3,0.5,-8,1};
        //System.out.println(Arrays.toString(new MaxSum().modefy(nums)));
        System.out.println(new MaxSum().maxProcuct(nums1));
    }
    public int getMaxSum(int[] nums){
        int sum=0;
        int max=nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (sum<0)
                sum=0;
            else
                max=Math.max(max,sum);

        }
        return  max;
    }

    public int[] modefy(int[] nums){
        int even=0;
        int odd=1;
        int end=nums.length-1;
        while(even<=end&&odd<=end){
            int temp=nums[end];
            if (temp%2==0){
                nums[end]=nums[even];
                nums[even]=temp;
                even+=2;
            }
            else {
                nums[end]=nums[odd];
                nums[odd]=temp;
                odd+=2;
            }
        }
        return nums;
    }

    public int localMin(int[] nums){
        if (nums.length==1)
            return 0;
        if (nums[0]<nums[1])
            return 0;
        if (nums[nums.length-1]<nums[nums.length-2])
            return nums.length-1;
        int l=1,r=nums.length-2;
        int mid=(l+r)/2;
        while (l<r){
            if (nums[mid-1]<nums[mid]){
                r=mid-1;

            }
            else if (nums[mid+1]<nums[mid]){
                l=mid+1;

            }
            mid=(l+r)/2;
            return mid;
        }
        return  l;
    }

    public double maxProcuct(double[] nums){
        double pmax= nums[0];
        double nmax= nums[0];
        double max= nums[0];
        double pend=0;
        double nend=0;
        for (int i = 1; i < nums.length; i++) {
            pend=pmax*nums[i];
            nend=nmax*nums[i];
            pmax=Math.max(Math.max(pend,nend),nums[i]);
            nmax=Math.min(Math.min(pend,nend),nums[i]);
            max=Math.max(max,pmax);

        }

        return max;
    }

}
