package com.learn.leetcode.everyday.tanxin;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.test.cloneTest.Car;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;

public class LongestPalindrome {

    public static void main(String[] args) {
        //new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        System.out.println(new LongestPalindrome().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public int longestPalindrome(String s) {
        int[] count = new int[52];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >='a' && c<= 'z'){
                count[c-'a']++;
            }
            else {
                count[c-'A'+26]++;
            }
        }
        int result = 0;
        int c=0;
        for (int i : count) {
            result+=i;
            if (i%2==1){
                c++;
            }
        }
        return c==0? result:result-c+1;
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < nums.length; i++) {
            strings[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuffer.append(strings[i]);
        }

try {
    Car car = new Car("11", 123);
    ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
    ObjectOutputStream outputStream =new ObjectOutputStream(byteArrayOutputStream);
    outputStream.writeObject(car);

    ByteArrayInputStream byteArrayInputStream =new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    ObjectInputStream objectInputStream =new ObjectInputStream(byteArrayInputStream);
    objectInputStream.readObject();
}catch (Exception e){

}


        return stringBuffer.toString();
    }
}
