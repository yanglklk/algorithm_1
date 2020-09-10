package com.yanglk.algorithm.xiaozhao_2019.yuewen;

import com.yanglk.algorithm.link_.ListNode;
import com.yanglk.algorithm.offer.Array;


import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> array=new ArrayList<>();
        array.add("query=中文");
        array.add("version=1.0.0");
       // ["query=中文","version=1.0.0"]
        new Main().createToken(array);
    }

    public int stairs (int n) {
        if (n<=2)
            return n;
        return stairs(n-1)+stairs(n-2);

    }

    public String filterContent (String content) {
        // write code here
        StringBuffer sb=new StringBuffer();
        int[] len={10,9,8,7,6};
        int s=0;
        char[] chars=content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='1'&&chars[i]<='9'){
                for (int l1 : len) {
                    int i1 = 0;
                    for (; i1 < l1; i1++) {
                        if (i+i1<chars.length&&chars[i+i1]>='0'&&chars[i+i1]<='9'){
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    if (i1==l1){
                        i=i1+i;
                        s=i;
                        sb.append(content.substring(s,i));
                    }

                }
            }
        }

        sb.append(content.substring(s,chars.length));
        return sb.toString();

    }
    public ListNode reverseList (ListNode head) {
        // write code here
        if (head==null||head.next==null)
            return head;
        ListNode h=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return h;
    }

    public String createToken (ArrayList<String> querys) {
        // write code here
        Map<String,String> map=new TreeMap<>();
        for (String query : querys) {
            String[] ss=query.split("=");

            try {
                ss[0]=URLEncoder.encode(ss[0],"UTF-8");
                ss[1]=URLEncoder.encode(ss[1],"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            map.put(ss[0],ss[1]);
        }
        StringBuffer sb=new StringBuffer();
        for (String s : map.keySet()) {
            sb.append(s);
            sb.append('=');
            sb.append(map.get(s));
            sb.append('&');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(MD5.getMd5(sb.toString()));
        return MD5.getMd5(sb.toString());
    }
}
class MD5 {
    public static String getMd5(String s) {
       //String s = "This is a test";
        String md5Val=null;
        try {
            MessageDigest m;
            m = MessageDigest.getInstance("md5");
            //m.update(s.getBytes(), 0, s.length());
            //m.digest(s.getBytes());
            md5Val = new BigInteger(1, m.digest()).toString(16);
            //System.out.println(md5Val);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Val;
    }
}
