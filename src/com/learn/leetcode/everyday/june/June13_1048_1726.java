package com.learn.leetcode.everyday.june;

import java.util.*;
import java.util.stream.Collectors;

public class June13_1048_1726 {
    public static void main(String[] args) {
        //new June13_1048_1726().tupleSameProduct1(new int[]{1,2,4,5,10});
        int n = 10;
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i*2; j++) {
                m++;
            }
        }
        System.out.println(m);

    }
    public List<String> stringMatching(String[] words) {
        Set<String> resultList = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String s1 = words[i];
            for (int j = 0; j < words.length; j++) {
                String s2 = words[j];
                if (i != j && s2.indexOf(s1) != -1){
                    resultList.add(s1);
                }
            }
        }
        return resultList.stream().collect(Collectors.toList());
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n&1  ;
            n >>>= 1 ;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0){
            count ++  ;
            n &= (n-1)  ;
        }
        return count;
    }
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            while (l<r){
                double mul = nums[l] * nums[r];
                int l1 = l+1;
                int r1 = r-1;
                r--;
                while (l1<r1){
                    double mul1 = nums[l1] * nums[r1];
                    if (mul1 > mul){
                        r1--;
                    }else if (mul1 < mul){
                        l1++;
                    }else {
                        count += 8;
                        r1--;
                        l1++;
                    }
                }
            }
            r = nums.length-1;
            l++;
        }
        return count;
    }

    public int tupleSameProduct1(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        Integer count = 0;
        Map<Double ,Integer> map = new HashMap<>();
        while (l < r){
            while (l<r){
                double mul = nums[l] * nums[r--];
                int c = map.getOrDefault(mul,0);
                map.put(mul,c+1);
            }
            r = nums.length-1;
            l++;
        }
        for (Double d : map.keySet()){
            int c = map.get(d);
            count = count + 4*(c)*(c-1);
        }
        return count;
    }
}
