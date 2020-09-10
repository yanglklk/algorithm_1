package com.yanglk.algorithm.xiaozhao_2019.xiaomi;

import com.sun.corba.se.impl.encoding.EncapsOutputStream;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.yanglk.algorithm.offer.Str;

import javax.lang.model.SourceVersion;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.file.OpenOption;
import java.security.PublicKey;
import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        long num=sc.nextLong();
        int k=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        while (num>=k){
            int yu= (int) (num%k);
            list.add(0,yu);
            num/=k;
        }
        list.add(0, (int) num);
        for (Integer integer : list) {
            System.out.print(integer);
        }
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] opt=new int[n+1];
        opt[1]=1;
        for (int i = 2; i < (n + 1); i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 1; j*j*j <=i ; j++) {
                min=Math.min(min,opt[i-j*j*j]);
            }
            opt[i]=min+1;
        }
        System.out.println(opt[n]);

    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(",");
        int n=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        int[] nums=new int[m];
        int[] vals=new int[m];
        for (int i = 0; i < m; i++) {
            nums[i]=Integer.parseInt(ss[2].split(" ")[i]);
            vals[i]=Integer.parseInt(ss[3].split(" ")[i]);
        }
        int[][] opt=new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                opt[i][j]=opt[i-1][j];
                if (j-nums[i-1]>=0){
                    opt[i][j] =Math.max(opt[i-1][j-nums[i-1]]+vals[i-1],opt[i][j]);
                }
            }
        }
        System.out.println(opt[m][n]);
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n<=2){
            System.out.println(n);
            return;
        }
        BigInteger[] opt=new BigInteger[n];
        opt[0]= BigInteger.valueOf(1);
        opt[1]= BigInteger.valueOf(2);
        for (int i = 2; i < n; i++) {
            opt[i]=opt[i-1].add(opt[i-2]);
        }
        System.out.print(opt[n-1]);
    }

    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        String s=ss[0];
        String t=ss[1];
        Map<Character,Integer> smap=new HashMap<>();
        Map<Character,Integer> tmap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (smap.keySet().contains(s.charAt(i))){
                smap.put(s.charAt(i),smap.get(s.charAt(i))+1);
            }
            else smap.put(s.charAt(i),1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (tmap.keySet().contains(t.charAt(i))){
                tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
            }
            else tmap.put(t.charAt(i),1);
        }
        for (Character key : smap.keySet()) {
            if (!tmap.containsKey(key)||tmap.get(key)<smap.get(key)){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }


    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[m][2];
            int[] degrees = new int[n + 1];
            for(int i = 0; i < m; i ++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                degrees[arr[i][1]] ++;
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i = 1; i <= n; i ++) {
                if(degrees[i] == 0) queue.offer(i);
            }

            List<String> res = new ArrayList<>();
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                res.add(String.valueOf(cur));
                for(int[] a : arr) {
                    if (a[0]==cur){
                        if(-- degrees[a[1]] == 0) queue.offer(a[1]);
                    }
                }
            }

            System.out.println(String.join(" ", res));
        }
    }

    public static void main7(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(dfs(k,x,y,n,m));

    }
    public static int dfs(int k,int x,int y,int n,int m){
        if (k >= 0 &&(x<0||x>=n||y<0||y>=m)) {
            return 1;
        }
        if (k<0)
            return 0;
        int c=0;
        c+=dfs(k-1,x+1,y,n,m);
        c+=dfs(k-1,x-1,y,n,m);
        c+=dfs(k-1,x,y+1,n,m);
        c+=dfs(k-1,x,y-1,n,m);
        return c;
    }

    public static void main8(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int[] nums=new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        int i=0;int j=nums.length-1;

        while (i<=j){
            if (nums[i]%2==0&&nums[j]%2!=0){
                i++;
                j--;
                continue;
            }
            if (nums[i]%2!=0&&nums[j]%2==0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                i++;
                j--;
                continue;
            }
            if (nums[i]%2==0&&nums[j]%2==0){
                i++;
                continue;
            }
            if (nums[i]%2!=0&&nums[j]%2!=0){
                j--;
                continue;
            }

        }
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void main10(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list=new ArrayList<>();
        int yh=0;
        String s;

        while ((s=br.readLine())!=null){
            int t=Integer.parseInt(s);
            yh^=t;
            list.add(t);
        }
        yh^=0;
        int t=(yh)&(~yh+1);
        int yh1=0;
        for (Integer integer : list) {
            if ((integer&t)!=0){
                yh1^=integer;
            }
        }
        yh1^=0;
        yh^=yh1;
        if (yh1<yh){
            System.out.println(yh1+" "+yh);
        }
        else{
            System.out.println(yh+" "+yh1);
        }


    }

    public static void main9(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000000];
        int ans = 0, index = 0;
        String temp;
        while((temp=br.readLine())!=null){
            arr[index] = Integer.parseInt(temp);
            ans ^= arr[index];//a^a==0与
            index++;
        }
        int a=0, b=0;
        ans &= -ans;//找到最右一个为1的位,从而使a, b分为两组
        for(int i=0; i<index; i++){
            if((arr[i]&ans)==0){
                a ^= arr[i];
            }else{
                b ^= arr[i];
            }
        }
        System.out.println(Math.min(a, b)+" "+Math.max(a,b));
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String[] ss=br.readLine().split(" ");
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int[] nums=new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        int l=0;
        int r=nums.length-1;
        if (nums[l]<nums[r]){
            System.out.println(nums[l]);
            return;
        }
        while (l<=r){
            int m=(l+r)/2;
            if (m+1<nums.length&&nums[m]>nums[m+1]){
                System.out.println(nums[m+1]);
                return;
            }
            if (m-1>=0&&nums[m]<nums[m-1]){
                System.out.println(nums[m]);
                return;
            }
            if (m+1== nums.length||m-1<0){
                System.out.println(nums[m]);
                return;
            }


            if (nums[m]>=nums[l]){
                l=m+1;
            }
            else {
                r=m-1;
            }
        }


    }




    
}

