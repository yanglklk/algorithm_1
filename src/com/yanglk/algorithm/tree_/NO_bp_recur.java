package com.yanglk.algorithm.tree_;

import sun.java2d.pipe.SpanIterator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        new NO_bp_recur().preRecur(t1);
        new NO_bp_recur().inRecur(t1);
        new NO_bp_recur().postRecur(t1);
        new NO_bp_recur().layerRecur(t1);



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
        System.out.println("非递归中序");
        if(head!=null){
            Stack<TreeNode> stack=new Stack<>();
            while (!stack.empty()||head!=null){
                if (head!=null){
                    stack.push(head);
                    head=head.left;
                }else {
                    head=stack.pop();
                    System.out.println(head.val);
                    head=head.right;
                }
            }
        }
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


}
