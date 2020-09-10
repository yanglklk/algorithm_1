package com.yanglk.algorithm.tree_;


import com.yanglk.algorithm.link_.ListNode;

import javax.management.Query;
import java.util.*;

public class DFS {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        new DFS().sortedArrayToBST(nums);
    }
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        if (root==null){
            return true;
        }
        long last=Long.MIN_VALUE;
        while (!stack.empty()||root!=null){
           if (root!=null){
                stack.push(root);
                root=root.left;
           }
           else {
               root=stack.pop();
               int val=root.val;
               if (val<=last){
                  return false;
               }
               last=val;
               root=root.right;
           }
        }
        return  true;

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null)
            return true;
        if (p!=null&&q!=null){
            return p.val==q.val&&(isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
        }
        else
            return false;
    }

    public TreeNode sortedArrayToBST(int[] nums){
        return sortedArrayToBST_(nums,0,nums.length-1,new TreeNode(0));
    }
    public TreeNode sortedArrayToBST_(int[] nums,int l,int r,TreeNode root){
        if (l>r)
            return null;
        int m=(l+r)/2;
        root.val=nums[m];
        root.left=sortedArrayToBST_(nums,l,m-1,new TreeNode(0));
        root.right=sortedArrayToBST_(nums,m+1,r,new TreeNode(0));
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {

        return sortedListToBST_(head,null,new TreeNode(0));
    }
    public TreeNode sortedListToBST_(ListNode p,ListNode q,TreeNode root){
        ListNode p1=p;
        ListNode q1=p1.next;
        while (q1!=q){
            p1=p1.next;
            if (q1.next!=q)
                q1=q1.next.next;
            else
                break;
        }
        root.val=p1.val;
        root.left=sortedListToBST_(p,p1,new TreeNode(0));
        root.right=sortedListToBST_(p1,q,new TreeNode(0));
        return root;
    }


    public void flatten(TreeNode root){
        if (root==null)
            return ;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode last=new TreeNode(0);
        while (!stack.empty()){
            root=stack.pop();
            last.right=root;
            last.left=null;
            last=root;
            if (root.right!=null)
                stack.push(root.right);
            if (root.left!=null)
                stack.push(root.left);
        }
    }

    public int sumNumbers(TreeNode root){
        if (root==null)
            return 0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        Stack<Integer> queue=new Stack<>();
        int sum=0;
        queue.add(root.val);
        while (!stack.empty()) {
            root = stack.pop();
            int temp = queue.pop();
            if (root.right==null&&root.left==null){
                sum+=temp;
            }
            if (root.right != null) {
                stack.push(root.right);
                queue.add(temp * 10 + root.right.val);
            }

            if (root.left != null){
                stack.push(root.left);
                queue.add(temp * 10 + root.left.val);
            }

        }
        return sum;

    }

    public List<Integer> rightSideView(TreeNode root){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (root==null)
            return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=1;
        while (!queue.isEmpty()){
            root=queue.poll();
            list.add(root.val);
            if (root.right!=null)
                queue.add(root.right);
            if (root.left!=null)
                queue.add(root.left);
            if (count==list.size()){
                lists.add(list);
                list=new ArrayList<>();
                count=queue.size();
            }
        }
        list.clear();
        for (List<Integer> integerList : lists) {
            list.add(integerList.get(0));
        }
        return list;
    }


}
