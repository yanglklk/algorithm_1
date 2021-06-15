package com.learn.leetcode.everyday.june;

import java.util.*;

public class June1_743 {
    public static void main(String[] args) {


        new June1_743().networkDelayTime(new int[][]{{1,2,1},{2,3,2},{1,3,4}},3,1);
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,Map<Integer,Integer>> maps = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int ui = times[i][0];
            int vi = times[i][1];
            int wi = times[i][2];
            Map map =maps.getOrDefault(ui,new HashMap<>());
            map.put(vi,wi);
            maps.put(ui,map);
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance,-1);
        bfs(maps,k,distance,n);
        int maxDistance = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == -1){
                return -1;
            }
            maxDistance = Math.max(maxDistance,distance[i]);
        }
        return maxDistance;

    }
    public void bfs( Map<Integer,Map<Integer,Integer>> maps, int k, int[] distance, int n){
        Queue<Integer> queue =new ArrayDeque<>();
        queue.offer(k);
        distance[k] = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();
            Map<Integer,Integer> nears = maps.getOrDefault(now,null);
            if (nears != null && nears.keySet() != null){
                nears.keySet().stream().filter(f -> distance[f] == -1 || distance[f] > distance[now] + nears.get(f) ).forEach(f -> {
                    queue.offer(f);
                    distance[f] = distance[f] == -1 ? 0 : distance[f];
                    distance[f] = distance[now] + nears.get(f);
                } );
            }
        }
    }

}
