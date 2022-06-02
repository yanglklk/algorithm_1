package com.yanglk.algorithm.xiaozhao_2019.huyu;

import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] ss;
        String s;
        for (int i = 0; i < n; i++) {
            s=sc.nextLine();
            ss=s.split(":");
            int h=Integer.parseInt(ss[0]);
            int f=Integer.parseInt(ss[1]);
            int m=Integer.parseInt(ss[2]);
            boolean flag=false;
            if (h>24){
                h=h%10;
                System.out.print("0"+String.valueOf(h)+":");
            }
            else {
                System.out.print(ss[0]+":");
            }
            if (f>=60){
                flag=true;
                f=f%10;
                System.out.print("0"+String.valueOf(f)+":");
            }
            else {
                System.out.print(ss[1]+":");
            }
            if (m>=60){
                flag=true;
                m=m%10;
                System.out.println("0"+String.valueOf(m));
            }
            else {
                System.out.println(ss[2]);
            }


        }

    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k=sc.nextInt();
            List<Integer> list=new LinkedList<>();
            for (int i1 = 0; i1 < k; i1++) {
                int t=sc.nextInt();
                if (list.contains(t)){
                    list.remove(Integer.valueOf(t));
                }
                list.add(0,t);

            }
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
        
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int row,col;
            String[] ss=sc.nextLine().split(" ");
            row=Integer.parseInt(ss[0]);
            col=Integer.parseInt(ss[1]);
            char[][] board=new char[row][col];
            for (int i1 = 0; i1 < row; i1++) {
                board[i1]=sc.nextLine().toCharArray();
            }
            String target=sc.nextLine();
            System.out.println(dfs(board,target,row,col));

        }

    }
    public static int dfs(char[][] board,String target,int row,int col){
        int[][] pis={{0,1},{1,0},{1,1}};
        char first=target.charAt(0);
        int count=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]==first){
                    for (int[] p : pis) {
                        int c=1;
                        for (int i1 = 1; i1 < target.length(); i1++) {
                            int ii=i+p[0]*i1;
                            int jj=j+p[1]*i1;
                            if (ii<row&&jj<col&&board[ii][jj]==target.charAt(i1)){
                               c++;
                            }
                            else break;
                        }
                        if (c==target.length()){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] map=new int[26];
        for (int i = 0; i < (26); i++) {
            map[i]=sc.nextInt();
        }
        String s=sc.next();
        int c=0;
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            sum+=map[s.charAt(i)-'a'];
            if (sum>100){
                c++;
                i--;
                sum=0;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");

        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            int t =Integer.parseInt(ss[i]);
            if (map.keySet().contains(t)){
                map.put(t,map.get(t)+1);
            }
            else {
                map.put(t,1);
            }
        }
        int sum=0;

        for (Integer key : map.keySet()) {
            if (key==0){
                sum++;
            }
            else {
                int k= (int) Math.ceil(map.get(key)/(key+1.0));
                sum+=(k*(key+1));
            }
        }
        System.out.println(sum);

    }
}
