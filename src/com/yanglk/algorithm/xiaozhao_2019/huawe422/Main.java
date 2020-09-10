package com.yanglk.algorithm.xiaozhao_2019.huawe422;

import java.util.*;

public class Main {
    public static void main1(String[] args) {

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();

            int findex=s.indexOf("5a ");
            int lindex=s.lastIndexOf(" 5a");
            if (findex==-1||lindex==-1){
                System.out.println("");
                continue;
            }
            if (s.equals("5a 5a")){
                System.out.println(s);
                continue;
            }
            s=s.substring(findex+3,lindex);
            if (s.length()==2){
                if (s.equals("00")){
                    System.out.println("5a 00 5a");
                    continue;
                }
                else {
                    System.out.println("5a 5a");
                    continue;
                }
            }

            String[] ss=s.split(" 5a ");
            StringBuffer sb=new StringBuffer();
            Map<Character,Integer> map=new HashMap<>();
            map.put('a',10);
            map.put('b',11);
            map.put('c',12);
            map.put('d',13);
            map.put('e',14);
            map.put('f',15);
            for (int i = 0; i < ss.length; i++) {
                String string=ss[i].substring(0,ss[i].length()-3);
                String[] strings=string.split(" ");
                String len=ss[i].substring(ss[i].length()-2);
                int t1=map.containsKey(len.charAt(0))? map.get(len.charAt(0)):len.charAt(0)-'0';
                int t2=map.containsKey(len.charAt(1))? map.get(len.charAt(1)):len.charAt(1)-'0';
                int c1=(t1)*16+(t2);
                int c=0;
                for (int i1 = 0; i1 < strings.length; i1++) {

                    if (strings[i1].equals("5b")){
                        i1++;
                        if (i1<strings.length&&(strings[i1].equals("bb")||strings[i1].equals("ba"))){
                            c++;
                        }
                    }
                    else {
                        c++;
                    }
                }
                if (c==c1){
                    sb.append(" ");
                    sb.append(ss[i]);
                    sb.append(" 5a");
                }
            }
            if (sb.length()==0){
                System.out.println("5a 5a");
                continue;
            }
            sb.insert(0,"5a");
            System.out.println(sb);
        }


    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int k=sc.nextInt();
//        int[] nums=new int[n];
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> lists=new ArrayList<>();
        bp(2,1,4,list,lists);
        int k=0;
    }
    public static void bp(int k,int j,int n,List<Integer> list,List<List<Integer>> lists){
        if (list.size()==k){
            List<Integer> l=new ArrayList<>();
            l.addAll(list);
            lists.add(l);
            return;
        }
        for (int i = j; i <= n; i++) {
            list.add(i);
            bp(k,i+1,n,list,lists);
            list.remove(list.size()-1);
        }
    }


}
