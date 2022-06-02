package com.yanglk.algorithm.offer;

import com.sun.xml.internal.ws.handler.HandlerException;
import com.yanglk.algorithm.tree_.TreeNode;

import java.lang.annotation.ElementType;
import java.util.*;

public class Array {
    public static void main(String[] args) {
     int[] array={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
      //  int[] array={3,6,5,4,2,1,7,9};
        int[] n1=new int[1];
     int[] n2=new int[1];

//        System.out.println(new Array().GetLeastNumbers_Solution(array,4));
        System.out.println(new Array().InversePairs(array));


    }
    public void reOrderArray(int [] array) {
        int[] help=new int[array.length];
        int j=0;
        int k=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                help[k++]=array[i];
            }
            else {
                array[j++]=array[i];
            }
        }
        k=0;
        while(j<array.length){
            array[j++]=help[k++];
        }

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int count=0;
        int result=array[0];
        for (int i = 0 ;i < array.length; i++) {
            if (array[i] == result) {
                count++;
            } else {
                if (count == 0) {
                    count = 1;
                    result = array[i];
                } else {
                    count--;
                }
            }
        }
        count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==result)
                count++;
        }
        if (count>(array.length)/2){
            return result;
        }
        else
            return 0;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list=new ArrayList<>();
        if (k==0||input==null||input.length==0||input.length<k)
            return list;

        Queue<Integer> max_=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        max_.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (i<k){
                max_.offer(input[i]);
            }
            else {
                if (input[i]<max_.peek()){
                    max_.poll();
                    max_.offer(input[i]);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(max_.poll());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return list;

    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
            if (sum<array[i]){
                sum=array[i];
            }
           max=Math.max(max,sum);
        }
        return max;

    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for (int i = 1; i <=n; i++) {
            int temp=i;
            while (temp!=0){
                if (temp%10==1)
                    count++;
                temp/=10;
            }
        }
        return count;

    }

    public int GetUglyNumber_Solution(int index) {
        if (index<7)
            return index;
        List<Integer> ugly=new ArrayList<>();
        int p2=0;
        int p3=0;
        int p5=0;
        ugly.add(1);
        while (ugly.size()<index){
            int temp=Math.min(ugly.get(p2)*2,Math.min(ugly.get(p3)*3,ugly.get(p5)*5));
            if (ugly.get(p2)*2==temp)
                p2++;
            if (ugly.get(p3)*3==temp)
                p3++;
            if (ugly.get(p5)*5==temp)
                p5++;
            ugly.add(temp);
        }
        return ugly.get(index-1);

    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;
        return isTree(sequence,0,sequence.length-1);

    }

    public boolean isTree(int[] sequence,int s,int e){
        if (s>=e)
            return true;
        int m=s;
        while (m<e){
            if (sequence[m]>sequence[e])
                break;
            m++;
        }
        for (int i = m; i < e; i++) {
            if (sequence[i]<sequence[e])
                return false;
        }
        return isTree(sequence,s,m-1)&&isTree(sequence,m,e-1);


    }

    public int GetNumberOfK(int [] array , int k) {
        int count=0;
        for (int i : array) {
            if (i==k)
                count++;
            if (i>k)
                break;
        }
        return count;

    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])){
                set.add(array[i]);
            }
            else {
                set.remove(array[i]);
            }
        }
        Iterator<Integer> it=set.iterator();
        num1[0]=it.next();
        num2[0]=it.next();

    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        if (num==null||num.length<size||size<=0)
            return list;
        for (int i = 0; i <= num.length-size; i++) {
            max=num[i];
            for (int j = i; j < (i+size); j++) {
                max=Math.max(max,num[j]);
            }
            list.add(max);
        }
        return list;


    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length<=1)
            return false;
        int[] help=new int[length];
        for (int number : numbers) {
            if (help[number]==1){
                duplication[0]=number;
                return true;
            }
            help[number]=1;
        }
        return false;

    }

    public int Sum_Solution(int n) {
        int sum=n;
        boolean ans=(n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;


    }

    public int Add(int num1,int num2) {
        while (num2!=0){
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > lists=new ArrayList<>();

        int i=1;
        while (i<=sum/2){
            int k=0;
            int c;
            ArrayList<Integer> list=new ArrayList<>();
            while (k<sum/i){
                list.add((i+k));
                c=(2*i+k)*(k+1)/2;
                if (c<sum){
                    k++;
                    continue;
                }
                if (c==sum){
                    lists.add(list);
                    break;
                }else {
                    break;
                }
            }
            i++;
        }
        ArrayList<Integer> l=new ArrayList<>();
        l.add(sum);
        lists.add(l);
        return lists;

    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<>(2);
        int len;
        if (array==null||(len=array.length)==0)
            return list;
        int mul=Integer.MAX_VALUE;
        int i=0;
        int j=len-1;
        while (i<j) {
            int s=array[i]+array[j];
            int m=array[i]*array[j];
            if (s<sum){
                i++;
                continue;
            }
            else if (s==sum){
                if (m<mul){
                    list.clear();
                    list.add(array[i]);
                    list.add(array[j]);
                    mul=m;
                }
                i++;
                j--;
            }
            else {
                j--;
                continue;
            }

        }
        return list;

    }

    public boolean isContinuous(int [] numbers) {

        int len;
        if (numbers==null||(len=numbers.length)==0){
            return false;
        }
        Arrays.sort(numbers);
        int i=0;
        int count_0=0;
        int temp;
        while (i<len&&numbers[i]==0){
            count_0++;
            i++;
        }
        temp=numbers[i]-1;
        while (i<len){
            if (temp+1==numbers[i]){
                temp++;
                i++;
            }
            else if (count_0>0){
                count_0--;
                temp++;
            }
            else {
                return false;
            }
        }
        return i==len;
    }

    public int LastRemaining_Solution(int n, int m) {
        if (m*n<=0)
            return -1;
        int[] mark=new int[n];
        int count=n;
        int i=0;
        int j=0;
        while (true){
            if (mark[i%n]==0){
                if (j==m-1){
                    mark[i%n]=-1;
                    j=0;
                    count--;
                }else {
                    j++;
                }
                if (count==0){
                    return i%n;
                }
            }
            i++;
        }
//        return -1;
    }

    public int[] multiply(int[] A) {
        int len=A.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int[] res=new int[len];
        int mul_left=A[0];
        int mul_right=A[len-1];
        for (int i = 1; i < A.length; i++) {
            left[i]=mul_left;
            mul_left*=A[i];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            right[i]=mul_right;
            mul_right*=A[i];
        }
        right[len-1]=1;
        left[0]=1;
        for (int i = 0; i < res.length; i++) {
            res[i]=left[i]*right[i];
        }
        return  res;

    }

    public int cutRope(int target) {
        if (target==2||target==3)
            return target-1;
        int[] opt=new int[target+1];
        opt[0]=1;
        opt[1]=1;
        opt[2]=2;
        opt[3]=3;
        for (int i = 4; i < opt.length; i++) {
            int k=1;
            while (k<i){
                opt[i]=Math.max(opt[i],opt[i-k]*k);
                k++;
            }
        }
        return opt[target];

    }

    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] mark=new int[rows][cols];
        int count=0;
        int num_i=0;
        int num_j=0;
        for (int i = 0; i < rows; i++) {
            int temp_i=i;
            while (temp_i!=0){
                num_i+=temp_i%10;
                temp_i/=10;
            }
            for (int j = 0; j < cols; j++) {
                int temp_j=j;
                while (temp_j!=0){
                    num_j+=temp_j%10;
                    temp_j/=10;
                }
                if (num_i+num_j<=threshold){
                    if (i-1>0);
                }
                num_j=0;
            }
            num_i=0;
            num_j=0;
        }
        return count;
    }
    int count;
    public int InversePairs(int [] array) {
        if (array==null||array.length==0)
            return 0;
        inverse(array,0,array.length-1);
        return (int)((int)(count)%1000000007);
    }

    public void inverse(int[] array,int start,int end){
        if (start<end) {
            int mid=(start+end)/2;
            inverse(array,start,mid);
            inverse(array,mid+1,end);
            merge1(array,start,end);
//            int i=mid;
//            int j=mid+1;
//            while (j<=end){
//
//                int temp=array[j];
//                while (i>=start&&array[i]>temp){
//                    array[i+1]=array[i];
//                    array[i]=temp;
//                    i--;
//                    count++;
//                }
//                i=j;
//                j++;
//
//            }
        }
    }
    public void merge1(int[] array,int start,int end){
        int mid=(start+end)/2;
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=end){
            if (array[i]<=array[j]){
                temp[k++]=array[i++];
            }
            else{
                temp[k++]=array[j];
                count+=(j-mid);
                j++;
            }
        }
        if (i<=mid){
            temp[k++]=array[i++];
            while (i<=mid){
                temp[k++]=array[i++];
                count+=(end-mid);
            }
        }
        if (j<=end){
            while (j<=end){
                temp[k++]=array[j++];
            }
        }
        for (int i1 = 0; i1 < temp.length; i1++) {
            array[start+i1]=temp[i1];
        }
    }
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1])
                return array[i+1];
        }
        return array[0];
    }







}
