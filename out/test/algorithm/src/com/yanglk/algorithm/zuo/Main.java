package com.yanglk.algorithm.zuo;

import java.security.PublicKey;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] nums=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               nums[i][j]=sc.nextInt();
            } 
        }
        for (int j = m-1,i = 0; j >= 0&&i < n; ) {
                if (nums[i][j]==k){
                    System.out.println("Yes");
                    return;
                }
                else if (nums[i][j]>k){
                    j--;
                }
                else {
                    i++;
                }
        }
        System.out.println("No");
    }
}
class Main1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int len=0;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            int max=nums[i];
            int min=nums[i];
            for (int j = i; j < n; j++) {
                if (set.contains(nums[j])){
                    break;
                }
                set.add(nums[j]);
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
                if ((max-min)==(j-i)){
                    len=Math.max(len,j-i+1);
                }
            }
            set.clear();
        }
        System.out.println(len);
    }

}
class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int l=0,r=n-1;
        while (l<r){
            if (nums[l]+nums[r]==k){
                System.out.println(nums[l]+","+nums[r]);
                while (l<r&&nums[l]==nums[++l]);
                while (l<r&&nums[r]==nums[--r]);
            } else if (nums[l]+nums[r]>k) {
                while (l<r&&nums[r]==nums[--r]);
            }
            else {
                while (l<r&&nums[l]==nums[++l]);
            }
        }
    }
}
class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < n-2; i++) {
            if (i==0||nums[i]!=nums[i-1])
                pp(nums,i,n,k);
        }

    }
    public static void pp(int[] nums,int s,int n,int kk){
        int l=s+1,r=n-1;
        int k=kk-nums[s];
        while (l<r){
            if (nums[l]+nums[r]<k){
                l++;
            } else if (nums[l]+nums[r]>k) {
                r--;
            }
            else {
                if (l == 0 || nums[l] == nums[l - 1]) {
                    System.out.println(nums[s] + " " + nums[l] + " " + nums[r]);
                }
                l++;
                r--;
            }
        }
    }


}
class Main4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int l=0;
        int r=0;
        int sum=nums[0];
        int len=1;
        while (r<n){
            if (sum==k){
                len=Math.max(len,r-l+1);
                sum-=nums[l++];
            }
            else if (sum<k){
                r++;
                if (r==n)
                    break;
                sum+=nums[r];
            }
            else {
                sum-=nums[l];
                l++;
            }
        }
        System.out.println(len);

    }
}
