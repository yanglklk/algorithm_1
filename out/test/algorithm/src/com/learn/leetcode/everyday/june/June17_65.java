package com.learn.leetcode.everyday.june;

import sun.net.www.protocol.http.HttpURLConnection;

public class June17_65 {
    public static void main(String[] args) {
        new June17_65().isNumber("e");
    }
    public boolean isNumber(String s) {
       int indexe = s.indexOf('e');
       int indexE = s.indexOf('E');
       if (indexe != -1 && indexE != -1){
           return false;
       }else if (indexe != -1 && indexE == -1){
            String IntS = s.substring(indexe+1);
            String DotOrIntS = s.substring(0,indexe);
            if (IntS.length() == 0 || DotOrIntS.length() == 0){
                return false;
            }
            return isInt(IntS) && isDot(DotOrIntS);
       }else if (indexe == -1 && indexE != -1){
           String IntS = s.substring(indexE+1);
           String DotOrIntS = s.substring(0,indexE);
           if (IntS.length() == 0 || DotOrIntS.length() == 0){
               return false;
           }
           return isInt(IntS) && isDot(DotOrIntS);
       }
      else {
            return isDot(s);
       }
    }
    public boolean isInt(String s) {
        if (s.length()>0 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
            s = s.substring(1);
        }
        if (s.length()==0){
            return false;
        }
        return isNum(s);
    }

    public boolean isDot(String s) {
        if (s.length()>0 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
            s = s.substring(1);
        }
        int indexDot = s.indexOf('.');
        if (indexDot !=-1){
            String head = s.substring(0,indexDot);
            String back = s.substring(indexDot+1);
            if (head.length() == 0 && back.length()==0){
                return false;
            }
            return isNum(head) && isNum(back);
        }
        else {
            return isNum(s);
        }

    }
    public boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)<'0' || s.charAt(i)>'9'){
                return false;
            }
        }
        new June16_877().stoneGame(new int[]{0});
        return true;
    }
}
