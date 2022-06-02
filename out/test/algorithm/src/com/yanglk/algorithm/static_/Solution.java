package com.yanglk.algorithm.static_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1,int[] nums2){
        if (nums1==null||nums1.length==0)
            return nums1;
        int[] result=new int[nums1.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.empty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()){
            map.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i]=map.get(nums1[i]);
        }
        return result;
    }

    public int[] nextGreaterElement(int[] nums){
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(nums[n-1]);
        int[] result=new int[n];
        for (int i = n*2-1;i>=0; i--) {
            while (!stack.empty()&&nums[i%n]>stack.peek()){
                stack.pop();
            }
            result[i%n]=!stack.empty()? -1:nums[i%n];
            stack.push(nums[i%n]);

        }
    return result;
    }
    public int[] nextGreaterElement1(int[] nums){
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        for (int i = 0; i < n; i++) {
            for (int i1 = i+1; i1 < n*2; i1++) {
                if (nums[i1%n]>nums[i]){
                    result[i]=nums[i1%n];
                    break;
                }
            }
        }
        return result;
    }

    public String decodeString(String s){
        if (s==null||s.length()==0)
            return s;
        StringBuffer sb=new StringBuffer();
        Stack<Integer> nums=new Stack<>();
        Stack<StringBuffer> chars=new Stack<>();
        char[] ss=s.toCharArray();
        int num=0;
        for (int i = 0; i < ss.length; i++) {
            if ((i==0&&ss[i]>='a'&&ss[i]<='z')||(i==0&&ss[i]>='A'&&ss[i]<='Z')){
                nums.push(1);
            }
            if (ss[i]=='['&&ss[i+1]>='0'&&ss[i+1]<='9'){
                chars.push(new StringBuffer());
                continue;

            }
            if (ss[i]>='0'&&ss[i]<='9'){
                while (i < ss.length&&ss[i]>='0'&&ss[i]<='9'){
                    num=num*10+(ss[i]-'0');
                    i++;
                }
                i--;
                nums.push(num);
                num=0;
                continue;
            }
            if ((ss[i]>='a'&&ss[i]<='z')||(ss[i]>='A'&&ss[i]<='Z')){
                StringBuffer s_i=new StringBuffer();
                boolean flag=false;
                if (i>0&&ss[i-1]==']')
                    flag=true;
                while (i < ss.length&&((ss[i]>='a'&&ss[i]<='z')||(ss[i]>='A'&&ss[i]<='Z'))){
                    s_i.append(ss[i]);
                    i++;
                }
                i--;
                if (flag){
                    chars.push(chars.pop().append(s_i));
                }
                else {
                    chars.push(s_i);
                }

                continue;
            }
            if (ss[i]==']'){
                int n=nums.pop();
                StringBuffer sb_i=new StringBuffer();
                for (int i1 = 0; i1 < n; i1++) {
                    sb_i.append(chars.peek());
                }
                if (nums.empty()){
                    nums.push(1);
                    chars.pop();
                    chars.push(sb_i);
                }
                else {
                    chars.pop();
                    chars.push(chars.pop().append(sb_i));
                }
            }

        }
        return chars.peek().toString();
    }

    public int calPoints(String[] ops){
        if (ops==null||ops.length==0)
            return 0;
        Stack<Integer> points=new Stack<>();
        int result=0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")){
                result-= points.pop();
            }
            else if (ops[i].equals("D")){
                int point=points.peek();
                points.push(2*point);
                result+=(2*point);
            }
            else if (ops[i].equals("+")){
                int val1=points.pop();
                int val2=points.pop();
                points.push(val2);
                points.push(val1);
                int point=val1+val2;
                points.push(point);
                result+=point;
            }
            else {
                int point=Integer.parseInt(ops[i]);
                points.push(point);
                result+=point;

            }
        }
        return result;
    }

    public boolean find132pattern(int[] nums) {
        if (nums==null||nums.length<=2){
            return false;
        }
        Stack<Integer> min_stack=new Stack<>();
        int[] min=new int[nums.length];
        min[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i]=Math.min(min[i-1],nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i]>min[i]){
                while (!min_stack.empty()&&min_stack.peek()<=min[i]){
                    min_stack.pop();
                }
                if (!min_stack.empty()&&min_stack.peek()<nums[i])
                    return true;
            }
            min_stack.push(nums[i]);
        }
        return false;
    }

}
