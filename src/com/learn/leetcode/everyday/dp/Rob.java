package com.learn.leetcode.everyday.dp;

import com.test.designmodel.abstaractFactory.FactoryProducer;
import com.yanglk.algorithm.tree_.TreeNode;

import java.util.*;

public class Rob {
    public static void main(String[] args) {
        System.out.println(new Rob().rob1(new int[]{4,1,2}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] opt = new int[n];
        if (n==1){
            return nums[0];
        }
        if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        opt[0]=nums[0];
        opt[1]=nums[1];
        for (int i = 2; i < n; i++) {
            opt[i]= opt[i-1];
            for (int j = 0; j < i-1; j++) {
                opt[i]=Math.max(opt[i],opt[j]+nums[i]);
            }
        }
        return opt[n-1];
    }

    public int rob11(int[] nums) {
        int n = nums.length;
        int[] opt = new int[n];
        if (n==1){
            return nums[0];
        }
        if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        opt[0]=nums[0];
        opt[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            opt[i]=Math.max(opt[i-1],opt[i-2]+nums[i]);
        }

        return opt[n-1];
    }

    public int rob12(int[] nums) {
        int n = nums.length;
        int[] opt = new int[n];
        if (n==1){
            return nums[0];
        }
        if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        int first=nums[0];
        int second=Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            int tem =second;
            second=Math.max(second,first+nums[i]);
            first = tem;
        }

        return second;
    }


    public int rob1(int[] nums) {
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(rangeRob(nums,0,n-2),rangeRob(nums,1,n-1));
    }

    public int rangeRob(int[] nums,int l,int r){
        int n = r-l+1;
        int[] opt = new int[n];
        opt[0]=nums[l];
        opt[1]=nums[l+1];
        if (n==2){
            return Math.max(opt[0],opt[1]);
        }
        for (int i = 2; i < n; i++) {
            opt[i]= opt[i-1];
            for (int j = 0; j < i-1; j++) {
                opt[i]=Math.max(opt[i],opt[j]+nums[i+l]);
            }
        }
        return opt[n-1];

    }


    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num: nums) {
            max=Math.max(max,num);
        }
        int[] sum = new int[max+1];
        for (int num : nums) {
            sum[num] += num;
        }
        return deleteAndEarn1(sum);
    }
    public int deleteAndEarn1(int[] nums){
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        int opt0=nums[0];
        int opt1=Math.max(opt0,nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = opt1;
            opt1=Math.max(opt1,opt0+nums[i]);
            opt0=temp;
        }
        return opt1;
    }

    // f    被选中
    // g    未被选中
    Map<TreeNode,Integer> f = new HashMap<>();
    Map<TreeNode,Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    public void dfs(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        dfs(treeNode.left);
        dfs(treeNode.right);
        f.put(treeNode,treeNode.val+g.getOrDefault(treeNode.left,0)+g.getOrDefault(treeNode.right,0));
        g.put(treeNode,Math.max(f.getOrDefault(treeNode.left,0),g.getOrDefault(treeNode.left,0))+
                Math.max(f.getOrDefault(treeNode.right,0),g.getOrDefault(treeNode.right,0)));
    }

    Map<Integer,List<Integer>> map = new HashMap<>();
    int[] vis ;
    boolean flag = true;
    Stack<Integer> stack = new Stack<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1],list);
        }
        vis = new int[numCourses];

        for (int i = 0; i < numCourses && flag; i++) {
            if (vis[i]==0){
                dfs(i);
            }
        }
        return true;
    }
    public void dfs(int i){
        vis[i]=1;
        List<Integer> next = map.getOrDefault(i,new ArrayList<>());
        for (Integer neighbor : next) {
           if (vis[neighbor]==0){
                dfs(neighbor);
                if (!flag){
                    return;
                }
           }if (vis[neighbor]==1){
               flag = false;
               return ;
            }
        }
        vis[i]=2;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1],list);
        }
        vis = new int[numCourses];

        for (int i = 0; i < numCourses ; i++) {
            if (vis[i]==0){
                dfs1(i);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            stack.get(i);
        }
        return res;
    }

    public void dfs1(int i){
        vis[i]=1;
        List<Integer> next = map.getOrDefault(i,new ArrayList<>());
        for (Integer neighbor : next) {
            if (vis[neighbor]==0) {
                dfs1(neighbor);
            }
        }
        vis[i]=2;
        stack.add(i);
    }
}
