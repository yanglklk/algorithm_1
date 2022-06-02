package com.learn.leetcode.everyday.dfs;

import com.test.designmodel.proxy.model.RealImage;
import com.yanglk.algorithm.tree_.TreeNode;

import java.util.*;

public class DFS {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1){
                    return islandPerimeter1(grid,i,j,n,m);
                }
            }
        }
        return -1;
    }

    public int islandPerimeter1(int[][] grid,int r,int c,int n,int m) {
        if (!(r>=0 && r<n&&c>=0 &&c<m)){
            return 1;
        }
        if (grid[r][c]==0){
            return 1;
        }
        if (grid[r][c]!=1){
            return 0;
        }
        grid[r][c]=2;
        return islandPerimeter1(grid,r-1,c,n,m)
                +islandPerimeter1(grid,r+1,c,n,m)
                +islandPerimeter1(grid,r,c-1,n,m)
                +islandPerimeter1(grid,r,c+1,n,m);
    }


    Map<Integer,Integer> map = new HashMap<>();
    int maxCount=0;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
       findMode1(root);
        int n = res.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i]=res.get(i);
        }
        return ans;
    }
    public void findMode1(TreeNode root) {
        if (root==null){
            return;
        }
        findMode1(root.left);
        Integer count = map.getOrDefault(root.val, 0);
        count++;
        map.put(root.val,count);
        if (count>maxCount){
            maxCount=count;
            res.clear();
            res.add(root.val);
        }else if (count==maxCount){
            res.add(root.val);
        }
        findMode1(root.right);

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        findTarget(root,list);
        int r = list.size()-1;
        int l = 0;
        while (l<r){
            int sum = list.get(l) + list.get(r);
            if (sum==k){
                return true;
            }else if(sum<k){
                l++;
            }else {
                r--;
            }
        }
        return false;
    }

    public void findTarget(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        findTarget(root.left,list);
        list.add(root.val);
        findTarget(root.right,list);
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<DeepWidTreeNode> queue = new LinkedList<>();
        queue.add(new DeepWidTreeNode(root,0,1));
        int max = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            int left = queue.peek().poi;
            for (int i = 0; i < size; i++) {
                DeepWidTreeNode top = queue.poll();
                if (i==size-1){
                    max= Math.max(max,top.poi-left+1);
                }
                if (top.treeNode.left!=null){
                    queue.add(new DeepWidTreeNode(top.treeNode.left,top.deep+1,top.poi*2));
                }
                if (top.treeNode.right!=null) {
                    queue.add(new DeepWidTreeNode(top.treeNode.right, top.deep + 1, top.poi * 2 + 1));
                }
            }
        }
        return max;
    }

    class DeepWidTreeNode{
        TreeNode treeNode;
        int deep;
        int poi;

        public DeepWidTreeNode(TreeNode treeNode, int deep, int poi) {
            this.treeNode = treeNode;
            this.deep = deep;
            this.poi = poi;
        }
    }
}
