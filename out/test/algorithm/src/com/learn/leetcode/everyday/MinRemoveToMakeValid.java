package com.learn.leetcode.everyday;

import org.apache.commons.lang.text.StrBuilder;

import javax.lang.model.element.VariableElement;
import java.util.*;

public class MinRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char[] chars = s.toCharArray();
        List<Integer> delI = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (chars[i]==')' ){
                if (!stack.isEmpty()){
                    stack.pop();

                }else {
                    delI.add(i);
                }
            }
            if (chars[i]=='('){
                stack.add(i);
            }
        }
        while (!stack.isEmpty()){
            delI.add(stack.pop());
        }
        StringBuffer sb =new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (!delI.contains(i)){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return count;

    }

    public int numIslands1(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]=='1'){
                    grid[i][j]='0';
                    count++;
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()){
                        int[] top = queue.poll();
                        List<int[]> list = next(top[0], top[1], n, m);
                        for (int[] ints : list) {
                            if (grid[ints[0]][ints[1]]=='1'){
                                grid[ints[0]][ints[1]]='0';
                                queue.add(ints);
                            }
                        }

                    }
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid,int i, int j,int n,int m){
        if (grid[i][j]=='0'){
            return;
        }
        List<int[]> next = next(i, j, n, m);
        grid[i][j]='0';
        for (int[] ints : next) {
            dfs(grid,ints[0],ints[1],n,m);
        }
    }
    public  List<int[]> next(int i, int j,int n,int m){
        List<int[]> list = new ArrayList<>();
        if (j>0) {
            list.add(new int[]{i,j-1});
        }
        if (j<m-1) {
            list.add(new int[]{i,j+1});
        }
        if (i>0){
            list.add(new int[]{i-1,j});
        }
        if (i<n-1) {
            list.add(new int[]{i+1,j});
        }
        return list;
    }

    Map<Integer,List<Integer>> map = new HashMap<>();
    int[] vis ;
    boolean flag = true;
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1],list);
        }
        vis = new int[numCourses];

        for (int i = 0; i < numCourses  && flag; i++) {
            if (vis[i]==0){
                dfs1(i);
            }
        }
        if (!flag){
            return new int[0];
        }
        int[] res = new int[stack.size()];
        for (int i = 0; !stack.isEmpty() ;i++) {
            res[i]=stack.pop();
        }
        return res;

    }

    public void dfs1(int i){
        vis[i]=1;
        List<Integer> next = map.getOrDefault(i,new ArrayList<>());
        for (Integer neighbor : next) {
            if (vis[neighbor]==0) {
                dfs1(neighbor);
                if (!flag){
                    return;
                }
            }
            if (vis[neighbor]==1){
                flag=false;
                return;
            }
        }
        vis[i]=2;
        stack.add(i);
    }


    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValid().findOrder(2,new int[][]{{1,0}}));
    }
}
