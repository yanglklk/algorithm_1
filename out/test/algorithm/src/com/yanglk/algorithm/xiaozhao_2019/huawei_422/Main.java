package com.yanglk.algorithm.xiaozhao_2019.huawei_422;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i < n; i++) {
                nums[i]=sc.nextInt();
            }
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                String[] ss=sc.nextLine().split(" ");
                int a=Integer.parseInt(ss[1]);
                int b=Integer.parseInt(ss[2]);
                if (ss[0].equals("Q")){
                    int max=Integer.MIN_VALUE;
                    int aa=Math.min(a,b);
                    int bb=Math.max(a,b);
                    for (int k = aa; k <= bb; k++) {
                        max=Math.max(max,nums[k-1]);
                    }
                    System.out.println(max);
                }
                else {
                    nums[a-1]=b;
                }
            }
        }

    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> map=new HashMap<>();
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        map.put("A",14);
        map.put("2",15);
        map.put("joker",16);
        map.put("JOKER",17);
        String[] ss=sc.nextLine().split("-");
        String l=ss[0];
        String r=ss[1];
        String[] ls=l.split(" ");
        String[] rs=r.split(" ");
        if (ls.length==2){
            if (ls[0].equals("joker")&&ls[1].equals("JOKER")){
                System.out.println(l);
                return;
            }
        }
        if (rs.length==2){
            if (rs[0].equals("joker")&&rs[1].equals("JOKER")){
                System.out.println(r);
                return;
            }
        }
        if (ls.length==rs.length){
            int lsum=0;
            int rsum=0;
            for (int i = 0; i < ls.length; i++) {
                if (map.containsKey(ls[i])){
                    lsum+=map.get(ls[i]);
                }
                else {
                    lsum+=ls[i].charAt(0)-'0';
                }

                if (map.containsKey(rs[i])){
                    rsum+=map.get(rs[i]);
                }
                else {
                    rsum+=rs[i].charAt(0)-'0';
                }

            }

            if (lsum>rsum){
                System.out.println(l);
            }
            else {
                System.out.println(r);
            }
        }
        else {
            if (ls.length==4||rs.length==4){
                if (ls.length==4){
                    System.out.println(l);
                }
                if (rs.length==4){
                    System.out.println(r);
                }
            }
            else{
                System.out.println("ERROR");
            }
        }


    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        dp(0,0,3,new StringBuffer(),list);
        System.out.println(list);
    }
    public static void dp(int l, int r, int n, StringBuffer sb, List<String> list){
        if (l==n&&r==n){
            String s=sb.toString();
            list.add(s);
        }
        if (l<n){
            sb.append("{");
            dp(l+1,r,n,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
        if (r<l){
            sb.append("}");
            dp(l,r+1,n,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int key=s.charAt(i)-'0';
                if (map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }
                else {
                    map.put(key,1);
                }
            }
        }
        StringBuffer sb=new StringBuffer();
        for (Integer key : map.keySet()) {
            for (java.lang.Integer c = 0; c < map.get(key); c++) {
                sb.append(key);
            }
        }
        System.out.println(sb);
    }

}
