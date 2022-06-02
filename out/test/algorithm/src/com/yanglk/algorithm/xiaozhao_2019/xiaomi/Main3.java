package com.yanglk.algorithm.xiaozhao_2019.xiaomi;

import com.yanglk.algorithm.offer.Array;
import com.yanglk.algorithm.offer.Str;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.math.BigInteger;
import java.util.*;

public class Main3 {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        int[] sum=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Stack<Integer> stack=new Stack<>();
        int k=1;
        sum[0]=1;
        for (int i = 1; i < nums.length; i++) {
            sum[i]=1;
            if (nums[i]>nums[i-1]){
                sum[i]=sum[i-1]+1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]>nums[i+1]){
                sum[i]=Math.max(sum[i],sum[i+1]+1);
            }
        }
        int s=0;
        for (int i : sum) {
            s+=i;
        }
        System.out.println(s);
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        char[] chars=ss[0].toCharArray();
        int k=Integer.parseInt(ss[1]);
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            while (!stack.empty()&&chars[i]>stack.peek()&&k>0){
                k--;
                stack.pop();
            }
            stack.push(chars[i]);
        }
        StringBuffer sb=new StringBuffer();
        while (!stack.empty()){
            if (k<=0){
                sb.append(stack.peek());
            }
            stack.pop();
            k--;
        }
        System.out.println(sb.reverse());
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Character> stack=new Stack<>();
        int c=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='['){
                stack.add(s.charAt(i));
            }
            if (s.charAt(i)==']'){
               c=Math.max(c,stack.size());
               stack.pop();
            }
        }
        System.out.println(c);
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int m=s.split("],").length;
        int n=sc.nextInt();
        int k=sc.nextInt();
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        s=s.substring(2);
        for (int i = 0; i < m; i++) {
            int l=s.indexOf(']');
            String[] si =s.substring(0,l).split(",");
            int f=Integer.parseInt(si[0]);
            int t=Integer.parseInt(si[1]);
            int w=Integer.parseInt(si[2]);
            if (map.keySet().contains(f)){
                Map<Integer,Integer> mapi=map.get(f);
                if (mapi.get(t)>w){
                    mapi.put(t,w);
                }

            }
            else {
                Map<Integer,Integer> mapi=new HashMap<>();
                mapi.put(t,w);
                map.put(f,mapi);
            }
            s=s.substring(Math.min(l+3,s.length()));
        }

        System.out.println(djk(k,n,map));
    }
    public static Map initDis(Map<Integer,Integer> distances,int n,int k){
        distances.put(k,0);
        for (int i = 1; i <= n; i++) {
            if (i!=k){
                distances.put(i,Integer.MAX_VALUE);
            }
        }
        return distances;
    }
    public static int djk(int k,int n,Map<Integer,Map<Integer,Integer>> map){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int ti=0;
        if (map.containsKey(k)){
            ti=map.get(k).containsKey(k)? map.get(k).get(k):0;
        }
        pq.add(new Pair(ti,k));
        Set<Integer> vit=new HashSet<>();
        Map<Integer,Integer> parent=new HashMap<>();
        Map<Integer,Integer> distances=new HashMap<>();
        distances=initDis(distances,n,k);
        while (!pq.isEmpty()){
            Pair p=pq.poll();
            int tt=p.t;
            int ww=p.w;
            if (vit.contains(tt))
                continue;
            vit.add(tt);
            if (map.containsKey(tt)){
                Set<Integer> neighbors=map.get(tt).keySet();
                for (Integer nei : neighbors) {
                    if (!vit.contains(nei)){
                        int d=map.get(tt).get(nei);
                        if (d+ww<distances.get(nei)){
                            parent.put(nei,tt);
                            distances.put(nei,d+ww);
                            pq.add(new Pair(d+ww,nei));
                        }
                    }
                }
            }

        }
        int max=0;
        for (int i = 1; i <= n; i++) {
          if (distances.get(i)==Integer.MAX_VALUE){
             return -1;
          }
          else {
              max=Math.max(max,distances.get(i));
          }
        }
        return max;
    }

    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        String s=sc.nextLine();
        //List<String> sbb=new ArrayList<>();
        StringBuffer sbb=new StringBuffer();
        for (int i = 0; i < m; i++) {
            ss=sc.nextLine().split(" ");
            if (ss[0].equals("1")){
                int k=n-Integer.parseInt(ss[1]);
                String sb=s.substring(k);
                s=sb+s.substring(0,k);
            }
            else{
                System.out.println(s.charAt(Integer.parseInt(ss[1])));
            }
        }


    }

    public static void main6(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] nums=new int[4];
        for (int i = 0; i < (4); i++) {
            nums[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        Set<Integer> set=new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        int k=dfs(set,nums,m,0,0)? 1:0;

    }

    public static boolean dfs(Set<Integer> set,int[] nums,int m,int p,int n){
        if (set.isEmpty()){
            return p+n==m;
        }
        List<Integer> l=new ArrayList<>();
        l.addAll(set);
        for (Integer i : l) {
            set.remove(i);
            if (dfs(set,nums,m,nums[i],p+n))
                return true;
            if (dfs(set,nums,m,-nums[i],p+n))
                return true;
            if (dfs(set,nums,m,p*nums[i],n))
                return true;
            if (dfs(set,nums,m,p/nums[i],n))
                return true;
            set.add(i);
        }
        return false;
    }


    public static boolean bp(int[] nums,int k,List<List<Character>> lists,List<Character> list){

        char[] chars={'+','-','*','/'};
        if(k==3){
            List<Character> l=new ArrayList<>();
            StringBuffer sb=new StringBuffer();
            sb.append(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                sb.append(list.get(i-1));
                sb.append(nums[i]);
            }
            return true;
        }
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
            bp(nums,k+1,lists,list);
            list.remove(list.size()-1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger bg=BigInteger.valueOf(1);
        for (int i = n; i >0; i--) {
            BigInteger k=BigInteger.valueOf(i);
            bg=bg.multiply(k);
        }
        System.out.println(bg);

    }




}
class Pair implements Comparable<Pair>{
    public int w;
    public int t;

    public Pair(int w, int t) {
        this.w = w;
        this.t = t;
    }

    @Override
    public int compareTo(Pair o) {
        return this.w-o.w;
    }
}
