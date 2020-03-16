package com.yanglk.algorithm.tree_;

import com.sun.media.sound.RIFFInvalidDataException;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import com.yanglk.algorithm.offer.Array;

import javax.crypto.spec.IvParameterSpec;
import javax.sound.midi.Soundbank;
import java.awt.*;
import java.lang.annotation.ElementType;
import java.util.*;
import java.util.List;

public class Tree {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(6);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(7);
        TreeNode t7=new TreeNode(1);
        t1.left=t2;
        t1.right=t3;
        t2.left=t7;
        t2.right=t4;
        t3.left=t5;
        t3.right=t6;

//        TreeLinkNode t1=new TreeLinkNode(1);
//        TreeLinkNode t2=new TreeLinkNode(2);
//        TreeLinkNode t3=new TreeLinkNode(3);
//        TreeLinkNode t4=new TreeLinkNode(4);
//        TreeLinkNode t5=new TreeLinkNode(5);
//        TreeLinkNode t6=new TreeLinkNode(6);
//        TreeLinkNode t7=new TreeLinkNode(7);
//        t1.left=t2;
//        t1.right=t3;
//        t2.left=null;
//        t2.right=t4;
//        t3.left=t5;
//        t3.right=t6;
//        t2.next=t1;
//        t3.next=t1;
//        t4.next=t2;
//        t5.next=t3;
//        t6.next=t3;

        System.out.println(new Tree().pathSum(t1,11));

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2==null)
            return false;
        if (root1==null&&root2!=null)
            return false;
        boolean flag=false;
        if (root1.val==root2.val)
            flag=isSubTree(root1,root2);
        if (!flag){
            flag=HasSubtree(root1.left,root2);
            if (!flag)
                flag=HasSubtree(root1.right,root2);
        }
        return flag;
    }

    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if (root2==null)
            return true;
        if (root1==null&&root2!=null)
            return false;
        if (root1.val==root2.val){
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }
        else
            return false;

    }

    public void Mirror(TreeNode root) {
        if (root!=null){
            Mirror(root.left);
            Mirror(root.right);
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if (root==null)
            return list;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            list.add(temp.val);
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
        return list;
    }

    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        else {
            return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(TreeDepth(root.right)-TreeDepth(root.left))<=1
                &&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null)
            return true;
        return isSymmetrical1(pRoot.left,pRoot.right);

    }

    boolean isSymmetrical1(TreeNode left,TreeNode right) {
        if (left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;
        return left.val==right.val&&isSymmetrical1(left.right,right.left)&&isSymmetrical1(left.left,right.right);

    }

    public TreeNode Mirror1(TreeNode root) {
        if (root!=null){
            TreeNode temp=new TreeNode(root.val);
            temp.left=Mirror1(root.right);
            temp.right=Mirror1(root.left);
            return temp;
        }
        return root;
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        if (pRoot==null)
            return lists;
        queue.add(pRoot);
        int start=0;
        int end=1;
        ArrayList<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            start++;
            list.add(temp.val);
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
            if (start==end){
                lists.add(list);
                end=queue.size();
                start=0;
                list=new ArrayList<>();
            }
        }
        return lists;
    }

    public ArrayList<ArrayList<Integer>> Print_zhi(TreeNode pRoot) {
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        if (pRoot==null)
            return lists;
        queue.add(pRoot);
        int start=0;
        int end=1;
        boolean flag=false;
        ArrayList<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            start++;
            list.add(temp.val);
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
            if (start==end){
                if (flag){
                    for (int i = 0; i < list.size()/2; i++) {
                        int m=list.get(i);
                        list.set(i,list.get(list.size()-i-1));
                        list.set(list.size()-i-1,m);
                    }
                }
                flag=!flag;
                lists.add(list);
                end=queue.size();
                start=0;
                list=new ArrayList<>();
            }
        }
        return lists;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null)
            return null;
        TreeLinkNode p=pNode;
        while (p.next!=null){
            p=p.next;
        }
        ArrayList<TreeLinkNode> list=new ArrayList<>();
        mid(p,list);
        int i1=0;
        for (i1 = 0; i1 < list.size(); i1++) {
            if (list.get(i1)==pNode)
                break;
        }
        if (i1<list.size()-1)
            return list.get(i1+1);
        return null;
    }
    public void  mid(TreeLinkNode root,ArrayList<TreeLinkNode> list){
        if (root!=null){
            mid(root.left,list);
            list.add(root);
            mid(root.right,list);
        }

    }

    public void  mid1(TreeNode root,ArrayList<TreeNode> list){
        if (root!=null){
            mid1(root.left,list);
            list.add(root);
            mid1(root.right,list);
        }

    }

    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (k==0)
            return null;
        ArrayList<TreeNode> list=new ArrayList<>();
        mid1(pRoot,list);
        if (list.size()<k)
            return null;
        return list.get(k-1);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode root=pRootOfTree;
        TreeNode temp=null;
        while (!stack.empty()||root!=null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                if (temp != null) {
                    temp.right = root;
                    root.left = temp;
                    if (temp.left==null)
                        pRootOfTree=temp;
                }
                temp = root;
                root = root.right;
            }
        }
        return pRootOfTree;
    }

    ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    ArrayList<Integer> list=new ArrayList<>();
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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> queue=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        boolean f=true;
        queue.add(root);
        TreeNode mark=root;
        int len=1;
        List<Integer> l=new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (f) {
                l.add(temp.val);
            } else {
                l.add(0, temp.val);
            }

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

            if (l.size() == len) {
                list.add(l);
                l = new ArrayList<>();
                len = queue.size();
                f = !f;
            }
        }
        System.out.println(list);
        return list;
    }

    public boolean isBalance(TreeNode root){
        if (root==null)
            return true;
        return Math.abs(height(root.left)-height(root.right))<2&&isBalance(root.left)&&isBalance(root.right);
    }
    public int height(TreeNode root){
        if (root==null)
            return 0;
        return Math.max(height(root.right),height(root.left))+1;
    }

    public int minDeepth(TreeNode root){
        if (root==null)
            return 0;
        if (root.left==null&&root.right==null)
            return 1;
        int minDep=Integer.MAX_VALUE;
        if (root.left!=null){
            minDep=Math.min(minDeepth(root.left),minDep);
        }
        if (root.right!=null){
            minDep=Math.min(minDeepth(root.right),minDep);
        }
        return minDep+1;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        sum-=root.val;
        if (root.left==null&&root.right==null)
            return sum==0;
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }

    public List<List<Integer>> pathSum(TreeNode root ,int sum){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        pathSum_(root,sum,lists,l);
        return lists;
    }

    public void pathSum_(TreeNode root ,int sum,List<List<Integer>> list,List<Integer> l){
        if (root==null)
            return;
        sum-=root.val;
        l.add(root.val);
        if(root.left!=null)
            pathSum_(root.left,sum,list,l);
        if (root.right!=null)
            pathSum_(root.right,sum,list,l);
        if (root.left==null&&root.right==null&&sum==0){
            List<Integer> ll=new ArrayList<>();
            ll.addAll(l);
            list.add(ll);
        }
        l.remove(l.size()-1);

    }









    }
