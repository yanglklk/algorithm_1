package com.yanglk.algorithm.binary_search;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yanglk.algorithm.tree_.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public int mySqrt(int x){
        if(x<2)
            return x;
        int left=2;
        int right=x/2;
        int mid=0;
        long  num=0;
        while (left<=right){
            mid=(left+right)/2;
            num=(long )mid*mid;
            if (num==x){
               return mid;
            }
            if (num<x){
                left=mid+1;
            }
            else {
                right=mid-1;
            }

        }
        return right;

    }

    public int findMin(int[] nums){
        if(nums.length==1)
            return nums[0];
        int left=0;
        int right=nums.length-1;
        if (nums[left]<nums[right]){
            return nums[left];
        }
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if (nums[mid]>nums[mid+1])
                return nums[mid+1];
            if (nums[mid]<nums[mid-1])
                return nums[mid];
            if (nums[left]>nums[mid])
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }

    public int search(int[] nums,int target) {


        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            } else {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            }

        }
        return -1;
    }

    public int countNodes(TreeNode root){
        if (root==null)
            return 0;
        int deep=countdeepth(root);
        if (deep==0)
            return 1;
        int left=0;
        int right= (int) (Math.pow(2,deep)-1);
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if (exitence(mid,deep,root)){
                left=mid+1;
            }
            else
                right=mid-1;
        }
        return (int) (Math.pow(2,deep)-1+left);


    }
    public int countdeepth(TreeNode root){
        int deep=0;
        TreeNode p=root;
        while (p.left!=null){
            deep++;
            p=p.left;
        }
        return deep;
    }
    public boolean exitence(int indx,int d,TreeNode root){
        int left=0;
        int right= (int) Math.pow(2,d)-1;
        int mid=0;
        for (int i = 0; i < d; i++) {
           mid=(left+right)/2;
           if (indx<=mid){
               root=root.left;
               right=mid-1;
           }
           else {
               root=root.right;
               left=mid+1;
           }
        }
        return root!=null;
    }


    public int findDuplicate(int[] nums){
        int left=1;
        int right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            int c=0;
            for (int num : nums) {
                if (num<mid)
                    c++;
            }
            if (c>=mid){
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return left;
    }

    public int arrangeCoins(int n){
        int i=1;
        int sum=0;
        for (i=1;sum<=n;i++){
            sum+=i;
        }
        return i-1;

    }

    public static void main(String[] args) {

        int[] arr={0,1,2,2,2,3,6,8,8,9};
        new Main().findClosestElements(arr,5,9);
    }

    public List<Integer> findClosestElements(int[] arr,int k,int x){

        int left=0;
        int right=arr.length-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if (arr[mid]==x){
                break;
            }
            if (arr[mid]<x)
                left=mid+1;
            else
                right=mid-1;
        }
        int c=0;
        List<Integer> list=new ArrayList<>();
        if (left<=right){
            c=1;
            left=mid-1;
            right=mid+1;
            list.add(arr[mid]);
        }
        else {
            mid=left;
            left=right;
            right=mid;
        }
        while (c<k){
            if (left<0){
                list.add(arr[right++]);
                c++;
                continue;
            }
            if (right>=arr.length){
                list.add(arr[left--]);
                c++;
                continue;
            }
            if ((x-arr[left])<=(arr[right]-x)){
                list.add(arr[left--]);
            }
            else {
                list.add(arr[right++]);
            }
            c++;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return list;

    }


}
