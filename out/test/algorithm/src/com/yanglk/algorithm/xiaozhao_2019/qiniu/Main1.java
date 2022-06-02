package com.yanglk.algorithm.xiaozhao_2019.qiniu;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            char[] chars=sc.nextLine().toCharArray();
//            if (chars.length%2!=0){
//                System.out.println("NO");
//                continue;
//            }

            StringBuffer sb=new StringBuffer();
            while (true){
                int i1;
                for (i1 = 0; i1 < chars.length-1; i1++) {
                    if (chars[i1]==chars[i1+1]){
                        i1++;
                        continue;
                    }
                    else
                    {
                        sb.append(chars[i1]);
                    }
                }
                if (i1==chars.length-1&&i1>0){
                    sb.append(chars[i1]);
                }
                if (sb.length()==chars.length){
                    break;
                }
                chars=sb.toString().toCharArray();
                sb.delete(0,sb.length());
            }
            if (chars.length==0){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        }
    }
}
