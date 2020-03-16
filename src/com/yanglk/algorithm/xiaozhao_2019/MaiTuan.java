package com.yanglk.algorithm.xiaozhao_2019;

import com.yanglk.algorithm.offer.Str;
import com.yanglk.algorithm.string_.MinDistance;
import sun.awt.datatransfer.DataTransferer;

import javax.sound.midi.Soundbank;
import java.nio.channels.NonWritableChannelException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class MaiTuan {
    public static void main_(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        if (ss.length==1&&(ss[0].equals("true")||ss[0].equals("false"))){
            System.out.println(ss[0]);
            return;
        }
        if ((ss.length==1&&(ss[0].equals("and")||ss[0].equals("or")))||ss.length%2==0){
            System.out.println("error");
            return;
        }
        ArrayList<Integer> index=new ArrayList<>();
        for (int i = 1; i < ss.length-1; i=i+2) {
            if (ss[i].equals("true")||ss[i].equals("false")||ss[i-1].equals("and")||ss[i+1].equals("and")||ss[i-1].equals("or")||ss[i+1].equals("or")){
                System.out.println("error");
                return;
            }
            if (ss[i].equals("and")){
                if (ss[i-1].equals("false")||ss[i+1].equals("false")){
                    ss[i-1]="false";
                    ss[i+1]="false";
                }
            }
        }
        for (int i = 0; i < ss.length ; i=i+2) {
            if (ss[i].equals("true")){
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        String t=sc.nextLine();
        int p_len=p.length();
        int t_len=t.length();
        int i=0,j=0;
        for ( ; i < t_len; i++) {
            for (j=i; j < p_len; j++) {
                if (p.charAt(j)==t.charAt(i)){
                    break;
                }
                if (p.charAt(j)=='*'){

                }
            }
        }

    }
    static List<int[]> list=new ArrayList<>();
    static double max=-1;
    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        double[][] matir=new double[n][n];
        for (int i = 0; i < n; i++) {
            String[] ss=sc.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matir[i][j]=Double.parseDouble(ss[j]);
            }
        }
        int[] record=new int[n];
        maxProfile(matir,0,n,0.0,record,new ArrayList<>());
        System.out.printf("%.2f\n",max);
        for (int[] ints : list) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i]+" ");
            }
            System.out.println();
        }
    }
    public static  void maxProfile(double[][] mat,int i,int n,double sum,int[] record,List<int[]> l){
        if (i==n&&sum>max){
            list.clear();
            list.addAll(l);
            max=sum;
            return;
        }
        for (int j = 0; j < n; j++) {
           if (valid(record,i,j)){
               record[i]=j;
               sum+=mat[i][j];
               l.add(new int[]{i+1,j+1});
               maxProfile(mat,i+1,n,sum,record,l);
               l.remove(l.size()-1);
               sum-=mat[i][j];
           }
        }

    }
    public static boolean valid(int[] record,int i,int j){
        for (int k = 0; k < i; k++) {
            if (record[k]==j)
                return false;
        }
        return true;
    }

    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="ANFNVKAWWPPPYUIOMLLM";
        int[][] index=new int[26][2];
        for (int[] ints : index) {
            ints[0]=-1;
        }
        char[] chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (index[chars[i]-'A'][0]==-1){
                index[chars[i]-'A'][0]=i;
            }
            index[chars[i]-'A'][1]=i;
        }
        Arrays.sort(index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int i = 0;
        for (; i < index.length; i++) {
            if (index[i][0]!=-1)
                break;
        }
        int right=index[i][1];
        int left=index[i][0];
        List<Integer> l=new ArrayList<>();
        for (; i < index.length; i++) {
            if (index[i][0] > right) {
                l.add(right-left+1);
                right=index[i][1];
                left=index[i][0];
                continue;
            }
            right=Math.max(right,index[i][1]);
        }
        l.add(right-left+1);
        System.out.println(l);
        //ANFNVKAWWPPPYUIOMLLM

    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
//        a=a.substring(1,a.length()-1);
//        b=b.substring(1,b.length()-1);
//        int aa=Integer.parseInt(a);
//        int bb=Integer.parseInt(b);
//        int cc=aa+bb;
//        String c=String.valueOf(cc);
//        StringBuilder sb=new StringBuilder(c);
//        sb.insert(0,'"');
//        sb.append('"');
//        System.out.println(sb.toString());


        a=a.substring(1,a.length()-1);
        b=b.substring(1,b.length()-1);
        boolean a_flag=a.charAt(0)=='-';
        boolean b_flag=b.charAt(0)=='-';
        if (a_flag&&b_flag){
            //都是负数
            StringBuilder sb=mult(a.substring(1),b.substring(1));
            sb.insert(0,'-');
            sb.insert(0,'"');
            sb.append('"');
            System.out.println(sb.toString());

        }
        else if (a_flag||b_flag){
            Stack<Integer> bag_stack=new Stack<>();
            Stack<Integer> sml_stack=new Stack<>();

            if (a_flag)
                a=a.substring(1);
            else
                b=b.substring(1);
            if (a.length()<b.length()){
                StringBuilder stringBuilder=new StringBuilder();
                char[] t=new char[b.length()-a.length()];
                Arrays.fill(t,'0');;
                stringBuilder.append(t);
                stringBuilder.append(a);
                a=stringBuilder.toString();
            }
            else {
                StringBuilder stringBuilder=new StringBuilder();
                char[] t=new char[a.length()-b.length()];
                Arrays.fill(t,'0');;
                stringBuilder.append(t);
                stringBuilder.append(b);
                b=stringBuilder.toString();
            }
            boolean a_big=false;
            boolean b_big=false;
            int i = 0;
            for (; i < a.length(); i++) {
                if (a.charAt(i)>b.charAt(i)){
                    for (int j = 0; j < a.length(); j++) {
                        bag_stack.push(a.charAt(j)-'0');
                        sml_stack.push(b.charAt(j)-'0');
                    }
                    a_big=true;
                    break;
                }
                if (a.charAt(i)<b.charAt(i)){
                    for (int j = 0; j < a.length(); j++) {
                        sml_stack.push(a.charAt(j)-'0');
                        bag_stack.push(b.charAt(j)-'0');
                    }
                    b_big=true;
                    break;
                }
            }
            if (i==a.length()){
                System.out.println("0");
                return;
            }
            int f=0;
            StringBuilder sb=new StringBuilder();

            while (!bag_stack.empty()){
                int bag=bag_stack.pop();
                int sml=sml_stack.pop();
                int dec=bag-sml-f;
                if (dec<0){
                    sb.insert(0,10+dec);
                    f=1;
                }
                else {
                    sb.insert(0,dec);
                    f=0;
                }
            }
            int i1 = 0;
            for (; i1 < sb.length(); i1++) {
                if (sb.charAt(i1)!='0')
                    break;
            }
            sb=new StringBuilder(sb.substring(i1));
            if (a_flag&&a_big||b_flag&&b_big){
                sb.insert(0,'-');
            }
            sb.insert(0,'"');
            sb.append('"');
            System.out.println(sb.toString());

        }
        else {
            //都是正数
            StringBuilder sb=mult(a,b);
            sb.insert(0,'"');
            sb.append('"');
            System.out.println(sb.toString());
        }


    }
    public static StringBuilder mult(String a,String b){
        Stack<Integer> a_stack=new Stack<>();
        Stack<Integer> b_stack=new Stack<>();
        if (a.length()<b.length()){
            StringBuilder stringBuilder=new StringBuilder();
            char[] t=new char[b.length()-a.length()];
            Arrays.fill(t,'0');;
            stringBuilder.append(t);
            stringBuilder.append(a);
            a=stringBuilder.toString();
        }
        else {
            StringBuilder stringBuilder=new StringBuilder();
            char[] t=new char[a.length()-b.length()];
            Arrays.fill(t,'0');;
            stringBuilder.append(t);
            stringBuilder.append(b);
            b=stringBuilder.toString();
        }
        for (int i = 0; i < a.length(); i++) {
            a_stack.push(a.charAt(i)-'0');
            b_stack.push(b.charAt(i)-'0');
        }

        int f=0;
        StringBuilder sb=new StringBuilder();
        while (!a_stack.empty()&&!b_stack.empty()){
            int temp_a=a_stack.pop();
            int temp_b=b_stack.pop();
            int ins=temp_a+temp_b+f;
            if (ins>=10){
                sb.insert(0,ins-10);
                f=1;
            }
            else {
                sb.insert(0,ins);
                f=0;
            }
        }
        if (f==1){
            sb.insert(0,1);
        }
        return sb;
    }

    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] num=new int[n];
        int[] sum=new int[n];
        int s=0;
        String[] ss=sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i]=Integer.parseInt(ss[i]);
            sum[i]=s+num[i];
            s=sum[i];
        }

//        int ret=smlCast(0,n-1,sum,num);
//        System.out.println(ret);
        int[][] opt=new int[n][n];
        for (int j = 0; j < n; j++) {
            opt[j][j]=num[j];
            for (int i = j-1; i >=0; i--) {
                if(i==j-1){
                    opt[i][j]=opt[i][j-1]+opt[j][j];
                    continue;
                }
                opt[i][j]=Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    opt[i][j]=Math.min(opt[i][k]+opt[k+1][j]+sum[j]-sum[i]+num[i],opt[i][j]);
                }
            }
        }
        System.out.println(opt[0][n-1]);


    }
    public static int smlCast(int i,int j,int[] sum,int[] num){
        if (i==j)
            return num[i];
        int min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
             min=Math.min(smlCast(i,k,sum,num)+smlCast(k+1,j,sum,num)+sum[j]-sum[i],min);
        }
        return min;
    }

    public static void main(String[] args) {

        Object os=new String("faf");
        Object oo =new Object();
        Object oi=new Integer(2);
//        human oo=new human();
//        human os=new man();
//        human oi= new woman();
        System.out.println();
        MaiTuan mt=new MaiTuan();
        mt.f1(os);
        mt.f1(oo);
        mt.f1(oi);

    }
    public void f1(Object o){
        System.out.println("hello");
    }
    public void f1(String s){
        System.out.println(s.getClass());
    }
    public void f1(Integer i){
        System.out.println(i.getClass());
    }


}
class human{

}
class man extends human{

}
class woman extends human{

}


