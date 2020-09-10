package com.yanglk.algorithm.xiaozhao_2019.jd418;

import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 0; i < n; i++) {
            Map<String,Integer> map=new HashMap<>();
            Set<Integer> set=new HashSet<>();
            for (int k = 0; k < (6); k++) {
                int l=in.nextInt();
                int w=in.nextInt();
                set.add(l);
                set.add(w);
                if (l<w){
                    int t=l;
                    l=w;
                    w=t;
                }
                String l_w=String.valueOf(l)+"_"+String.valueOf(w);
                if (map.containsKey(l_w)){
                    map.put(l_w,map.get(l_w)+1);
                }
                else {
                    map.put(l_w,1);
                }
            }

            if (map.keySet().size()<= 3&&set.size()==map.keySet().size()&&!set.contains(0)){
                boolean f=true;
                for (String s : map.keySet()) {
                    if (map.get(s)%2!=0){
                        System.out.println("IMPOSSIBLE");
                        f=false;
                        break;
                    }
                }
                if (f)
                    System.out.println("POSSIBLE");
            }
            else {
                System.out.println("IMPOSSIBLE");
            }



        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[][] nums=new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0]=in.nextInt();
            nums[i][1]=in.nextInt();
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1]? o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        int l=0;
        int r=n-1;
        int k=n;
        while (l<r){
            if (nums[l][1]<=nums[r][0]){
                k--;
            }
            l++;
            r--;
        }
        System.out.println(k);
    }
}
