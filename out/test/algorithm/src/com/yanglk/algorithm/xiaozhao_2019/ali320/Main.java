package com.yanglk.algorithm.xiaozhao_2019.ali320;

import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Main {
    static int  max=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] ss=new String[n];
        Map<Character,Map<Character, String>> map=new TreeMap<>();
        Map<String,Integer> visiter=new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s=sc.next();
            int len=s.length();
            char f=s.charAt(0);
            char l=s.charAt(len-1);
            Map<Character,String> mapi=new TreeMap<>();

            if (!map.keySet().isEmpty()&&map.containsKey(f)){
                mapi=map.get(f);
                if (!mapi.keySet().isEmpty()&&mapi.containsKey(l)){
                    if (l==f){
                        mapi.put(l,s+mapi.get(l));
                    }
                    if (mapi.get(l).length()>len){
                        break;
                    }
                }
            }
            visiter.put(String.valueOf(f)+String.valueOf(l),0);
            mapi.put(l,s);
            map.put(f,mapi);
        }
        int mm=Integer.MIN_VALUE;
        for (Character character : map.keySet()) {
            bp(map,character,visiter,0);
            mm=Math.max(max,mm);
            max=0;
        }
        System.out.println(mm);



    }

    public static void bp(Map<Character,Map<Character, String>> map,char c,Map<String,Integer> visiter,int sum){
        boolean f=false;
        for (Character character : map.keySet()) {
            if (character>=c){
                c=character;
                f=true;
                break;
            }
        }
        if (!f){
            return;
        }
        Map<Character, String> mapi=map.get(c);
        for (Character character : mapi.keySet()) {
            String s=String.valueOf(c)+String.valueOf(character);
            if (visiter.get(s)==0){
                visiter.put(s,1);
                sum+=mapi.get(character).length();
                bp(map,(char) (character),visiter,sum);
                visiter.put(s,0);
                max=Math.max(sum,max);
                sum-=mapi.get(character).length();
            }

        }

    }
}
