package com.yanglk.algorithm.xiaozhao_2019.Mogu;

import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Main2 {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(",");
        int[] nums=new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        int[] count=new int[ss.length];
        count[0]=1;
        for (int i = 1; i < nums.length; i++) {
            count[i]=1;
            if (nums[i]>nums[i-1]){
                count[i]=count[i-1]+1;
            }
        }
        int sum=count[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]>nums[i+1]){
                count[i]=Math.max(count[i+1]+1,count[i]);
            }
            sum+=count[i];
        }
        System.out.println(sum);
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int index=0;
        StringBuffer sb=new StringBuffer();
        while (s.length()>0){
            index=s.lastIndexOf(s.charAt(0));
            for (int i =1; i < index; i++){
                index=Math.max(s.lastIndexOf(s.charAt(i)),index);
            }
            s=s.substring(index+1);
            sb.append((index+1)+" ");

        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] chars=sc.nextLine().toCharArray();
        Arrays.sort(chars);
        Set<String> set=new TreeSet<>();
        StringBuffer sb=new StringBuffer();
        int[] vis=new int[chars.length];
        dp(chars,sb,set,vis);
        System.out.println(set);

    }
    public static void dp(char[] chars,StringBuffer sb,Set<String> set,int[] vis){
        if (sb.length()==chars.length){
            String s=sb.toString();
            set.add(s);
            //System.out.println(s);
        }
        for (int i = 0; i < chars.length; i++) {
            if (vis[i]==0){
                sb.append(chars[i]);
                vis[i]=1;
                dp(chars,sb,set,vis);
                vis[i]=0;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }


}

