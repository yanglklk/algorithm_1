package com.test;

public class StringEqualTest {
    public static void main(String[] args) {
        String s1 = "Programming"; //执行idc s1 就是char[] 地址
        String s2 = new String("Programming"); //执行idc s2 是string对象地址
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming"; //执行idc 只在常量池中 完全一样
        String s6 = s3 + s4; // stringBuffer  生成新对象 不执行idc
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s5.intern() == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
