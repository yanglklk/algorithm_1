package com.yanglk.algorithm.tree_;

import sun.java2d.pipe.SpanIterator;

import javax.sound.midi.Soundbank;
import java.util.*;

public class NO_bp_recur {

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
//        new NO_bp_recur().preRecur(t1);
        new NO_bp_recur().inRecur(t1);
//        new NO_bp_recur().postRecur(t1);
        //new NO_bp_recur().layerRecur1(t1);
 //       System.out.println( new NO_bp_recur().layerRecur1(t1));
//        Stack<TreeNode> stack=new Stack<>();
//        List<Stack<TreeNode>> list =new ArrayList<>();
//        new NO_bp_recur().passview(t1,stack,list);
//        for (Stack<TreeNode> treeNodes : list) {
//            for (TreeNode treeNode : treeNodes) {
//                System.out.println(treeNode.val);
//            }
//        }



    }
    public void preRecur(TreeNode head){
        System.out.println("非递归先序");
        if(head!=null){
            Stack<TreeNode> stack=new Stack<>();
            stack.push(head);
            while (!stack.empty()){
                head=stack.pop();
                System.out.println(head.val);
                if (head.right!=null){
                    stack.push(head.right);
                }
                if (head.left!=null){
                    stack.push(head.left);
                }
            }
        }
    }

    public void inRecur(TreeNode head){
//        System.out.println("非递归中序");
//        if(head!=null){
//            Stack<TreeNode> stack=new Stack<>();
//            while (!stack.empty()||head!=null){
//                if (head!=null){
//                    stack.push(head);
//                    head=head.left;
//                }else {
//                    head=stack.pop();
//                    System.out.println(head.val);
//                    head=head.right;
//                }
//            }
//        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=head;
        List<Integer> l=new ArrayList<>();
        while (!stack.empty()||p!=null){
            if(p !=null ){
                stack.push(p);
                p=p.left;
            }
            else {

                p=stack.pop();
                System.out.println(p.val);
                l.add(p.val);
                p=p.right;
            }

        }
        int[] res=new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i]=l.get(i);
        }
        //return res;
    }

    public void postRecur(TreeNode head){
        System.out.println("非递归后序");
        if(head!=null){
            Stack<TreeNode> stack=new Stack<>();
            Stack<TreeNode> helper=new Stack<>();
            stack.push(head);
            while (!stack.empty()){
                head=stack.pop();
                helper.push(head);
                if (head.left!=null){
                    stack.push(head.left);
                }
                if (head.right!=null){
                    stack.push(head.right);
                }
            }
            while (!helper.empty()){
                System.out.println(helper.pop().val);
            }
        }
    }

    public void layerRecur(TreeNode head){
        System.out.println("层次遍历");
        if(head!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()){
                head=queue.poll();
                System.out.println(head.val);
                if (head.left!=null)
                    queue.add(head.left);
                if (head.right!=null)
                    queue.add(head.right);
            }
        }
    }

    public List<List<Integer>> layerRecur1(TreeNode head){
        System.out.println("层次遍历");
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(head!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(head);

            int c=1;
            boolean f=true;
            while (!queue.isEmpty()){
                head=queue.poll();
                list.add(head.val);
                //System.out.println(head.val);
                if (head.left!=null)
                    queue.add(head.left);
                if (head.right!=null)
                    queue.add(head.right);
                if (list.size()==c){
                    List<Integer> l=new ArrayList<>();
                    if (!f){
                        for (int i = list.size() - 1; i >= 0; i--) {
                            l.add(list.get(i));
                        }
                    }
                    else {
                        l.addAll(list);
                    }

                    lists.add(l);
                    c=queue.size();
                    list.clear();
                    f=!f;
                }
            }
        }
        return lists;
    }

    //从根到叶遍历
    public void passview(TreeNode root, Stack<TreeNode> stack, List<Stack<TreeNode>> list){
        if (root!=null){
            stack.push(root);
            if (root.left==null&&root.right==null){
                Stack<TreeNode> t=new Stack<>();
                t.addAll(stack);
                list.add(t);
            }
            else {
                passview(root.left,stack,list);
                passview(root.right,stack,list);
            }
            stack.pop();

        }
    }


}
