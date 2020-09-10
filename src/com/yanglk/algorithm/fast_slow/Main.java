package com.yanglk.algorithm.fast_slow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,2,2,3};
        String s="race a car";
//        new Main().isPalindrome(s);
        int[] d={2,4,6,8,10};
int[] p={10,20,30,40,50};
int[] w={4,5,6,7};
        new Main().maxProfitAssignment(d,p,w);
    }
    public int removeDuplicates(int[] nums){
        int fast=0;
        int slow=0;
        int c=1;
        for (fast = 1; fast < nums.length; fast++) {
            if (nums[fast]==nums[fast-1]){
                c++;
            }
            else
                c=1;
            if (c<=2){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }

    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)>='0'&&s.charAt(i)<='9')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                list.add(s.charAt(i));
            }
        }
        Character[] t=new Character[list.size()];
        t=list.toArray(t);
        int l=0;
        int r=t.length-1;
        while (l<=r){
            if (t[l]!=t[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] temp=new int[difficulty.length][2];
        for (int i = 0; i < temp.length; i++) {
            temp[i][0]=difficulty[i];
            temp[i][1]=profit[i];
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]? o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        Arrays.sort(worker);
        int i=0;
        int j=0;
        int sum=0;
        int max=0;
        for ( j = 0; j < worker.length&&i<temp.length; ) {
            if (worker[j]>=temp[i][0]){
                max=Math.max(max,temp[i][1]);
                i++;
            }
            else {
                sum+=max;
                if (i!=0){
                    i--;
                }
                j++;

            }
        }
        sum+=(worker.length-j)*max;
        return sum;
    }
}
