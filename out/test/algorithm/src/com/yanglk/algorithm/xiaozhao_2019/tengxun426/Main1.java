package com.yanglk.algorithm.xiaozhao_2019.tengxun426;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;



import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        for (int i = 0; i < k; i++) {
            int n=sc.nextInt();
            List<Pair> A=new ArrayList<>();
            List<Pair> B=new ArrayList<>();
            Set<String> sA=new HashSet<>();
            Set<String> sB=new HashSet<>();
//            Pair[] A=new Pair[n];
//            Pair[] B=new Pair[n];
            for (int i1 = 0; i1 < n; i1++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                String ss=String.valueOf(x)+"_"+String.valueOf(y);
                if (!sA.contains(ss)) {
                    sA.add(ss);
                    A.add(new Pair(x, y));
                }

                //A[i1]=new Pair(x,y);
            }
            boolean f=true;
            for (int i1 = 0; i1 < n; i1++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                String ss=String.valueOf(x)+"_"+String.valueOf(y);
                if (!sB.contains(ss)){
                    sB.add(ss);
                    B.add(new Pair(x,y));
                }
                if (sA.contains(ss)){
                    f=false;
                }
                //B[i1]=new Pair(x,y);
            }
            if (!f){
                System.out.printf("%.3f\n",0.0);
                break;
            }
            double min=Double.MAX_VALUE;
            for (Pair pa : A) {
                for (Pair pb : B) {
                    double d=Math.sqrt(Math.pow(pa.x-pb.x,2)+Math.pow(pa.y-pb.y,2));
                    min=Math.min(d,min);
                    if (min==0){
                        break;
                    }
                }
                if (min==0){
                    break;
                }
            }
            System.out.printf("%.3f",min);

        }
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

