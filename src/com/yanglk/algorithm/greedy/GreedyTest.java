package com.yanglk.algorithm.greedy;

import com.sun.corba.se.spi.orb.ParserImplBase;
import com.yanglk.algorithm.leetcode.PowerOfThree;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class GreedyTest {
    public static void main(String[] args) {
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        int[] p={5,1,2,3,4};
        int[] q={0,2,4,6,7,1,3,5};
       // System.out.println(new Solution().reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}));
//        new Solution().findMinArrowShots(points);
        String s="())";
        System.out.println(new Solution().minAddToMakeValid(s));
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length && j < g.length; i++) {
            if (g[j] <= s[i]) {
                j++;
            }
        }
        return j;

    }

    public int findMinArrowShots(int[][] points) {
        if (points==null||points.length==0)
            return 0;
        Arrays.sort(points,(p1,p2)->{
            if (p1[0]==p2[0])
                return p1[1]-p2[1];
            else {
                return p1[0]-p2[0];
            }
        });

        int count=1;
        int end=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]<=end){
                end=Math.min(end,points[i][1]);
            }
            else {
                end=points[i][1];
                count++;
            }
        }
        return count;
    }

    public int mixProfit(int[] prices){
        if (prices==null||prices.length<2)
            return 0;
        int min=prices[0];
        int res=0;
        for (int i = 1; i < prices.length; i++) {
//            if (prices[i]<prices[i-1]){
//                min=
//            }
            if (prices[i]<min){
                min=prices[i];
                int j=i+1;
                for (;j<prices.length;j++){
                    if (prices[j]<=prices[j-1]){
                        break;
                    }
                }
                res=res+(prices[j-1]-min);
                i=j-1;
                min=prices[i];
            }
            else {
                res=res+(prices[i]-min);
                min=prices[i+1];
            }
        }
        return res;
    }

    public boolean isSubsequence(String s,String t){
        if (s.length()>t.length())
            return false;
        char[] chars=s.toCharArray();
        int star=0;
        for (int i = 0; i < chars.length; i++) {
            int index=t.substring(star).indexOf(chars[i]);
            if (index==-1)
                return false;
            star=star+index+1;
        }
        return true;
    }

    public int canCompleteCircuit(int[] gas,int[] cost){
        int sum_gas=0;
        int sum_cost=0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i]>=cost[i]){
                int j=(i+1)% gas.length;
                sum_gas=gas[i];
                sum_cost=0;
                for (;j!=i;){
                    sum_cost=cost[(j-1+gas.length)%gas.length];
                    sum_gas+=(gas[j]-sum_cost);
                    if (sum_gas<cost[j]){
                        break;
                    }
                    j=(j+1)%gas.length;
                }
                if (j==i){
                    return i;
                }

            }
        }
        return -1;
    }

    public int wiggleMaxLength(int[] nums){
        if(nums==null||nums.length<2)
            return nums.length;

        int[] tag=new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
           int t=(nums[i]-nums[i+1]);
           if (t>0)
               tag[i]=1;
           else if (t<0)
               tag[i]=-1;
           else
               tag[i]=0;
        }
        int max_count=tag[0]==0? 1:2;
        int j=0;
        for (int i = 1; i < tag.length&&j<tag.length; i++) {
            if (tag[j]!=tag[i]&&tag[i]!=0){
                max_count++;
                j=i;
            }
        }
        return max_count;
    }

    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people,(p1,p2)->{
            if (p1[0]==p2[0])
                return p1[1]-p2[1];
            return p2[0]-p1[0];
        });
        ArrayList<int[]> l=new ArrayList<>();
        for (int[] i : people){
            l.add(i[1],i);
        }
        return l.toArray(new int[0][]);
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        char[] chars=num.toCharArray();
        stack.push(chars[0]);
        int c=0;
        for (int i = 1; i < chars.length; i++) {
            while (c<k&&!stack.empty()&&stack.peek()>chars[i]){
                stack.pop();
                c++;
            }
            stack.push(chars[i]);
        }
        StringBuffer sb=new StringBuffer();
        for (Character character : stack) {
                sb.append(character);
        }
        String s=sb.substring(0,chars.length-k);
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i)!='0')
                break;
        }
        s=s.substring(i);
        return s.length()==0? "0":s;


    }

    public int monotoneIncreasingDigits(int N) {
        int n = N;
        char[] c=Integer.toString(n).toCharArray();
        char[] res=new char[c.length];
        for (int i = c.length - 1; i >= 1; i--) {
            if (c[i]>=c[i-1]){
                res[i]=c[i];
            }
            else {
                for (int i1 = i; i1 < c.length; i1++) {
                    res[i1]='9';
                }
                c[i-1]=(char) (c[i-1]-1);
            }
        }
        res[0]=c[0];
        int k=0;
        for (int i = 0; i < res.length; i++) {
            int t=res[i]-'0';
            k=k*10+t;
        }
        return k;
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> list=new ArrayList<>();
        if (S==null||S.length()==0)
            return list;
        int[][] se=new int[26][2];
        for (int i = 0; i < se.length; i++) {
            se[i][0]=-1;
            se[i][1]=-1;
        }
        for (int i = 0; i < S.length(); i++) {
            int t=S.charAt(i)-'a';
            if (se[t][0]==-1){
                se[t][0]=i;
                se[t][1]=i;
            }
            else {
                se[t][1]=i;
            }
        }
        Arrays.sort(se, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int i=0;
        for (; i < se.length; i++) {
            if (se[i][0] != -1)
                break;
        }
        int s=se[i][0];
        int e=se[i][1];
        int len=e-s+1;
        for (; i < se.length; i++) {
            if (se[i][0]<=e){
                e=Math.max(e,se[i][1]);
                len=e-s+1;
            }
            else {
                list.add(len);
                s=se[i][0];
                e=se[i][1];
                len=e-s+1;
            }
        }
        list.add(len);
        return list;
    }

    public boolean lemonadeChange(int[] bills) {
        int m_5=0;
        int m_10=0;
        int m_20=0;
        if (bills[0]!=5)
            return false;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5){
                m_5++;
            }
            else if (bills[i]==10){
                if (m_5>0){
                    m_5--;
                    m_10++;
                }
                else return false;
            }
            else {
                if (m_5>0&&m_10>0){
                    m_5--;
                    m_10--;
                    m_20++;
                }
                else if (m_5>2){
                    m_5-=3;
                    m_20++;
                }
                else return false;
            }
        }
        return true;
    }

    public int matrixScore(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        for (int i = 0; i < n; i++) {
            if (A[i][0]==0){
                for (int i1 = 0; i1 < A[i].length; i1++) {
                    A[i][i1]=A[i][i1]==1? 0:1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            int c=0;
            for (int i1 = 0; i1 < n; i1++) {
                if (A[i1][i]==0)
                    c++;
            }
            if (c>n/2.0){
                for (int i1 = 0; i1 < n; i1++) {
                    A[i1][i]=A[i1][i]==1? 0:1;
                }
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            int t=0;
            for (int j = 0; j < m; j++) {
                if (A[i][j]==1){
                    t+=(int) Math.pow(2,m-j-1);
                }
            }
            sum+=t;
        }
        return sum;
    }

    public String reorganizeString(String S) {
        int[][] counts=new int[26][2];
        char[] chars=S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
           counts[chars[i]-'a'][0]=chars[i]-'a';
           counts[chars[i]-'a'][1]++;
        }
        Arrays.sort(counts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        if (counts[0][1]>Math.ceil(chars.length/2.0))
            return "";
        StringBuffer sb1=new StringBuffer();
        for (int i = 0; i < counts.length; i++) {
            for (int i1 = 0; i1 < counts[i][1]; i1++) {
                sb1.append((char) (counts[i][0]+'a'));
            }
            if (counts[i][1]==0)
                break;
        }
        chars=sb1.toString().toCharArray();
        StringBuffer sb=new StringBuffer();
        if (chars.length%2==0){
            int i=0;
            int j=chars.length/2;
            while (j<chars.length){
                sb.append(chars[i++]);
                sb.append(chars[j++]);
            }
        }
        else {
            int i=0;
            int j=chars.length/2+1;
            while (j<chars.length){
                sb.append(chars[i++]);
                sb.append(chars[j++]);
            }
            sb.append(chars[i]);
        }
        return  sb.toString();
    }

    public int minSwapsCouples(int[] row) {
        int[] index=new int[row.length];
        for (int i = 0; i < row.length; i++) {
            index[row[i]]=i;
        }
        int c=0;
        for (int i = 0; i < row.length; i=i+2) {
            if (row[i]%2==0){
                if (row[i+1]==row[i]+1){
                    continue;
                }
                else {
                    int point1=i+1;
                    int point2=index[row[i]+1];
                    int temp=row[point1];
                    row[point1]=row[point2];
                    row[point2]=temp;
                    index[row[point1]]=point1;
                    index[row[point2]]=point2;
                    c++;
                }
            }
            else {
                if (row[i+1]==row[i]-1){
                    continue;
                }
                else {
                    int point1=i+1;
                    int point2=index[row[i]-1];
                    int temp=row[point1];
                    row[point1]=row[point2];
                    row[point2]=temp;
                    index[row[point1]]=point1;
                    index[row[point2]]=point2;
                    c++;
                }

            }
        }
        return c;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list=new ArrayList<>();
        int k=1;
        for (int i = 0; i < S.length(); i++) {

        }
        return list;
    }

    public int minAddToMakeValid(String S) {
        int left=0;
        char[] chars=S.toCharArray();
        int count=0;
        int i=0;
        for (; i < chars.length; i++) {
            if (chars[i]=='('){
                break;
            }
        }
        if (i==chars.length){
            return i;
        }
        count=i++;
        left=1;
        for (; i < chars.length; i++) {
            if (chars[i]=='('){
                left++;
            }
            else {
                if (left>0){
                    left--;
                }
                else {
                    count++;
                }
            }
        }
        count+=left;
        return count;
    }


}



