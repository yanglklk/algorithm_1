package com.test.jvmTest;

import java.io.UnsupportedEncodingException;

public class JVMTest {
    public static void main(String[] args) {
       // A a = new B();
        String s1 = "你好";
        try {
            String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
            System.out.println(s2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(new JVMTest().reverse("12312321"));
    }

    public String reverse(String args) {
        if (args==null || args.length()<=1){
            return args;
        }
        return reverse(args.substring(1))+args.charAt(0);
    }
}
