package com.yanglk.algorithm;

public class Test1 {
    int binaryGap(int n){
        int c=0;
        int[] count=new int[32];
        int i=0;
        while(n!=0){
            if ((n&1)==1){
                count[i++]=1;
            }
            else {
                count[i++]=0;
            }
            n=n>>1;
        }
        int maxlen=0;
        int j=0;
        int len=1;
        i=0;
        for (; i < count.length; i++) {
            if (count[i]!=0){
                break;
            }
        }
        for (int i1 = i+1; i1 < count.length; i1++) {
            if (count[i1]==1){
                maxlen=Math.max(len,maxlen);
                len=1;
            }
            else{
                len++;
            }
        }
        return maxlen;
    }

}
