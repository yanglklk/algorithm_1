package com.yanglk.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        int n=Integer.parseInt(line);
        line=br.readLine();
        String[] strings=line.split(" ");
        int[] num=new int[(int)(Math.pow(n,2))];
        for (int i = 0; i < num.length; i++) {
            num[i]=Integer.parseInt(strings[i]);
        }
        line=br.readLine();
        int m=Integer.parseInt(line);
        line=br.readLine();
        strings=line.split(" ");
        int[] Q=new int[m];
        for (int i = 0; i < Q.length; i++) {
            Q[i]=Integer.parseInt(strings[i]);
        }
        System.out.println(m+"\n"+n+"\n"+ Arrays.toString(num));




    }
}
