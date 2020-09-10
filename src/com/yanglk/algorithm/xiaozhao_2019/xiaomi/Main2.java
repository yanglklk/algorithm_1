package com.yanglk.algorithm.xiaozhao_2019.xiaomi;

import com.yanglk.algorithm.offer.Str;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main1(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] ss=br.readLine().split(",");
        int[] nums=new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int[][] pis=new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (stack1.empty() || nums[i] < nums[stack1.peek()]) {
                stack1.push(i);
            } else {
                while (!stack1.empty() && nums[i] > nums[stack1.peek()]) {
                    int t = stack1.pop();
                    pis[t][1] = i;
                    pis[t][0]= stack1.empty() ? -1: stack1.peek();
                }
                stack1.push(i);
            }
        }
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (stack2.empty()||nums[i]<nums[stack2.peek()]){
//                stack2.push(i);
//            }
//            else {
//                while (!stack2.empty()&&nums[i]>nums[stack2.peek()]){
//                    int t=stack2.pop();
//                    pis[t][0]=i;
//                }
//                stack2.push(i);
//            }
//        }

        while (!stack1.empty()){
            int t=stack1.pop();
            pis[t][1]=-1;
            pis[t][0]=stack1.empty() ? -1: stack1.peek();
        }
//        while (!stack2.empty()){
//            pis[stack2.pop()][0]=-1;
//        }
        long c=0;
        Set<String> set=new HashSet<>();
        for (int i = 0; i < pis.length; i++) {
            int[] pi=pis[i];
            String s=String.valueOf(pi[0])+"_"+String.valueOf(pi[1]);
            if (pi[0]<0||pi[1]<0||set.contains(s)){
                continue;
            }
            int h=Math.min(nums[pi[0]],nums[pi[1]])-nums[i];
            c+=(pi[1]-pi[0]-1)*h;
            set.add(s);

        }
        System.out.println(c);

    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] ss=br.readLine().split(",");
        int[][] nums=new int[ss.length-1][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0]=i;
            nums[i][1]=Integer.parseInt(ss[i]);
        }
        int target=Integer.parseInt(ss[ss.length-1]);
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1]? o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        int i=0;
        int j=nums.length-1;
        int c=0;
        while (i<j){
            if (nums[i][1]+nums[j][1]==target){
                int ii=i;
                int jj=j;
                c+=(nums[i][0]+nums[j][0]);
                while (ii< --jj&&nums[ii][1]+nums[jj][1]==target){
                    c+=(nums[ii][0]+nums[jj][0]);
                }
                int jjj=jj;
                ii=i;
                jj=j;
                while (++ii<jj&&nums[ii][1]+nums[jj][1]==target){
                    c+=(nums[ii][0]+nums[jj][0]);
                }
                i++;
                j--;

            }
            else if (nums[i][1]+nums[j][1]>target){
                j--;
            }
            else
                i++;
        }
        System.out.println(c);


    }

    public static void main3(String[] args) {
        char[] chars={'A','B','C','D','E','F'};
        Map<Character,Integer> mmap=new HashMap<>();
        mmap.put('A',10);
        mmap.put('B',11);
        mmap.put('C',12);
        mmap.put('D',13);
        mmap.put('E',14);
        mmap.put('F',15);
        Scanner sc=new Scanner(System.in);
        String s;
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,String> smap=new HashMap<>();
        List<String> list=new ArrayList<>();
        Set<String> set=new HashSet<>();
        while (!(s=sc.nextLine()).equals("END")){
            //list.add(s);
            int n=Integer.parseInt(s.split("#")[0]);
            String ss=s.split("#")[1];
            int l=ss.length();
            int j=0;
            int num=0;
            for (int i = l-1; i >= 0; i--) {
                char c=ss.charAt(j++);
                if (c>='0'&&c<='9'){
                    num+=Math.pow(n,i)*(c-'0');
                }
                else {
                    num+=Math.pow(n,i)*(mmap.get(c));
                }
            }
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
                list.remove(smap.get(num));
            }
            else {
                map.put(num,1);
                smap.put(num,s);
                list.add(s);
            }
        }


        if (list.size()==0){
            System.out.println("None");
        }
        else {
            for (String s1 : list) {
                    System.out.println(s1);
            }
        }


    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        byte[][] bytes=new byte[n][32];
        String[] ss;
        for (int i = 0; i <n; i++) {
            ss=sc.nextLine().split(" ");
            for (int k = 0; k < ss.length; k++) {
                bytes[i][Integer.parseInt(ss[k])]=1;
            }
        }
        int k=0;
    }

    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<String> l=new ArrayList<String>();
        bp(n,new StringBuffer(),1,l,m);
        System.out.println(l.size());

    }
    public  static void bp(int n,StringBuffer sb,int k,List<String> l,int m) {
        String[] op = {"+", "-", " "};
        if (k == n) {

            StringBuffer ssb = new StringBuffer();
            int sum = 0;
            int f = 1;
            ssb.append(1);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ') {
                    ssb.append(i + 2);
                } else if (sb.charAt(i) == '+') {
                    sum += Integer.parseInt(ssb.toString());
                    ssb.delete(0, ssb.length());
                    ssb.append('+');
                    ssb.append(i + 2);

                } else {
                    sum += Integer.parseInt(ssb.toString());
                    ssb.delete(0, ssb.length());
                    ssb.append('-');
                    ssb.append(i + 2);
                }
            }
            sum += Integer.parseInt(ssb.toString());
            if (sum == m)
                l.add(new String(sb));
            return;
        }
        for (String s : op) {
            sb.append(s);
            bp(n, sb, k + 1, l, m);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main6(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        Arrays.sort(nums);
        int[][] opt=new int[n+1][m+1];
        for (int i = 0; i < opt.length; i++) {
            opt[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < opt[0].length; j++) {
                opt[i][j]=opt[i-1][j];
                if (j-nums[i-1]>=0)
                 opt[i][j]=opt[i-1][j-nums[i-1]]|opt[i-1][j];
            }
        }

//        for (int[] ints : opt) {
//            System.out.println(Arrays.toString(ints));
//        }
        System.out.println(opt[n][m]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] nums=new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
            sum+=nums[i];
        }
        if (m==1){
            System.out.println(sum);
        }
        ArrayList <Integer> l=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        bp1(n,1,m-1,l,ls);
        int min=Integer.MAX_VALUE;
        for (ArrayList<Integer> list : ls) {
            min=Math.min(min,submax(nums,list));
        }
        System.out.println(min);


    }
    public static void bp1(int n,int k,int m,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> lists){
        if (list.size()==m){

            ArrayList <Integer> l=new ArrayList<>();
            l.addAll(list);
            l.add(n);
            lists.add(l);
            return;
        }
        while (k<n){
            list.add(k);
            bp1(n,++k,m,list,lists);
            list.remove(list.size()-1);
        }
    }
    public static  int submax(int[] nums,ArrayList <Integer> l){
        int max=Integer.MIN_VALUE;

        int lastindex=0;
        for (int i = 0; i < l.size(); i++) {
            int sum=0;
            for (java.lang.Integer j = lastindex; j < l.get(i); j++) {
                sum+=nums[j];
            }
            lastindex=l.get(i);
            max=Math.max(max,sum);
        }
        return max;
    }

}


