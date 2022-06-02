package com.learn.leetcode.everyday.dp;

public class CanJump {

    public static void main(String[] args) {
        System.out.println(new CanJump().jump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] opt = new boolean[n];
        opt[0]=nums[0]>=0;
        for (int i = 1; i < n; i++) {
            opt[i] = false;
            for (int j = i-1; j >=0 ; j--) {
                opt[i]=(j+nums[j]>=i && opt[j]) || opt[i];
                if (opt[i]){
                    break;
                }
            }
        }
        return opt[n-1];
    }


    public boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] opt = new boolean[n];
        opt[0]=nums[0]>=0;
        for (int i = 1; i < n; i++) {
            opt[i]=(nums[i-1]>=1 && opt[i-1]) || opt[i];
        }
        return opt[n-1];
    }
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int opt = 0;
        for (int i = 0; i < n; i++) {
           if (i<=opt){
               opt=Math.max(opt,i+nums[i]);
               if (opt>=n-1){
                   return true;
               }
           }
        }
        return false;
    }

    public int jump(int[] nums) {
       int position = nums.length-1;
       int count =0;
       while (position>0){
           for (int i = 0; i < position; i++) {
               if (i+nums[i]>=position){
                   position=i;
                   count++;
                   break;
               }
           }
       }
        return count;
    }


    public int jump1(int[] nums) {
        int end = 0;
        int count =0;
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,i+nums[i]);
            if (i==end){
                end=max;
                count++;
            }
        }
        return count;
    }
}
