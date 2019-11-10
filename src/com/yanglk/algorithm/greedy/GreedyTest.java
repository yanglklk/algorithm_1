package com.yanglk.algorithm.greedy;

import com.sun.corba.se.spi.orb.ParserImplBase;
import com.yanglk.algorithm.leetcode.PowerOfThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class GreedyTest {
    public static void main(String[] args) {
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        int[] p={5,1,2,3,4};
        int[] q={1,17,5,10,13,15,10,5,16,8};
        System.out.println(new Solution().reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}));
//        new Solution().findMinArrowShots(points);
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length && j < g.length; i++) {
            if (g[j] <= s[i]) {
                j++;
            }
        }
        return j;

    }

    public int findMinArrowShots(int[][] points) {
        if (points==null||points.length==0)
            return 0;
        Arrays.sort(points,(p1,p2)->{
            if (p1[0]==p2[0])
                return p1[1]-p2[1];
            else {
                return p1[0]-p2[0];
            }
        });

        int count=1;
        int end=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]<=end){
                end=Math.min(end,points[i][1]);
            }
            else {
                end=points[i][1];
                count++;
            }
        }
        return count;
    }

    public int mixProfit(int[] prices){
        if (prices==null||prices.length<2)
            return 0;
        int min=prices[0];
        int res=0;
        for (int i = 1; i < prices.length; i++) {
//            if (prices[i]<prices[i-1]){
//                min=
//            }
            if (prices[i]<min){
                min=prices[i];
                int j=i+1;
                for (;j<prices.length;j++){
                    if (prices[j]<=prices[j-1]){
                        break;
                    }
                }
                res=res+(prices[j-1]-min);
                i=j-1;
                min=prices[i];
            }
            else {
                res=res+(prices[i]-min);
                min=prices[i+1];
            }
        }
        return res;
    }

    public boolean isSubsequence(String s,String t){
        if (s.length()>t.length())
            return false;
        char[] chars=s.toCharArray();
        int star=0;
        for (int i = 0; i < chars.length; i++) {
            int index=t.substring(star).indexOf(chars[i]);
            if (index==-1)
                return false;
            star=star+index+1;
        }
        return true;
    }

    public int canCompleteCircuit(int[] gas,int[] cost){
        int sum_gas=0;
        int sum_cost=0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i]>=cost[i]){
                int j=(i+1)% gas.length;
                sum_gas=gas[i];
                sum_cost=0;
                for (;j!=i;){
                    sum_cost=cost[(j-1+gas.length)%gas.length];
                    sum_gas+=(gas[j]-sum_cost);
                    if (sum_gas<cost[j]){
                        break;
                    }
                    j=(j+1)%gas.length;
                }
                if (j==i){
                    return i;
                }

            }
        }
        return -1;
    }

    public int wiggleMaxLength(int[] nums){
        if(nums==null||nums.length<2)
            return nums.length;

        int[] tag=new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
           int t=(nums[i]-nums[i+1]);
           if (t>0)
               tag[i]=1;
           else if (t<0)
               tag[i]=-1;
           else
               tag[i]=0;
        }
        int max_count=tag[0]==0? 1:2;
        int j=0;
        for (int i = 1; i < tag.length&&j<tag.length; i++) {
            if (tag[j]!=tag[i]&&tag[i]!=0){
                max_count++;
                j=i;
            }
        }
        return max_count;
    }

    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people,(p1,p2)->{
            if (p1[0]==p2[0])
                return p1[1]-p2[1];
            return p2[0]-p1[0];
        });
        ArrayList<int[]> l=new ArrayList<>();
        for (int[] i : people){
            l.add(i[1],i);
        }
        return l.toArray(new int[0][]);
    }

}



