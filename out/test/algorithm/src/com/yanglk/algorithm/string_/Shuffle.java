package com.yanglk.algorithm.string_;

public class Shuffle {

    public Shuffle() {
    }

    public static void main(String[] args) {
        String s="abcdefghijkl";
        char[] chars=s.toCharArray();
        Shuffle shuffle=new Shuffle();
        shuffle.shuffle(chars);
        System.out.println(chars);
    }

    public void shuffle(char[] chas){
        if (chas!=null&&chas.length>0&&chas.length%2==0);
            shuffle(chas,0,chas.length-1);

    }

    public void shuffle(char[] chas,int L,int R){
        while (true){
            int k=0;
            int k_3=1;
            while (k_3<=(R-L+1)){
                k_3*=3;
                k++;
            }
            k--;
            int t=((int)(Math.pow(3,k))-1)/2;
            int mid=(L+R)/2;
            rotate(chas,mid,t+L,mid+t);
            cycle(chas,L,2*t,k);
            L=L+2*t;
            if (t==0)
                break;
        }
    }

    public void cycle(char[] chas,int L,int len,int k){
        for (int i=1;i<=k;i++){
            int s=(int)(Math.pow(3,i-1));
            int e=(s*2)%(len+1);
            char temp1=chas[L+s-1];
            char temp2;
            while (e!=s){
                temp2=chas[L+e-1];
                chas[L+e-1]=temp1;
                temp1=temp2;
                e=(e*2)%(len+1);
            }
            chas[L+e-1]=temp1;
        }

    }

    public void rotate(char[] chas,int m,int L,int R){
        reverse(chas,L,m);
        reverse(chas,m+1,R);
        reverse(chas,L,R);
    }

    public void reverse(char[] chas,int L,int R){
        while (L<R){
            char temp=chas[L];
            chas[L]=chas[R];
            chas[R]=temp;
            L++;
            R--;
        }
    }

}
