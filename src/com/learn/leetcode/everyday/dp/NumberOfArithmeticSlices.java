package com.learn.leetcode.everyday.dp;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yanglk.algorithm.tree_.Tree;
import com.yanglk.algorithm.tree_.TreeNode;

import java.util.*;

public class NumberOfArithmeticSlices {


    public static void main(String[] args) {
        new NumberOfArithmeticSlices().nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n<3){
            return 0;
        }
        int sumLen = 2;
        int sub = nums[1]-nums[0];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i]-nums[i-1]==sub){
                sumLen++;
            }else
            {
                if (sumLen>=3){
                    sum+=(((sumLen-1)*(sumLen-2))>>1);
                }
                sub = nums[i]-nums[i-1];
                sumLen =2;
            }
        }
        if (sumLen>=3){
            sum+=(((sumLen-1)*(sumLen-2))>>1);
        }
        return sum;
    }

    public int numDecodings(String s) {

        int n = s.length();
        int[] opt = new int[n+1];
        if (s.charAt(0)=='0'){
            return 0;
        }
        opt[0] = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            if (chars[i-1]!='0'){
                opt[i]+=opt[i-1];
            }
            if (i>1 && (chars[i-2]=='1' || (chars[i-2]=='2' && chars[i-1]<'7'))){
                opt[i]+=opt[i-2];
            }
        }
        return opt[n];
    }

    public int trap(int[] height) {
        int n = height.length;
        int sum=0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        rmax[n-1] =height[n-1];
        for (int i = 1; i < n; i++) {
            lmax[i]=Math.max(lmax[i-1],height[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i+1],height[i]);
        }
        for (int i = 1; i < n-1; i++) {
            sum+= Math.max(0,Math.min(rmax[i],lmax[i])-height[i]);
        }
        return sum;
    }

    public int trap1(int[] height) {
        int n = height.length;
        int sum=0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && height[i]>height[stack.peek()]){
                int top = stack.pop();
                if (stack.empty()){
                    break;
                }
                int l = stack.peek();
                sum+= (i-l-1)*(Math.min(height[l],height[i])-height[top]);
            }
            stack.push(i);
        }
        return sum;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int sum=0;
        Stack<Integer> stack = new Stack<>();
        int[] h = new int[n+2];
        for (int i = 1; i < n+1; i++) {
            h[i]=heights[i-1];
        }
        for (int i = 0; i < n+2; i++) {
            while (!stack.empty() && h[i]<h[stack.peek()]){
                int top = stack.pop();
                if (stack.empty()){
                    break;
                }
                int l = stack.peek();
                sum =Math.max(sum,(i-l-1)*h[top]);
            }
            stack.push(i);
        }
        return sum;
    }

    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty()&& stack.peek()>num.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i));
        }
        while (k!=0){
            stack.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        String s = sb.reverse().toString();
        if (sb.equals("")){
            return "0";
        }
        for (int i = 0; i < sb.length(); i++) {
            if (s.charAt(i)=='0'){
                continue;
            }else {
                return s.substring(i).equals("")? "0":s.substring(i);
            }
        }
        return "0";

    }

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        Set<Character> visit = new HashSet<>();
        int[] pos = new int[26];
        // 记录最后一次出现位置
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i)-'a']=i;
        }
        for (int i = 0; i < n; i++) {
            if (visit.contains(s.charAt(i))){
                continue;
            }
            // 比栈顶元素小 且 栈顶元素后面还会出现
            while (!stack.empty() && stack.peek()>s.charAt(i) && pos[stack.peek()-'a']>i){
                Character top = stack.pop();
                visit.remove(top);
            }
            stack.push(s.charAt(i));
            visit.add(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n2; i++) {
            map.put(nums2[i],-1);
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] newNums = new int[2*n];
        for (int i = 0; i < n; i++) {
            newNums[i] = nums[i];
            newNums[i+n] = nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2*n; i++) {
            map.put(i,-1);
            while (!stack.empty()&&newNums[i]>newNums[stack.peek()]){
                map.put(stack.pop(),newNums[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            nums[i]=map.get(i);
        }
        return nums;
    }


    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2*n; i++) {
            map.put(i,-1);
            while (!stack.empty()&&nums[i%n]>nums[stack.peek()%n]){
                map.put(stack.pop(),nums[i%n]);
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            nums[i]=map.get(i);
        }
        return nums;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int today = temperatures[i];
            res[i]=0;
            while (!stack.isEmpty() && today>temperatures[stack.peek()]){
                Integer top = stack.pop();
                res[top] = i-top;
            }
            stack.push(i);
        }
        return res;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            TreeNode root = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val<root.val){
                TreeNode top = stack.pop();
                if (stack.isEmpty()&& stack.peek().val<root.val){
                    stack.peek().right=top;
                }else {
                    root.left=top;
                }

            }
            stack.push(root);
        }
        TreeNode root = null;
        while (!stack.isEmpty()){
            root = stack.pop();
            if (!stack.isEmpty()){
                stack.peek().right=root;
            }
        }
        return root;
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        return constructTree(nums,0,nums.length);
    }
    public TreeNode constructTree(int[] nums, int l ,int r){
        if (l==r){
            return null;
        }
        int maxId = maxIds(nums,l,r);
        TreeNode root = new TreeNode(nums[maxId]);
        root.left = constructTree(nums,l,maxId);
        root.right= constructTree(nums,maxId+1,r);
        return root;
    }
    public int maxIds(int[] nums, int l ,int r){
        int maxId = l;
        for (int i = l; i < r; i++) {
            if (nums[i]>nums[maxId]){
                maxId = i;
            }
        }
        return maxId;
    }
}
