package com.yanglk.algorithm.string_;

public class Rotate {

    public Rotate() {
    }

    public static void main(String[] args) {
        String s="   pig loves dog   ";
        char[] chars=s.toCharArray();
        Rotate rotate=new Rotate();
        rotate.rotateWord(chars);
        System.out.println(chars);
    }

    public void rotateWord(char[] chas){
        int l=0;
        int r=chas.length-1;
        while (l<r){
            char temp=chas[l];
            chas[l]=chas[r];
            chas[r]=temp;
            l++;
            r--;
        }
        l=r=0;
        while (l<chas.length){
            if (r<chas.length&&chas[r]!=' '){
                r++;
                continue;
            }
            else {
                int l1=l,r1=r-1;
                while (l1<r1){
                    char temp=chas[l1];
                    chas[l1]=chas[r1];
                    chas[r1]=temp;
                    l1++;
                    r1--;
                }
                l=r=r+1;
            }
        }

    }

    public char[] rotateWord2(char[] chas,int size){
        int l=0;
        int r=chas.length-1;
        while (l<r){
            char temp=chas[l];
            chas[l]=chas[r];
            chas[r]=temp;
            l++;
            r--;
        }
        l=0;
        r=chas.length-size-1;
        while (l<r){
            char temp=chas[l];
            chas[l]=chas[r];
            chas[r]=temp;
            l++;
            r--;
        }
        l=chas.length-size;
        r=chas.length-1;
        while (l<r){
            char temp=chas[l];
            chas[l]=chas[r];
            chas[r]=temp;
            l++;
            r--;
        }
        return  chas;
    }
}
