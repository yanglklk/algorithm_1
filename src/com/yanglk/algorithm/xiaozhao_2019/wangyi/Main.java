package com.yanglk.algorithm.xiaozhao_2019.wangyi;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        float[] scores=new float[n];
        Map<Float,Integer> map=new HashMap<>();
        Set<Float> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            float t=sc.nextFloat();
            scores[i]=t;
            set.add(t);
        }
        for (Float aFloat : set) {
            int c=0;
            for (float v : scores) {
                if (v<=aFloat)
                    c++;
            }
            map.put(aFloat,c);
        }
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            double f= (double) ((map.get(scores[sc.nextInt()-1])-1.0)/(float)(n)*100.0);
            System.out.printf("%.6f\n",f);
        }
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < q; i++) {
            int x=sc.nextInt();
            int c=0;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j]>=x){
                    nums[j]--;
                    c++;
                }
                else {
                    break;
                }
            }
            System.out.println(c);
            Arrays.sort(nums);
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int x=sc.nextInt();
            int c=0;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j]>=x){
                    nums[j]--;
                    c++;
                }

            }
            System.out.println(c);

        }

    }
}
