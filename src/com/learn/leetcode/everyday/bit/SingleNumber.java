package com.learn.leetcode.everyday.bit;

import com.test.designmodel.decorator.Decorator;

import java.util.*;
import java.util.stream.Collectors;

public class SingleNumber {

    public static void main(String[] args) {
        // new SingleNumber().findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(new SingleNumber().rangeBitwiseAnd(5, 7));
    }
    public int singleNumber(int[] nums) {
        int c =nums[0];
        for (int i = 1; i < nums.length; i++) {
            c = c^nums[i];
        }
        return c;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> result = new HashMap<>();
        int n = s.length();
        if (n <=10){
            return new ArrayList<>();
        }
        String match = null;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n-10; i++) {
            match = s.substring(i,i+10);
            Integer orDefault = result.getOrDefault(match, 0);
            result.put(match, orDefault+1);
        }
        return result.entrySet().stream().filter(f->f.getValue()>=2).map(f->f.getKey()).collect(Collectors.toList());

    }

    public int rangeBitwiseAnd(int left, int right) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        while (left!=0){
            if ((left&1)==1){
                s1.append(1);
            }else {
                s1.append(0);
            }
            left= left>>1;
        }

        while (s1.length()<=31){
            s1.append(0);
        }
        s1 = s1.reverse();

        while (right!=0){
            if ((right&1)==1){
                s2.append(1);
            }else {
                s2.append(0);
            }
            right= right>>1;
        }

        while (s2.length()<=31){
            s2.append(0);
        }
        s2 = s2.reverse();

        int i = 0;
        int c = 0;
        while (i<32){
            if (s1.charAt(i)!=s2.charAt(i)){
                break;
            }else {
               c+= Integer.valueOf(s1.charAt(i)-'0')*(Math.pow(2,31-i));
            }
            i++;
        }

        return c;
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int m = nums.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
           sum+= nums[i]%2==0? nums[i]:0;
        }
        int i =0;
        for (int[] query : queries) {
            int index = query[1];
            int val = query[0];
            int newVal = nums[index]+val;
            int oldVal = nums[index];
            if (oldVal%2==0 && newVal%2==0){
                sum-=oldVal;
                sum+=newVal;
            }
            else if (oldVal%2!=0 && newVal%2==0){
                sum+=newVal;
            }
            else if (oldVal%2==0 && newVal%2!=0){
                sum-=oldVal;
            }
            nums[index] = newVal;
            res[i++]=sum;
        }
        return res;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        StringBuffer sb= new StringBuffer();
        String[] strings = sentence.split(" ");
        Map<String,String> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)){
                sb.append(map.get(string));
                sb.append(" ");
                continue;
            }
            boolean match = false;
            for (String dic : dictionary) {
                if (dic.length()<=string.length()){
                    if (string.substring(0,dic.length()).equals(dic)){
                       sb.append(dic);
                       sb.append(" ");
                       map.put(string,dic);
                       match =true;
                       break;
                    }
                }
            }
            if (!match){
                sb.append(string);
                sb.append(" ");
            }
        }
        sb.deleteCharAt( sb.length()-1);
        return sb.toString();
    }

    public String replaceWords1(List<String> dictionary, String sentence) {
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Set<String> set = new HashSet<>(dictionary);
        StringBuffer sb= new StringBuffer();
        String[] strings = sentence.split(" ");
        for (String word : strings) {
            boolean match = false;
            for (int i = 1; i <= word.length(); i++) {
                if (set.contains(word.substring(0,i))){
                    sb.append(word.substring(0,i));
                    sb.append(" ");
                    match = true;
                    break;
                }
            }

            if (!match){
                sb.append(word);
                sb.append(" ");
            }
        }
        sb.deleteCharAt( sb.length()-1);
        return sb.toString();
    }
}
