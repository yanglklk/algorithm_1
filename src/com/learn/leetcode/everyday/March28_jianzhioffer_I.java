package com.learn.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class March28_jianzhioffer_I {
    public static void main(String[] args) {
        new March28_jianzhioffer_I().reverseWords("  hello world!  ");

    }
    public String reverseWords(String s) {
        if (s==null){
            return "";
        }
        List<String>  originals = Arrays.asList(s.split(" "));
        if (originals.isEmpty()){
            return "";
        }
        List<String> original = originals.stream().filter(f -> !"".equals(f)).collect(Collectors.toList());
        if (original.isEmpty()){
            return "";
        }
        StringBuilder reverser = new StringBuilder();
        for (int i = original.size() - 1; i >= 0; i--) {
            reverser.append(original.get(i)+" ");
        }
        return reverser.substring(0,reverser.length()-1);
    }
}
