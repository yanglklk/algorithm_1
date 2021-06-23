package com.learn.leetcode.everyday.june;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class June21_offer38 {
    public static void main(String[] args) {
        June21_offer38 june21_offer38 = new June21_offer38();
        for (String abcd : june21_offer38.permutation("abcd")) {
            System.out.println( abcd);
        }
    }
    public String[] permutation(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        bfs(chars,set, new int[n],n,new StringBuilder());
        String[] result = new String[set.size()];
        return set.stream().collect(Collectors.toList()).toArray(result);
    }
    public void bfs(char[] chars,Set set,int[] vis,int n,StringBuilder sb){
        if (sb.length()==n){
            set.add(sb.toString());// 每次sb.toString()是不同的对象
            return;
        }
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                sb.append(chars[i]);
                vis[i] = 1;
                bfs(chars,set,vis,n,sb);
                sb.deleteCharAt(sb.length()-1); //这里是要去掉字符串最后一位
                vis[i] = 0;
            }
        }
    }
}
