package com.learn.leetcode.everyday.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class June24_149 {
    public static void main(String[] args) {
        int[][] ints =new int[][]{{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
        June24_149 june24_149 =new June24_149();
        june24_149.maxPoints(ints);
    }
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n==1){
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                else {
                    return o1[0]-o2[0];
                }
            }
        });
        Map<String,Map<Double,Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            StringBuilder sb = new StringBuilder();
            sb.append(x1);
            sb.append('&');
            sb.append(y1);
            for (int j = i+1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                double k;
                if (x2 != x1){
                    k = (double) (y2-y1)/(x2-x1);
                }else {
                    k= Integer.MAX_VALUE;
                }
                Map<Double,Integer> m1 = map.getOrDefault(sb.toString(),new HashMap<>());
                int c = m1.getOrDefault(k,0);
                m1.put(k,c+1);
                map.put(sb.toString(),m1);
            }
        }
        int An = (map.values().stream().flatMap(f->f.values().stream()).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).get()+1)*2;
        int i =2;
        while (i*(i-1)==An){
            i++;
        }
        return i;
    }


}
