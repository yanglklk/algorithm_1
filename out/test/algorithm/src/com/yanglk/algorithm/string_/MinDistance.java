package com.yanglk.algorithm.string_;

import java.util.*;

public class MinDistance {
    public MinDistance() {
    }

    public static void main(String[] args) {
        String[] ss={"1","3","3","3","2","3","1"};
        MinDistance md=new MinDistance();
        System.out.println(md.minDistances1(ss,"1","3"));
    }
    public int minDistance(String[] strs,String s1,String s2){
        if (strs==null||strs.length<2||s1==null||s2==null)
            return -1;

        int id1=-1;
        int id2=-1;
        int min=Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {


            if (strs[i].equals(s1)){
                id1=i;
                if (id2!=-1){
                   min=Math.min(min,i-id2);

                }
            }
            if (strs[i].equals(s2)){
                id2=i;
                if (id1!=-1){
                    min=Math.min(min,i-id1);
                }
            }
        }
        if (id1==-1||id2==-1)
            return -1;
        return min;
    }

    public int minDistances(String[] strs,String s1,String s2){
        if (strs==null||strs.length<2||s1==null||s2==null)
            return -1;

        int id1=-1;
        int id2=-1;
        int min=Integer.MAX_VALUE;
        HashMap<String,HashMap<String,Integer>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<String,Integer> map1=new HashMap<>();
            if (!map.containsKey(strs[i])){
                map.put(strs[i],new HashMap<String, Integer>());
                for (int i1 = i+1; i1 < strs.length; i1++) {
                    if(map1.get(strs[i1])!=null||strs[i]==strs[i1]){
                        continue;
                    }
                    else {
                        map1.put(strs[i1],i1-i);
                        map.put(strs[i],map1);
                    }
                }

            }
            else {
                map1=map.get(strs[i]);
                for (int i1 = i+1; i1 < strs.length; i1++) {
                    if(strs[i]==strs[i1]){
                        continue;
                    }
                    if(map1.containsKey(strs[i1])){
                        int m1=map1.get(strs[i1]);
                        int m2=i1-i;
                        map1.put(strs[i1],Math.min(m1,m2));
                    }
                    else {
                        map1.put(strs[i1],i1-i);
                        map.put(strs[i],map1);
                    }
                }
            }


            map.put(strs[i],map1);

        }
        if (id1==-1||id2==-1)
            return -1;
        return min;
    }

    public int minDistances1(String[] strs,String s1,String s2){
        int min=0;
        if (strs==null||strs.length<2||s1==null||s2==null)
            return -1;

        List<String> set=new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (!set.contains(strs[i]))
                set.add(strs[i]);
        }

        HashMap<String,HashMap<String,Integer>> map=new HashMap<>();

        for (int i = 0; i < set.size(); i++) {
            HashMap<String,Integer> map1=new HashMap<>();
            s1=set.get(i);
            for (int i1 = 0; i1 < set.size(); i1++) {
                s2=set.get(i1);

                if (s1.equals(s2)){
                    continue;
                }
                int id1=-1;
                int id2=-1;
                min=Integer.MAX_VALUE;
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].equals(s1)){
                        id1=j;
                        if (id2!=-1){
                            min=Math.min(min,j-id2);
                        }
                    }
                    if (strs[j].equals(s2)){
                        id2=j;
                        if (id1!=-1){
                            min=Math.min(min,j-id1);
                        }
                    }
                }
                map1.put(set.get(i1),min);
            }
            map.put(set.get(i),map1);

        }

        return min;
    }

}
