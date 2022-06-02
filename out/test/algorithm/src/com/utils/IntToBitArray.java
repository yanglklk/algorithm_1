package com.utils;

public class IntToBitArray {

    public static String toBitArray(int n) {
        StringBuilder result = new StringBuilder();
        while (n!=0){
            result.append(n&1);
            n=n>>1;
        }
        while (result.length()<32){
            result.append(0);
        }
        StringBuilder ret =new StringBuilder();
        ret.append("[");
        result = result.reverse();
        for (int i = 0; i < result.length(); i++) {
            if (i!=0 && i%8==0){
                ret.append("],[");
            }
            ret.append(result.charAt(i));
        }
        ret.append("]");
        return ret.toString();
    }

}
