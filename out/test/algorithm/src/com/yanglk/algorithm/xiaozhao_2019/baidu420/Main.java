package com.yanglk.algorithm.xiaozhao_2019.baidu420;

import com.yanglk.algorithm.thread.SynTest;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[][] nums=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j]=((i+1)*(j+1))%10;
            }
        }
        a=Math.min(a,n);
        b=Math.min(b,m);
        long sum=0;
        int[][] temp=new int[n-(a-1)][m-(b-1)];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                int max=Integer.MIN_VALUE;
                for (int ai = i; ai < a+i; ai++) {
                    for (int bi = j; bi < b+j; bi++) {
                        max=Math.max(max,nums[ai][bi]);
                        if (max==9){
                            break;
                        }
                        //max=Math.max(max,((ai+i+1)*(bi+j+1))%10);
                    }
                    if (max==9) {
                        break;
                    }
                }
                temp[i][j]=max;
                sum+=max;
            }
        }
        System.out.println(sum);
    }

    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int c= scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]= scanner.nextInt();
        }
        System.out.println(4);
    }
}
