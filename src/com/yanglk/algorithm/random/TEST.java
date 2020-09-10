package com.yanglk.algorithm.random;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;
import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.org.apache.xpath.internal.FoundIndex;
import com.yanglk.algorithm.design_model.FactoryModel;
import com.yanglk.algorithm.offer.Str;
import com.yanglk.algorithm.tree_.NO_bp_recur;
import com.yanglk.algorithm.tree_.Tree;
import com.yanglk.algorithm.tree_.TreeNode;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.lang.invoke.LambdaConversionException;
import java.lang.reflect.WildcardType;
import java.security.interfaces.ECKey;
import java.util.*;

public class TEST {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count1=0;
        for (int num : nums) {
            count1 += Math.abs(num-nums[nums.length/2]-num);
        }
        return count1;
    }

    public  TreeNode increasingBST(TreeNode root){
        if (root==null)
            return root;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode last= new TreeNode(0);
        TreeNode ret=last;
        while (!stack.empty()||root!=null){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }
            else {
                root=stack.pop();
                last.right=root;
                last.left=null;
                last=root;
                root=root.right;
            }
        }
        return ret.right;
    }

    public  int subarrayBitwiseORs(int[] A){
        if (A==null||A.length==0)
           return 0;
        Set<Integer> set=new HashSet<>();
        int l=A.length;
        for (int i = 0; i < l; i++) {
            int sum=A[i];
            set.add(A[i]);
            for (int j = i; j <l; j++) {
                sum|=A[j];
                set.add(sum);
            }
        }
        return set.size();
    }

    public int sumSubarraysMins(int[] A){
        int l=A.length;
        int sum=0;
        for (int i = 0; i < l; i++) {
            int min=A[i];
            for (int j = i; j < l; j++) {
                if (A[j]<min) {
                    min=A[j];
                }
                sum+=min;
                sum=sum%1000000007;
            }
        }
        return sum;
    }

    public int sumSubarraysMins1(int[] A){
        Stack<Integer> stack=new Stack<>();
        int l=A.length;
        int count=0;

        for (int i = 0; i < l; i++) {
            if (stack.empty()||A[stack.peek()]>A[i]){
                stack.push(i);
            }
            else {
                while (!stack.empty()&&A[stack.peek()]<=A[i]){
                    int t=stack.pop();
                    count+=(i-t-1);
                }
                stack.push(i);
            }

        }
        return count;
    }


    public int suferArea(int[][] grid){
        int[] dr={1,0,-1,0};
        int[] dc={0,1,0,-1};
        int n=grid.length;
        int sum=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]>0)
                    sum+=2;
                for (int k = 0; k < (4); k++) {
                    int ii=i+dr[k];
                    int jj=j+dc[k];
                    int nc=0;
                    if (ii>=0&&ii<n&&jj>=0&&jj<n){
                        nc=grid[ii][jj];
                    }
                    sum+=Math.max(grid[i][j]-nc,0);
                }
                
            }
        }
        return sum;

    }

    public int computeArea(int A,int B,int C,int D,int E,int F,int G,int H){
        int l1=Math.abs(C-A);
        int w1=Math.abs(D-B);
        int l2=Math.abs(G-E);
        int w2=Math.abs(H-F);
        int area1=l1*w1;
        int area2=l2*w2;
        return 0;

    }


    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root==null)
            return root;
        if (root==p||root==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if (left==null)
            return right;
        if (right==null)
            return left;
        if (left==null&&right==null)
            return root;

        return null;
        }


    public void passview(TreeNode root,Stack<TreeNode> stack,List<Stack<TreeNode>> list){
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

    public static void main(String[] args) {
        int[] a={4,2,1,7,1,Integer.MAX_VALUE};
        System.out.println(new TEST().solution1(100));
    }

    public  int solution(int n){
        int sum=0;
        int count=0;
        int i=1;
        while (count<=n){
            count+=i;
            if (count<=n){
                for (int j = 1; j <= i; j++) {
                    sum+=i;
                }
            }
            else break;
            i++;
        }
        count-=i;
        while (count<n){
            sum+=i;
            count++;
        }
        return sum;
    }
    public int solution1(int n){
        if (n<9){
            return 10+n;
        }
        int[] opt=new int[n+1];
        for (int i = 0; i <= (9); i++) {
            opt[i]=i;
        }
        for (int i = 10; i < n+1; i++) {
            int t= (int) Math.pow(i,0.5);
            int min=Integer.MAX_VALUE;
            for (int j = 2; j <= t; j++) {
                int r=i%j;
                int k=i/j;
                if (r==0&&opt[k]!=-1){
                    int t1=opt[j];
                    int t2=opt[k];
                    int l=String.valueOf(t2).length();
                    int tt= (int) (t1*Math.pow(10,l)+t2);
                    min=Math.min(min,tt);
                }
            }
            opt[i] = min==Integer.MAX_VALUE ? -1: min;
        }
        return opt[n];
    }

    public void gameOfLife(int[][] board){
        int[][] pis={{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int n=board.length;
        int m=board[0].length;
        int[][] temp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j]=board[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int oc=0;
                for (int[] pi : pis) {
                    int ii=pi[0]+i;
                    int jj=pi[1]+j;
                    if (ii>=0&&ii<n&&jj>=0&&jj<m){
                        if (temp[ii][jj]==1)
                            oc++;
                    }
                }
                if (temp[i][j]==1){
                    if (oc<2)
                        board[i][j]=0;
                    else if (oc<4)
                        board[i][j]=1;
                    else board[i][j]=0;
                }
                else {
                    if (oc==3)
                        board[i][j]=1;
                }
            }
        }
    }

    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int imax=1;
        int imin=1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                int temp=imin;
                imin=imax;
                imax=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(imax,max);
        }
        return max;
    }

    public int cuttingRope(int n) {
        if (n==2){
            return 1;
        }
        else if (n==2){
            return 2;
        }
        else if (n==4){
            return 4;
        }
        int[] opt=new int[n+1];
        opt[1]=1;
        opt[2]=2;
        opt[3]=3;
        for (int i = 4; i <= n; i++) {
            int imax=0;
            for (int j = 1; j <= i/2; j++) {
                imax=Math.max(imax,opt[j]*opt[i-j]);
            }
            opt[i]=imax;
        }
        return opt[n];
    }

    public int trap(int[] height) {
        if (height==null||height.length==0)
            return 0;
        int n=height.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for (int i = 1; i < left.length; i++) {
            left[i]=Math.max(height[i-1],left[i-1]);
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i]=Math.max(right[i+1],height[i+1]);
        }
        int sum=0;
        for (int i = 1; i < n-1; i++) {
            int min=Math.min(left[i],right[i]);
            if (min>height[i]){
                sum+=(min-height[i]);
            }
        }
        return sum;
    }

    public boolean lemonadeChange(int[] bills) {

        int f=0,t=0;
        for (int bill : bills) {
            if (bill==5){
                f++;
            }
            else if (bill==10){
                if (f<0){
                    return false;
                }
                f--;
                t++;
            }
            else {
                if (f>0&&t>0){
                    f--;
                    t--;
                }
                else if (f>=3)
                    f-=3;
                else
                    return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length())
            return false;
        int l=s1.length();
        int[] map1=new int[26];
        int[] map2=new int[26];
        for (int i = 0; i < l; i++) {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length()-l; i++) {
            if (match(map1,map2)){
                return true;
            }
            map2[s2.charAt(i+l)-'a']++;
            map2[s2.charAt(i)-'a']--;
        }
        return match(map1,map2);
    }
    public boolean match(int[] map1,int[] map2){
        for (int i = 0; i < map1.length; i++) {
            if (map1[i]!=map2[i])
                return false;
        }
        return true;
    }

    public int longestConsecutive(int[] nums) {
        int maxlen=0;
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (!set.contains(i-1)){
                int c=i;
                int clen=1;
                while (set.contains(++c)){
                    clen++;
                }
                maxlen=Math.max(clen,maxlen);
            }
        }
        return maxlen;
    }

    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if (i>=0){
            int j=nums.length-1;
            while (j<i&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);

    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void reverse(int[] nums,int i){
        int j=nums.length-1;
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public boolean canJump(int[] nums) {
        int n=nums.length;
        int c=0; //表示当前最有能到哪？
        for (int i = 0; i < n; i++) {
            if (i<=c){// 当前最远能跳到i 考虑当前最远大 还是从i多跳大
                c=Math.max(c,i+nums[i]);
                if (c>=n-1)
                    return true;
            }
        }
        return false;
    }

}