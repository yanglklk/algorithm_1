package com.learn.leetcode.everyday.binarySearch;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class SearchInsert {

    public static void main(String[] args) {
        //System.out.println(new SearchInsert().searchInsert(new int[]{1, 3}, 3));
        //System.out.println(new SearchInsert().mySqrt(8));
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int mid = (l+r)>>1;
        if (target<=nums[0]){
            return 0;
        }
        if (target>nums[r]){
            return n;
        }
        while (l<r){
           if (nums[mid]<target &&((mid+1<n && nums[mid+1]>target)||mid+1==n)){
               return mid+1;
           }
           if (nums[mid]==target){
               while (mid>=0 && nums[mid]==target){
                   mid--;
               }
               return mid+1;
           }
           if (nums[mid]<target){
               l=mid+1;
           }else{
               r=mid;
           }
            mid = (l+r)>>1;
        }
        return mid;
    }


    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int c = 0;
        while (l<=r) {
            int mid = (l + r) >> 1;
            long pow = (long) mid * mid;
            if (pow <= x) {
                c=mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return c;
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = 0;
        int p2 = slow;
        while (p1!=p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public int findDuplicate1(int[] nums) {
        int l = 1;
        int n = nums.length;
        int r = n-1;
        while (l<r){
            int mid = (l+r)>>1;
            int c = 0;
            for (int num : nums) {
                if (num<=mid){
                    c++;
                }
            }
            if (c>mid){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;

    }
}
