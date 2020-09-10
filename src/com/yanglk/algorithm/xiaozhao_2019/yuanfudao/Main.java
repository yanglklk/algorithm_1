package com.yanglk.algorithm.xiaozhao_2019.yuanfudao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        float m=sc.nextFloat();
        Stack<List<Integer>> stack=new Stack<>();
        int k= (int) Math.ceil(n/m);
        for (int i = 0; i < k; i++) {
            List<Integer> l=new ArrayList<>();
            int j=0;
            while (j<m&&j+i*m<n){
                l.add(sc.nextInt());
                j++;
            }
            stack.push(l);
        }
        while (!stack.empty()){
            List<Integer> l=stack.pop();
            for (Integer integer : l) {
                System.out.print(integer+" ");
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        String s=sc.nextLine();
        int l=(s.length()-1)/3;
        int j=0;
        for (int i = l; i > 0; i--) {
            for (int i1 = 0; i1 < l-i; i1++) {
                System.out.print(" ");
            }
            System.out.print(s.charAt(j++));
            for (int i1 = 0; i1 < 2*i-1; i1++) {
                System.out.print(" ");
            }
            System.out.println(s.charAt(j++));
        }
        for (int i = 0; i < (l + 1); i++) {
            for (int i1 = 0; i1 < l; i1++) {
                System.out.print(" ");
            }
            System.out.println(s.charAt(j++));
        }


    }
}
