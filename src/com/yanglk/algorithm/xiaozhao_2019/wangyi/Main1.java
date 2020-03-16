package com.yanglk.algorithm.xiaozhao_2019.wangyi;

import com.yanglk.algorithm.offer.Array;
import com.yanglk.algorithm.offer.Str;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    public static void main11(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        String[] strings=line.split(" ");
        int n=Integer.parseInt(strings[0]);
        int m=Integer.parseInt(strings[1]);
        ArrayList<int[]> list=new ArrayList<>();
        ArrayList<int[]> friends=new ArrayList<>();
        int[] Ai=new int[m];
        for (int i = 0; i < n; i++) {
            line=br.readLine();
            strings=line.split(" ");
            int[] temp=new int[2];
            temp[0]=Integer.parseInt(strings[0]);
            temp[1]=Integer.parseInt(strings[1]);
            list.add(temp);
        }
        line=br.readLine();
        strings=line.split(" ");
        for (int i = 0; i < m; i++) {
            int[] temp=new int[2];
            temp[0]=i;
            temp[1]=Integer.parseInt(strings[i]);
            friends.add(temp);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        friends.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int max=0;
        int i1 = 0;
        for (int i = 0; i < m; i++) {
            for (;i1 < n&&friends.get(i)[1]>=list.get(i1)[0]; i1++) {

            }
            Ai[friends.get(i)[0]]=max;
        }
        for (int i : Ai) {
            System.out.println(i);
        }

    }

    public static void main1(String[] args) {
        Scanner sc =new Scanner(System.in);
        String line=sc.nextLine();
        int n=Integer.parseInt(line);
        line=sc.nextLine();
        char[] chars=line.toCharArray();
        int count=0;
        for (char aChar : chars) {
            if (aChar=='L')
                count++;
            else count--;
        }
        if (count>=0){
            count=count%4;
            switch (count){
                case 0 :{
                    System.out.println("N");
                    break;
                }
                case 1 :{
                    System.out.println("w");
                    break;
                }
                case 2 :{
                    System.out.println("S");
                    break;
                }
                case 3:{
                    System.out.println("E");
                }
            }
        }
        else {
            count=Math.abs(count);
            count=count%4;
            switch (count){
                case 0 :{
                    System.out.println("N");
                    break;
                }
                case 1 :{
                    System.out.println("E");
                    break;
                }
                case 2 :{
                    System.out.println("S");
                    break;
                }
                case 3:{
                    System.out.println("W");
                }
            }
        }
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] strings=line.split(" ");
        int a=Integer.parseInt(strings[0]);
        int b=Integer.parseInt(strings[1]);
        int c=Integer.parseInt(strings[2]);
        int result1=a+b+c;
        int result2=a*b*c;
        int result3=a+(b*c);
        int result4=(a+b)*c;
        System.out.println(Math.max(Math.max(result1,result2),Math.max(result3,result4)));
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] ss=line.split(" ");
        long n=Integer.parseInt(ss[0]);
        long k=Integer.parseInt(ss[1]);
        long count=0;
        if (k==0)
            System.out.println(n*n);
        else {
            long y=k+1;
            for (;  y<=n; y++) {
                count+=(n/y)*(y-k);
                if (n%y!=0&&n%y-k+1>0){
                    count+=n%y-k+1;
                }
            }
            System.out.println(count);
        }

    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] ss=line.split(" ");
        int n=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        int[] num=new int[n];
        line=sc.nextLine();
        ss=line.split(" ");
        int min=m;
        for (int i = 0; i < ss.length; i++) {
            int k=Integer.parseInt(ss[i]);
            num[k-1]+=1;
        }
        Arrays.sort(num);
        System.out.println(num[0]);
    }

    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int n=Integer.parseInt(line);
        String[] ss;
        while (n-- >0){
            int[][] points=new int[4][4];
            for (int i = 0; i < 4; i++) {
                line=sc.nextLine();
                ss=line.split(" ");
                points[i][0]=Integer.parseInt(ss[0]);
                points[i][1]=Integer.parseInt(ss[1]);
                points[i][2]=Integer.parseInt(ss[2]);
                points[i][3]=Integer.parseInt(ss[3]);
            }
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                rotate(points[0]);
                for (int j = 0; j < 4; j++) {
                    rotate(points[1]);
                    for (int k = 0; k < 4; k++) {
                        rotate(points[2]);
                        for (int l = 0; l < 4; l++) {
                            rotate(points[3]);
                            if (isSquare(points))
                            {
                              int temp=(1+i)%4+(1+j)%4+(1+k)%4+(1+l)%4;
                              min= Math.min(min,temp);
                            }
                        }
                    }
                }
            }
            if (min==Integer.MAX_VALUE)
                System.out.println(-1);
            else System.out.println(min);
        }

    }
    public static int[] rotate(int[] point){
        int a=point[0];
        int b=point[1];
        point[0]=point[2]+point[3]-b;
        point[1]=point[3]-point[2]+a;
        return point;
    }
    public static boolean isSquare(int[][] points){
        long[] dis=new long[6];
        int k=0;
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 4; j++) {
                dis[k++]=distance(points[i],points[j]);
            }
        }
        Arrays.sort(dis);
        return dis[0]!=0 && dis[0]==dis[1] && dis[0]==dis[2]&& dis[0]==dis[3]&& dis[0]!=dis[4]&& dis[4]==dis[5];
    }
    public static long distance(int[] point1,int[] point2){
        return (long)(Math.pow((point1[0]-point2[0]),2)+Math.pow((point1[1]-point2[1]),2));
    }

    public static void main6(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int m=Integer.parseInt(sc.nextLine());
            String s=sc.nextLine();
            char[] chars=s.toCharArray();
            int fast=0;
            int len=0;
            for ( ;  fast< chars.length; ) {
                if (chars[fast]=='.'){
                    len++;
                    fast+=3;
                }
                else
                    fast++;
            }
            System.out.println(len);
        }
    }

    public static void main7(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        ArrayList<int[]> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] ss=sc.nextLine().split(" ");
            int[] time=new int[2];
            time[0]=Integer.parseInt(ss[0]);
            time[1]=Integer.parseInt(ss[1]);
            list.add(time);
        }
        int cost=Integer.parseInt(sc.nextLine());
        String[] ss=sc.nextLine().split(" ");
        int time=Integer.parseInt(ss[0])*60+Integer.parseInt(ss[1]);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0])
                    return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        int i=0;
        for (; i < list.size(); i++) {
            int start=list.get(i)[0]*60+list.get(i)[1];
            if (start+cost>time)
                break;
        }
        System.out.println(list.get(i-1)[0]+" "+list.get(i-1)[1]);

    }

    public static void main8(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        int k=Integer.parseInt(ss[1]);
        ss=sc.nextLine().split(" ");
        int[] nums=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        ss=sc.nextLine().split(" ");
        int[] flag=new int[n];
        for (int i = 0; i < nums.length; i++) {
            flag[i]=Integer.parseInt(ss[i]);
        }
        int max=Integer.MIN_VALUE;
        int sum1=0;
        int sum2=0;
        int[] s1=new int[n];
        int[] s2=new int[n];
        for (int i = flag.length - 1; i >= 0; i--) {
            if (flag[i]==1){
                sum2+=nums[i];
            }
            s2[i]=sum2;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]==1){
                sum1+=nums[i];
            }
            s1[i]=sum1;
        }
        int i=0;
        int j=k;
        int temp=0;
        for (int i1 = 0; i1 < k&&i1<n; i1++) {
            temp+=nums[i1];
        }
        if (k>=n)
            System.out.println(temp);
        else {
            while (i < n) {
                if (flag[i] == 0) {
                    int t = temp + s1[i] + s2[j];
                    max = Math.max(max, t);
                }
                temp -= nums[i];
                i++;
                temp += nums[j];
                j++;
                if (j == n) {
                    temp -= nums[n - 1];
                    j = n - 1;
                }
            }
            System.out.println(max);
        }
    }

    public static void main9(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] ss=sc.nextLine().split(" ");
        int[][] nums=new int[n+1][2];
        int sum=0;
        for (int i = 1; i < n+1; i++) {
            int t=Integer.parseInt(ss[i]);
            sum+=t;
            nums[i][0]=sum;
            nums[i][1]=i;
        }
        int m=Integer.parseInt(sc.nextLine());
        ss=sc.nextLine().split(" ");
        int[][] test=new int[m][2];
        for (int i = 0; i < ss.length; i++) {
            test[i][0]=Integer.parseInt(ss[i]);
            test[i][1]=i;
        }
        Arrays.sort(test, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] result=new int[m];
        int j=0;
        int i=0;
        for (; i < test.length;) {
            while (j<n+1&&test[i][0]>nums[j][0])
                j++;
            result[test[i][1]]=j;
            i++;
        }
        if (i<m){
            result[test[i][1]]=j;
        }
        for (int i1 : result) {
            System.out.println(i1);
        }
    }

    public static void main10(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        int k=Integer.parseInt(ss[1]);
        ss=sc.nextLine().split(" ");
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(ss[i]);
        }
        if (n==1)
            System.out.println(0+" "+0);
        else {
            int m;
            ArrayList<int[]> list=new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int min=nums[0];
                int max=nums[0];
                int min_index=0;
                int max_index=0;
                for (int i1 = 0; i1 < n; i1++) {
                    if (nums[i1]>max){
                        max=nums[i1];
                        max_index=i1;
                    }
                    if (nums[i1]<min){
                        min=nums[i1];
                        min_index=i1;
                    }
                }
                if (min==max)
                    break;
                if (min!=max){
                    list.add(new int[]{max_index+1,min_index+1});
                    nums[max_index]--;
                    nums[min_index]++;
                }
            }
            int min=nums[0];
            int max=nums[0];

            for (int i1 = 0; i1 < n; i1++) {
                if (nums[i1]>max){
                    max=nums[i1];
                }
                if (nums[i1]<min){
                    min=nums[i1];
                }
            }
            System.out.println(max-min+" "+list.size());
            for (int[] ints : list) {
                System.out.println(ints[0]+" "+ints[1]);
            }
        }

    }

    public static void main12(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        long k=Integer.parseInt(ss[2]);
        StringBuffer sb=new StringBuffer();
        while (n>0&&m>0){
            long temp=1;
            for (int i = 0; i < (n - 1); i++) {
                temp*=(n-1+m-i);
                temp/=(i+1);
                if (temp>k) break;
            }
            if (k<=temp){
                sb.append('a');
                n--;
            }
            else {
                sb.append('z');
                m--;
                k-=temp;
            }
        }
        if (k!=1)
            System.out.println(-1);
        else {
            while (n!=0){
                sb.append('a');
                n--;
            }
            while (m!=0){
                sb.append('z');
                m--;
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int n=Integer.parseInt(ss[0]);
        long w=Long.parseLong(ss[1]);
        ss=sc.nextLine().split(" ");
        ArrayList<Long> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long t=Long.parseLong(ss[i]);
            if (t<=w)
                list.add(t);
        }

        list.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int)(o1-o2);
            }
        });
       // Long[] nums=(Long[]) list.toArray();
        int len=list.size();
        long k=(long)(Math.pow(2,len));
        int count=0;
        for (long i = 0; i < k; i++) {
            char[] chars=Long.toBinaryString(i).toCharArray();
            long sum=0;
            for (int i1 = 0; i1 < len; i1++) {
                if (i1<chars.length&&sum<=w){
                    sum+=(chars[chars.length-i1-1]-'0')*list.get(i1);
                }
                else break;
            }
            if (sum<=w){
                count++;
            }
            if (sum>w)
                break;

        }
        System.out.println(count);

    }



}
