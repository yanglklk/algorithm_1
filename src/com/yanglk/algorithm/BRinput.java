package com.yanglk.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BRinput {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list=new ArrayList<>();
        int yh=0;
        String s;

        while ((s=br.readLine())!=null){
            int t=Integer.parseInt(s);
            yh^=t;
            list.add(t);
        }
    }

}
