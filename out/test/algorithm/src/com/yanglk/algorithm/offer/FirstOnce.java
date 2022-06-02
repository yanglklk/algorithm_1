package com.yanglk.algorithm.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FirstOnce {

    public static void main(String[] args) {
        FirstOnce fo=new FirstOnce();
        char[] c={'g','o','o','g','l','e'};
        for (char c1 : c) {
            fo.Insert(c1);
            System.out.println(fo.FirstAppearingOnce());
        }

    }
    Set<Character> set=new HashSet<>();
    ArrayList<Character> l=new ArrayList<>();

    public void Insert(char ch)
    {
        if (!set.contains(ch)){
            set.add(ch);
            l.add(ch);
        }
        else {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i)==ch){
                    l.remove(i);
                    break;
                }
            }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (l.size()==0)
            return '#';
        return l.get(0);
    }
}
