package com.yanglk.algorithm.arr_mat;

import javax.sound.midi.Soundbank;

public class ZigZag {
    public ZigZag() {
    }
    public void printZigZag(int[][] mat){
        int sR=0;
        int sC=0;
        int eR=0;
        int eC=0;
        int endR=mat.length-1;
        int endC=mat[0].length-1;
        boolean f=false;
        while (eC<endC){
            print(mat,sR,sC,eR,eC,f);
            sR=sC==endC ? sR+1:sR;
            sC=sC==endC ? sC:sC+1;

            eC=eR==endR ? eC+1:eC;
            eR=eR==endR ? eR:eR+1;

            f=!f;
        }

    }
    public void print(int[][] mat,int sR,int sC,int eR,int eC,boolean f){
        if (f){
            while (sR<=eR)
                System.out.print(mat[sR++][sC--]+ " ");
        }
        else{
            while (eR>=sR)
                System.out.print(mat[eR--][eC++]+ " ");
        }
    }

    public static void main(String[] args) {
        int[][] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new ZigZag().printZigZag(mat);
    }
}
