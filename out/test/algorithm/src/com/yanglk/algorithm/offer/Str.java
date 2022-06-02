package com.yanglk.algorithm.offer;

import javax.lang.model.SourceVersion;
import javax.lang.model.util.ElementScanner6;
import java.util.*;

public class Str {
    public static void main(String[] args) {
        String s="aa";
        System.out.println(new Str().Permutation(s));

    }
    public boolean match(char[] str, char[] pattern)
    {
        int i=0;
        int j=0;
        char p='\0';
        while (i<str.length&&j<pattern.length) {
            if (j+1<pattern.length&&pattern[j]!='*'){
                if (str[i]==pattern[j]||pattern[j]=='.'){
                    i++;
                    j++;
                }
                else return false;
            }
            else if (j+1<pattern.length&&pattern[j]=='*'){
                if (str[i]!=pattern[j]){
                    i++;
                    j=j+2;
                }

            }


            else {
                if (pattern[j]=='.'){
                    i++;
                    j++;
                }
                else if (j<pattern.length-1&&pattern[j+1]=='*'){
                    i++;
                    j=j+2;
                }
                else
                    return false;
            }

        }
        return i==str.length;

    }

    public int StrToInt(String str) {
        if (str==null||str.length()==0)
            return 0;
        int num=0;
        int i=0;
        char[] c=str.toCharArray();
        boolean flag=false;
        if (c[0]=='-'){
            flag=true;
            i++;
        }
        else if (c[0]=='+'){
            flag=false;
            i++;
        }
        while (i<c.length&&c[i]>='0'&&c[i]<='9'){
                num=num*10+(c[i]-'0');

                if (num==Integer.MIN_VALUE&&(i+1)==c.length&&flag){
                    return num;
                }
                if (num<0)
                    return 0;
                i++;
        }


        if (i==c.length){
            if (flag)
                return -num;
            return num;
        }
        else
            return 0;

    }

    public String LeftRotateString(String str,int n) {
        int len;
        if (str==null||(len=str.length())==0){
            return str;
        }
        int k=n%len;
        String sb1=str.substring(0,k);
        String sb2=str.substring(k);
        String s=sb2+sb1;
        return s;
    }

    public String ReverseSentence(String str) {
        int len;
        if (str==null||(len=str.length())==0){
            return str;
        }
        Stack<String> stack=new Stack<>();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i)==' '){
                stack.push(sb.toString());
                sb=new StringBuffer();
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        stack.push(sb.toString());
        sb=new StringBuffer();
        while (!stack.empty()){
            sb.append(stack.pop());
            if (!stack.empty())
                sb.append(" ");
        }
        return sb.toString();
    }

    public boolean isNumeric(char[] str) {

        String s=String.valueOf(str);
        int len=1;
        if (s.contains("e")||s.contains("E"))
            len=2;
        String[] ss=s.split("e");
        if (ss.length==1){
            ss=s.split("E");
        }
        if (ss.length<=0||ss.length>2)
            return false;

        try {
            Double.parseDouble(ss[0]);
        }
        catch (Exception e){
            return false;
        }
        if (len==1&&ss.length==1)
            return true;
        if (ss.length==2&&len==2){
            try {
                Integer.parseInt(ss[1]);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
        return false;
    }

    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        char[] c=str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!map.keySet().contains(c[i])){
                map.put(c[i],i);
                list.add(i);
            }
            else {
                list.remove(new Integer(map.get(c[i])));
            }
        }

        if (list.size()>0)
            return list.get(0);
        return -1;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        char[] c=str.toCharArray();
        Arrays.sort(c);
        boolean[] flag=new boolean[c.length];
        StringBuffer sb=new StringBuffer();
        rPermutation1(c,flag,list,sb);
        return  list;


    }
    public void rPermutation1(char[] c,boolean[] flag,ArrayList<String> list,StringBuffer sb) {
        int i=0;
        while (i<c.length){
            if (sb.length()==c.length){
                if (!list.contains(new String(sb.toString())))
                    list.add(new String(sb.toString()));
                return;
            }
            if (!flag[i]){
                sb.append(c[i]);
                flag[i]=!flag[i];
            }
            else {
                i++;
                continue;
            }
            rPermutation1(c,flag,list,sb);
            flag[i]=!flag[i];
            sb.deleteCharAt(sb.length()-1);
            i++;
        }
    }

    public String PrintMinNumber(int [] numbers) {
        if (numbers==null||numbers.length==0)
            return "";
        int len=numbers.length;
        String[] str=new String[len];
        for (int i = 0; i < numbers.length; i++) {
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String temp1=o1+o2;
                String temp2=o2+o1;
                return temp1.compareTo(temp2);
            }
        });
        StringBuffer sb=new StringBuffer();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();

    }
}
