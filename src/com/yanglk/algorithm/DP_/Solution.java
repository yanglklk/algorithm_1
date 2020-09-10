package com.yanglk.algorithm.DP_;

import com.sun.javafx.image.BytePixelSetter;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.yanglk.algorithm.offer.Array;
import com.yanglk.algorithm.offer.Str;
import sun.text.resources.cldr.naq.FormatData_naq;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Track;
import java.lang.annotation.ElementType;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
  //      new Solution().rerange(new int[]{2,1,5,3,6,4,8,9,7});
        List<List<String>> r=new Solution().solveNQueens(4);
        System.out.println();
    }
    public int rob(int[] nums) {
        int len=nums.length;
        if (len==0)
            return 0;
        else if (len==1)
            return nums[0];
        else if (len==2)
            return Math.max(nums[0],nums[1]);
        else  {
            int[] opt1=new int[len];
            int[] opt2=new int[len];
            opt1[0]=nums[0];
            opt1[1]=Math.max(nums[0],nums[1]);
            opt2[0] = nums[1];
            opt2[1] = Math.max(nums[1], nums[2]);
            int i=2;
            int j=2;
            while (i<len-1){
                opt1[i]=Math.max(opt1[i-1],opt1[i-2]+nums[i]);
                opt2[j]=Math.max(opt2[j-1],opt2[j-2]+nums[j+1]);
                i++;
                j++;
            }
            return Math.max(opt1[len-2],opt2[len-2]);
        }



    }
    public int change(int amount, int[] coins) {
        if (amount==0)
            return 1;
        if (coins==null||coins.length==0)
            return 0;
        int[][] opt=new int[amount+1][coins.length];
        for (int i = 0; i < opt[0].length; i++) {
            opt[0][i]=1;
        }
        for (int i = 1; i*coins[0] <= (amount); i++) {
            opt[i*coins[0]][0]=1;
        }
        for (int i = 1; i < opt.length; i++) {
            for (int j = 1; j < coins.length; j++) {
                opt[i][j]=opt[i][j-1];
                opt[i][j]+=i-coins[j]>=0 ? opt[i-coins[j]][j]:0;
            }
        }
        return  opt[amount][coins.length-1];
    }
    public static int[] lagestInc(int[] arr){
        int[] opt=new int[arr.length];
        opt[0]=1;
        for (int i = 1; i < opt.length; i++) {
            opt[i]=1;
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i]){
                    opt[i]=Math.max(opt[i],opt[j]+1);
                }
            }
        }
        return opt;
    }
    public static int[] range(int[] arr,int[] opt){
        int max_id=0;
        for (int i = 0; i < arr.length; i++) {
            if (opt[i]>opt[max_id])
                max_id=i;
        }
        int max=opt[max_id];
        int[] list=new int[max];
        list[max-1]=arr[max_id];
        int j=max_id-1;
        int i=max-2;
        while (j>=0){
            if (arr[j]<arr[max_id]&&opt[j]==max-1){
                list[i]=arr[j];
                i--;
                max_id=j;
                max--;
            }
            j--;
        }
        return list;
    }
    public void rerange(int[] arr){
        int[] opt=largeInc1(arr);
        int[] re=range(arr,opt);
        System.out.println(1);
    }
    public static int[] largeInc1(int[] arr){
        int len=arr.length;
        int[] opt=new int[len];
        int[] sort=new int[len];
        int right=0;
        opt[0]=1;
        sort[0]=arr[0];
        int l=0;
        int r=0;
        int m=0;
        for (int i = 1; i < arr.length; i++) {
            l=0;
            r=right;
            while (l<=r){
                m=(l+r)/2;
                if (sort[m]<arr[i])
                    l=m+1;
                else
                    r=m-1;
            }
            //l 表示的是sort中比arr[i]大最左边的位置
            right=Math.max(right,l);
            sort[l]=arr[i];
            opt[i]=l+1;

        }
        return opt;
    }
    public static int getA(){
        int a=10;
        try {
            System.out.println(a/0);
        }
        catch (RuntimeException e){
            a=30;
            return a;
        }
        finally {
            a=40;
            return a;
        }
       // return a;
    }

    public static String largestSub(String str1,String str2){
        int m=str1.length();
        int n=str2.length();
        char[] chars1=str1.toCharArray();
        char[] chars2=str2.toCharArray();
        int[][] opt=new int[m][n];
        boolean f=false;
        for (int i = 0; i < m; i++) {
           if (chars1[i]==chars2[0]){
               for (; i < m; i++) {
                   opt[i][0]=1;
               }
           }
        }
        for (int i = 0; i < n; i++) {
            if (chars2[i]==chars1[0]){
                for (; i < n; i++) {
                    opt[0][i]=1;

                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j]=Math.max(opt[i-1][j],opt[i][j-1]);
                if (chars1[i]==chars2[j]){
                    opt[i][j]=Math.max(opt[i][j],opt[i-1][j-1]+1);
                }
            }
        }
        int i=m-1;
        int j=n-1;
        StringBuilder sb=new StringBuilder();
        while (i>=0&&j>=0){
            if (i>0&&opt[i][j]==opt[i-1][j]){
                i--;
            }
            else if(j>0&&opt[i][j]==opt[i][j-1]){
                j--;
            }
            else {
                sb.insert(0,chars1[i]);
                i--;
                j--;
            }
        }
        return sb.toString();
    }

    public int minDistance(String word1, String word2) {
        char[] chars1=word1.toCharArray();
        char[] chars2=word2.toCharArray();
        int m=chars1.length;
        int n=chars2.length;
        int[][] opt=new int[m+1][n+1];
        opt[0][0]=0;
        for (int i = 1; i <=m; i++) {
            opt[i][0]=i;
        }
        for (int i = 1; i <=n; i++) {
            opt[0][i]=i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars1[i-1]!=chars2[j-1])
                    opt[i][j]=opt[i-1][j-1]+1;
                else opt[i][j]=opt[i-1][j-1];
                opt[i][j]= Math.min(opt[i][j],opt[i-1][j]+1);
                opt[i][j]= Math.min(opt[i][j],opt[i][j-1]+1);
            }
        }
        return opt[m][n];


    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null||s2==null||s3==null)
            return false;
        char[] chars1=s1.toCharArray();
        char[] chars2=s2.toCharArray();
        char[] chars3=s3.toCharArray();
        int m=s1.length();
        int n=s2.length();
        int l=s3.length();
        if (m+n!=l)
            return false;
        boolean[][] opt=new boolean[m+1][n+1];
        opt[0][0]=true;
        for (int i = 1; i < (m + 1); i++) {
            if (chars1[i-1]!=chars3[i-1])
                break;
            opt[i][0]=true;
        }
        for (int i = 1; i < (n + 1); i++) {
            if (chars2[i-1]!=chars3[i-1])
                break;
            opt[0][i]=true;
        }
        for (int i = 1; i < (m + 1); i++) {
            for (int j = 1; j < (n+1); j++) {
                if (opt[i-1][j]&&chars1[i-1]==chars3[j+i-1]
                        ||opt[i][j-1]&&chars2[j-1]==chars3[i+j-1])
                opt[i][j]=true;
            }
        }
        return opt[m][n];

    }

    public int numDistinct(String s, String t) {
        char[] chars1=s.toCharArray();
        char[] chars2=t.toCharArray();
        int m=s.length();
        int n=t.length();
        if (n>m)
            return 0;
        int[][] opt=new int[n+1][m+1];
        for (int i = 0; i <= m; i++) {
            opt[0][i]=1;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chars1[j-1]==chars2[i-1]){
                    opt[i][j]=opt[i-1][j-1]+opt[i][j-1];
                }
                else
                opt[i][j]=opt[i][j-1];
            }
        }
        return opt[n][m];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] opt=new int[m][n];
        opt[m-1][n-1]=dungeon[m-1][n-1]>0? 1:-dungeon[m-1][n-1]+1;
        for (int i = m-2; i >= 0; i--) {
            opt[i][n-1]=Math.max(opt[i+1][n-1]-dungeon[i][n-1],1);
        }
        for (int i = n-2; i >= 0; i--) {
            opt[m-1][i]=Math.max(opt[m-1][i+1]-dungeon[m-1][i],1);
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int down=Math.max(opt[i][j+1]-dungeon[i][j],1);
                int right=Math.max(opt[i+1][j]-dungeon[i][j],1);
                opt[i][j]=Math.min(down,right);
            }
        }
        return opt[0][0];
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] opt=new int[m][n];
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i*j==0){
                    opt[i][j]=matrix[i][j]-'0';
                }
                else if(matrix[i][j]=='1'){
                    opt[i][j]=Math.min(opt[i-1][j], Math.min(opt[i][j-1],opt[i-1][j-1]))+1;
                    max=Math.max(opt[i][j],max);
                }
                else opt[i][j]=0;
            }
        }
        return max*max;

    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] opt=new int[m][n];
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i*j==0){
                    opt[i][j]=matrix[i][j]-'0';
                }
                else if(matrix[i][j]=='1'){
                    opt[i][j]=Math.min(opt[i-1][j], Math.min(opt[i][j-1],opt[i-1][j-1]))+1;
                    max=Math.max(opt[i][j],max);
                }
                else opt[i][j]=0;
            }
        }
        return max*max;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n==0)
            return 1;
        if (n==1)
            return 9;
        int c=9;
        int sum=c+1;
        for (int i = 2; i <= Math.min(n,10); i++) {
           c=c*(11-i);
           sum+=c;
        }
        return sum;
    }

    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        return f(piles,0,n-1)>s(piles,0,n-1);
    }
    public int f(int[] piles,int i,int j){
        if (i==j)
            return piles[i];
        return Math.max(piles[i]+s(piles,i+1,j),piles[j]+s(piles,i,j-1));
    }
    public int s(int[] piles,int i,int j){
        if (i==j)
            return 0;
        return Math.min(f(piles,i+1,j),f(piles,i,j-1));
    }
    public boolean stoneGame1(int[] piles) {
        int n=piles.length;
        int[][] f=new int[n][n];
        int[][] s=new int[n][n];
        for (int j = 0; j < n; j++) {
            f[j][j]=piles[j];
            for (int i=j-1;i>=0;i--){
                f[i][j]=Math.max(piles[i]+s[i+1][j],piles[j]+s[i][j-1]);
                s[i][j]=Math.min(f[i][j-1],f[i+1][j]);
            }
        }
        return f[0][n-1]<s[0][n-1];
    }

    public boolean divisorGame(int N) {
        return N%2==0;
    }

    public int countSquares(int[][] matrix) {
        if (matrix==null||matrix.length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] opt=new int[m][n];
        int sum=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i*j==0){
                    opt[i][j]=matrix[i][j];
                }
                else if (matrix[i][j]==1){
                    opt[i][j]=Math.min(opt[i-1][j],Math.min(opt[i][j-1],opt[i-1][j-1]))+1;
                }
                else opt[i][j]=0;
                sum+=opt[i][j];
            }
        }
        return sum;
    }

    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum+nums[i]<nums[i]){
                sum=nums[i];
            }
            sum+=nums[i];
            max=Math.max(max,sum);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0)
            return 0;
        int max=0;
        int min=prices[0];
        for (int i = 1; i < prices.length; i++) {
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;

    }

    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] record=new int[n];
        List<String> list=new ArrayList<>();
        backtrack(record,0,n,list);
        return res;
    }
    public void backtrack(int[] record, int i, int n, List<String> list){
        if (list.size()==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++) {
            char[] c=new char[n];
            Arrays.fill(c,'.');
            StringBuilder sb=new StringBuilder(String.valueOf(c));
            if (valid(record,i,j)){
                record[i]=j;
                sb.setCharAt(j,'Q');
                list.add(sb.toString());
                backtrack(record,i+1,n,list);
                list.remove(sb.toString());
            }
        }
    }
    public boolean valid(int[] record,int i,int j){
        for (int k = 0; k < i; k++) {
            if (record[k]==j||Math.abs(record[k]-j)==Math.abs(k-i))
                return false;
        }
        return true;
    }








    }
