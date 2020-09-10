package com.yanglk.algorithm.xiaozhao_2019.zhaohang429;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                nums[i][j]=sc.nextInt();
            }
        }
        if (n<1){
            System.out.println(0);
            return;
        }
        int[][] opt=new int[n][n];
        opt[0][0]=nums[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0){
                    opt[i][j]=opt[i-1][j];
                }
                else if (j==i){
                    opt[i][j]=opt[i-1][j-1];
                }
                else {
                    opt[i][j]=Math.max(opt[i-1][j],opt[i-1][j-1]);
                }
                opt[i][j]+=nums[i][j];
            }
        }
        Arrays.sort(opt[n-1]);
        System.out.println(opt[n-1][n-1]);
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[2*n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i]=sc.nextInt();
        }
        int c=minSwapsCouples(nums);
        System.out.println(c);
    }

    public static int minSwapsCouples(int[] row) {
        int[] index=new int[row.length];
        for (int i = 0; i < row.length; i++) {
            index[row[i]]=i;
        }
        int c=0;
        for (int i = 0; i < row.length; i=i+2) {
            if (row[i]%2==0){
                if (row[i+1]==row[i]+1){
                    continue;
                }
                else {
                    int point1=i+1;
                    int point2=index[row[i]+1];
                    int temp=row[point1];
                    row[point1]=row[point2];
                    row[point2]=temp;
                    index[row[point1]]=point1;
                    index[row[point2]]=point2;
                    c++;
                }
            }
            else {
                if (row[i+1]==row[i]-1){
                    continue;
                }
                else {
                    int point1=i+1;
                    int point2=index[row[i]-1];
                    int temp=row[point1];
                    row[point1]=row[point2];
                    row[point2]=temp;
                    index[row[point1]]=point1;
                    index[row[point2]]=point2;
                    c++;
                }

            }
        }
        return c;
    }


}
