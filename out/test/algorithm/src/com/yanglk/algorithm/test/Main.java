package com.yanglk.algorithm.test;

import java.util.ArrayList;

public class Main {
    ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    ArrayList<Integer> list=new ArrayList<>();

    public TreeNode buildTree(ArrayList<Integer> treeValue){
        ArrayList<TreeNode> treeNodelist=new ArrayList<>();
        for (int i = 0; i < treeValue.size(); i++) {
            TreeNode r=new TreeNode(treeValue.get(i));
            treeNodelist.add(r);
        }
        for (int i = 0; i < treeNodelist.size(); i++) {
            TreeNode r=treeNodelist.get(i);
            r.left=treeNodelist.get(2*i);
            r.right=treeNodelist.get(2*i+1);
        }
        return treeNodelist.get(0);

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if (root==null)
            return lists;
        list.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return lists;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.val=value;
    }

}
