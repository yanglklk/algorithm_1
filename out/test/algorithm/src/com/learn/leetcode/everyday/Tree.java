package com.learn.leetcode.everyday;

import com.google.common.collect.Lists;
import com.trie.TrieNode;
import com.yanglk.algorithm.tree_.TreeNode;

import java.nio.file.NotLinkException;
import java.util.*;

public class Tree {

    public static void main(String[] args) {
        new Tree().numTrees(3);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal1(root,res);
        return res;
    }
    public void inorderTraversal1(TreeNode root,List<Integer> list) {
        if (root==null){
            return;
        }
        inorderTraversal1(root.left,list);
        list.add(root.val);
        inorderTraversal1(root.right,list);
    }

    /*
    有效 二叉搜索树定义如下：

    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode root ,long start, long end) {
        if (root==null){
            return true;
        }
        if (root.val<=start || root.val>=end){
            return false;
        }
        return isValidBST1(root.left,start,root.val) && isValidBST1(root.right,root.val,end);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p==null && q != null) || (p!=null && q==null)){
            return false;
        }
        if (p==null && q ==null){
            return true;
        }
        return (p.val== q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if ((p==null && q != null) || (p!=null && q==null)){
            return false;
        }
        if (p==null && q ==null){
            return true;
        }
        return (p.val== q.val) && isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums,int l, int r){
        if (l==r){
            return null;
        }
        // >>1 是➗2
        int mid = (l+r)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left= sortedArrayToBST(nums,l,mid);
        root.right = sortedArrayToBST(nums,mid+1,r);
        return root;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.val==targetSum && root.right==null && root.left ==null){
            return true;
        }
        return hasPathSum(root.right,targetSum-root.val)||hasPathSum(root.left,targetSum-root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<>();
        pathSum(root,targetSum,lists,new ArrayList<>());
        return lists;
    }
    public void pathSum(TreeNode root, int targetSum,List<List<Integer>> lists,List<Integer> list) {
        if (root==null){
            return;
        }
        list.add(root.val);
        if (root.val==targetSum && root.right==null && root.left ==null){
            ArrayList<Integer> l = new ArrayList<>();
            l.addAll(list);
            lists.add(l);
        }
        pathSum(root.left,targetSum-root.val,lists,list);
        pathSum(root.right,targetSum-root.val,lists,list);
        list.remove(list.size()-1);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        firstOrder(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right=list.get(i+1);
            list.get(i).left=null;
        }

    }

    public void firstOrder(TreeNode root,List<TreeNode> list) {
        if (root==null){
            return;
        }
        list.add(root);
        firstOrder(root.left,list);
        firstOrder(root.right,list);
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<2 && isBalanced(root.right) && isBalanced(root.left);
    }

    public int height(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                list.add(top.val);

                if (top.left!=null){
                    queue.add(top.left);
                }
                if (top.right!=null){
                    queue.add(top.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int c=0;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                list.add(top.val);
                if (top.left!=null){
                    queue.add(top.left);
                }
                if (top.right!=null){
                    queue.add(top.right);
                }
            }
            if (c%2==1){
                Collections.reverse(list);
            }
            lists.add(list);
            c++;
        }
        return lists;
    }

    public int numTrees(int n) {
        if (n<=1){
            return 1;
        }
        int[] opt = new int[n+1];
        opt[0]=opt[1] =1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                opt[i]+=(opt[i-j]*opt[j-1]);
            }
        }
        return opt[n];
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int l,int r) {
        List<TreeNode> list = new ArrayList<>();
        if (l>r){
            list.add(null);
            return list;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);
            for (TreeNode lefti : left) {
                for (TreeNode righti : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left =lefti;
                    treeNode.right = righti;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> lists = new ArrayList<>();
        inorderTraversal(root,lists);
        int size = lists.size();
        int min_i = size-1;
        int max_i = 0;
        for (int i = size-1; i > 0; i--) {
            if (lists.get(i).val<lists.get(i-1).val){
                min_i=i;
                break;
            }
        }
        for (int i = 0; i <size-1; i++) {
            if (lists.get(i).val>lists.get(i+1).val){
                max_i=i;
                break;
            }
        }
        int temp = lists.get(min_i).val;
        lists.get(min_i).val = lists.get(max_i).val;
        lists.get(max_i).val = temp;

        
    }
    public void inorderTraversal(TreeNode root,List<TreeNode> list ) {
        if (root==null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root);
        inorderTraversal(root.right,list);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                list.add(top.val);
                if (top.left!=null){
                    queue.add(top.left);
                }
                if (top.right!=null){
                    queue.add(top.right);
                }
            }
            lists.add(0,list);
        }
        return lists;
    }

    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node top = queue.poll();
                if (i!=size-1){
                    top.next= queue.peek();
                }else {
                    top.next=null;
                }
                if (top.left!=null){
                    queue.add(top.left);
                }
                if (top.right!=null){
                    queue.add(top.right);
                }
            }
        }
        return root;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        binaryTreePaths(root,lists,new ArrayList<>());
        for (List<String> integers : lists) {
            String join = String.join("->",  integers);
            list.add(join);
        }
        return list;
    }

    public void binaryTreePaths(TreeNode root,List<List<String>> lists, List<String> list) {
        if (root == null){
            return;
        }
        list.add(String.valueOf(root.val));
        if (root.right==null && root.left==null){
            List<String> list1 = new ArrayList<>();
            list1.addAll(list);
            lists.add(list1);

        }
        binaryTreePaths(root.left,lists,list);
        binaryTreePaths(root.right,lists,list);
        list.remove(list.size()-1);
    }


    public List<String> binaryTreePaths1(TreeNode root) {
        Stack<TreeNode> stack =new Stack<>();
        stack.add(root);
        List<String> strings = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            sb.append(top.val);
            if (top.right==null && top.left==null){
                strings.add(sb.toString());
                sb= sb.deleteCharAt(sb.length()-1);
            }
            sb.append("->");
            if (top.right!=null){
                stack.add(top.right);
            }
            if (top.left!=null){
                stack.add(top.left);
            }
        }
        return null;
    }

    public int sumOfLeftLeaves(TreeNode root){
        return dfs(root);
    }
    public int dfs(TreeNode root){
        int sum =0;
        if (root!=null){
            if (root.left!=null){
                sum+=isLeaves(root.left)? root.left.val:dfs(root.left);
            }
            if (root.right!=null && !isLeaves(root.right)){
                sum+=dfs(root.right);
            }
        }
        return sum;
    }

    public boolean isLeaves(TreeNode root){
        return root.left==null && root.right==null;
    }

    public int sumOfLeftLeaves1(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        stack.add(root);
        int sum = 0;
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            if (top.right!=null){
                stack.add(top.right);
            }
            if (top.left!=null){
                if (isLeaves(top.left)){
                    sum+=top.left.val;
                }else {
                    stack.add(top.left);
                }
            }
        }
        return sum;
    }


}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class BSTIterator {

    public List<TreeNode> list = new ArrayList<>();
    public Integer i =0;
    public BSTIterator(TreeNode root) {
        inorderTraversalNStack(root);
    }

    public int next() {
        return list.get(i++).val;
    }

    public boolean hasNext() {
        return i<list.size();
    }

    public void inorderTraversal(TreeNode root) {
        if (root==null){
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    public void inorderTraversalNStack(TreeNode root) {
        Stack<TreeNode> stack =new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.add(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            list.add(top);
            root= top.right;
        }
    }

    public void firstorderTraversalNStack(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack =new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            list.add(top);
            if (top.right!=null){
                stack.add(top.right);
            }
            if (top.left!=null){
                stack.add(top.left);
            }
        }
    }

    public void postorderTraversalNStack(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack1 =new Stack<>();
        Stack<TreeNode> stack2 =new Stack<>();

        stack1.add(root);
        while (!stack1.isEmpty()){
            TreeNode top = stack1.pop();
            stack2.add(top);
            if (top.left!=null){
                stack1.add(top.left);
            }
            if (top.right!=null){
                stack1.add(top.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
    }
}

class BSTIterator1 {

    public Stack<TreeNode> stack ;
    public TreeNode root;
    public BSTIterator1(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        while (this.root!=null){
            stack.add(this.root);
            this.root = this.root.left;
        }
    }

    public int next() {
        while (this.root!=null){
            stack.add(this.root);
            this.root = this.root.left;
        }
        TreeNode top = this.stack.pop();
        this.root = top.right;
        return top.val;
    }

    public boolean hasNext() {
        return this.root!=null || !stack.isEmpty();
    }

}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if (root==null){
            return "#,";
        }
        s+= String.valueOf(root.val)+",";
        s+= serialize(root.left);
        s+= serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>( Arrays.asList(split));
        return reserialize(list);
    }

    public TreeNode reserialize( List<String> list) {
        if (list.get(0).equals("#")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=reserialize(list);
        root.right= reserialize(list);
        return root;
    }
    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
      getMinimumDifference1(root);
      return min;
    }
    public void getMinimumDifference1(TreeNode root) {
        if (root==null){
            return ;
        }
        getMinimumDifference1(root.left);
        if (pre==-1){
            pre= root.val;
        }else {
            min = Math.min(min,root.val-pre);
            pre= root.val;
        }
        getMinimumDifference1(root.right);
    }

    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        diameterOfBinaryTree1(root);
        return max;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root== null){
            return 0;
        }
        int left = diameterOfBinaryTree1(root.left);
        int rifht = diameterOfBinaryTree1(root.right);
        max=Math.max(left+rifht,max);
        return Math.max(left,rifht)+1;
    }


}
