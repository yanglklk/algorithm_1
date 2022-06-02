package com.learn.leetcode.everyday.june;

import java.util.*;

public class June8_398 {

    Map<Integer, List<Integer>> indexMap = new HashMap<>();
    Random random = new Random();
    int[] nums;
    public void Solution(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            List<Integer> list =indexMap.getOrDefault(key,new ArrayList<>());
            list.add(i);
            indexMap.put(key,list);
        }
    }

    public int pick(int target) {
        List<Integer> list = indexMap.get(target);
        int size = list.size();
        return list.get(random.nextInt(size));
    }
    public int pick1(int target) {
        int count = 0;
        int ret = 0;
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                if (random.nextInt(++count) == 0){
                    ret = i;
                }
            }
        }
        return  ret;
    }



}
