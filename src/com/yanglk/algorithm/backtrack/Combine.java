package com.yanglk.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine {
    public Combine() {
    }

    public static void main(String[] args) {
        int[] nums={2,5,2,1,2};
        List<List<Integer>> l;
        Combine combine=new Combine();
       //l=combine.combine(5,3);
        System.out.println(combine.combinationSum(nums,5));
    }
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list =new ArrayList<>();
        int[] nums=new int[n];
        int[] vis=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i+1;
        }
        combine1(k,lists,new ArrayList<>(),nums,vis);
        return lists;
    }
    public void combine1(int k,List<List<Integer>> lists,List<Integer> list,int[] nums,int[] vis){
        if (list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (vis[i]==1||list.size()>0&&nums[i]>list.get(list.size()-1))
//                continue;
//            vis[i]=1;
//            list.add(nums[i]);
//            combine1(k,lists,list,nums,vis);
//            vis[i]=0;
//            list.remove(list.size()-1);
//        }
        for (int i = 0; i<nums.length; i++) {
            if (vis[i]==1||list.size()>0&&nums[i]<list.get(list.size()-1))
                continue;
            vis[i]=1;
            list.add(nums[i]);
            combine1(k,lists,list,nums,vis);
            vis[i]=0;
            list.remove(list.size()-1);
        }


    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        int sum=0;
        int[] vis=new int[nums.length];
        combinationSum2(nums,target,sum,vis,lists,new ArrayList<>());
        return lists;
    }
    public void combinationSum2(int[] nums,int target,int sum,int[] vis,List<List<Integer>> lists,List<Integer> list){
        if (sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]&&vis[i-1]==0){
                continue;

            }
            if (sum+nums[i]>target)
                break;
            if (vis[i]==1||list.size()>0&&nums[i]<list.get(list.size()-1))
                continue;

//            if(lists.size()>0 && lists.get(lists.size()-1).get(lists.get(lists.size()-1).size()-1)==nums[i]){
//                continue;
//            }
            vis[i]=1;
            list.add(nums[i]);
            sum+=nums[i];
            combinationSum2(nums,target,sum,vis,lists,list);
            list.remove(list.size()-1);
            sum-=nums[i];
            vis[i]=0;
        }

    }

    public void combinationSum1(int[] nums,int target,int sum,List<List<Integer>> lists,List<Integer> list){
        if (sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum+nums[i]>target)
                break;
            if (list.size()>0&&nums[i]<list.get(list.size()-1))
                continue;

            list.add(nums[i]);
            sum+=nums[i];
            combinationSum1(nums,target,sum,lists,list);
            list.remove(list.size()-1);
            sum-=nums[i];
        }
    }
}
