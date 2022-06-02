package com.learn.leetcode.everyday;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class March_31_927 {
    public static void main(String[] args) {
        //new March_31_927().isRationalEqual("0.1666(6)","0.166(66)");
        new March_31_927().isRationalEqual("0.(52)","0.5(25)");
        new March_31_927().isRationalEqual("0.(9)","1.(0)");

    }
    public boolean isRationalEqual(String s, String t) { ;
        Double sDouble = parseString(s);
        Double tDouble = parseString(t);
        return Math.abs(sDouble - tDouble) < 0.0000000001;
    }
    public Double parseString(String s){
        List<String> returnList= new ArrayList<>();
        String[] ss1= s.split("\\.");
        StringBuilder returnS = new StringBuilder(ss1[0]);
        if (ss1.length>1){
            String[] ss2= ss1[1].split("\\(");
            returnS.append('.');
            returnS.append(ss2[0]);
            if (ss2.length>1) {
                String repeatS = ss2[1].substring(0, ss2[1].length() - 1);
                int n = (17-(ss2.length))/repeatS.length() + 1;
                for (int i = 0; i < n; i++) {
                    returnS.append(repeatS);
                }
            }
        }
        return Double.valueOf(returnS.toString());
    }
}
