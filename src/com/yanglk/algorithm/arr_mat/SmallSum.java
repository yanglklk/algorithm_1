package com.yanglk.algorithm.arr_mat;

public class SmallSum {
    public SmallSum() {
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,2,4,6};
        System.out.println(new SmallSum().getSmallSum_1(nums));
    }
    public int getSmallSum(int[] nums){
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

    public int getSmallSum_1(int[] nums){
        return getSmall_(nums,0,nums.length-1,0);
    }
    public int getSmall_(int[] nums,int l,int r,int sum){
        //归并思路递归解决
        if (l<r){
            int mid=(l+r)/2;
            int s=0;
            sum=getSmall_(nums,l,mid,sum);
            sum=getSmall_(nums,mid+1,r,sum);
            sum=merge(nums,l,r,sum);
        }
        return sum;
    }
    public int merge(int[] nums,int l,int r,int s){
        int sum=0;
        int mid=(l+r)/2;
        int i=l,j=mid+1;
        while (i<=mid&&j<=r){
            if (nums[i]<=nums[j]){
                sum+=nums[i];
                i++;
            }
            else {
                j++;
                i=0;
            }

        }
//        if (i<=mid){
//            while (i<=r){
//                sum+=nums[i];
//                i++;
//            }
//        }
//        if (j<=r){
//            int
//        }
        return sum+s;
    }

}
