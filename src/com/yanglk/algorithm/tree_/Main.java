package com.yanglk.algorithm.tree_;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public void bp(TreeNode root, List<List<Integer>> lists,List<Integer> list){
        if (root.left==null&&root.right==null){
            lists.add(list);
        }
        if (root.left!=null){
            List<Integer> l=new ArrayList<>();
            l.addAll(list);
            l.add(root.left.val);
            if (root.left.left==null&&root.left.right==null){
                lists.add(l);
            }
            else {
                bp(root.left,lists,l);
            }
        }
        if (root.right!=null){
            List<Integer> l=new ArrayList<>();
            l.addAll(list);
            l.add(root.right.val);
            if (root.right.left==null&&root.right.right==null){
                lists.add(l);
            }
            else {
                bp(root.right,lists,l);
            }
        }
    }

    public List<List<Integer>> path(TreeNode root, int sum){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        bp(root,lists,list);
        for (List<Integer> integers : lists) {
            int s=0;
            for (Integer integer : integers) {
                s+=integer;
            }
            if (s!=sum){
                lists.remove(integers);
            }
        }
        return lists;
    }
}
