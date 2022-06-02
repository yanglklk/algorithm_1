package com.learn.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

public class March27_interview0108 {
    public static void main(String[] args) {

    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<int[]> resultList = findZero(matrix);
        for (int i = 0; i < resultList.size(); i++) {
            for (int m1 = 0; m1 < m; m1++) {
                matrix[resultList.get(i)[0]][m1]=0;
            }
            for (int n1 = 0; n1 < n; n1++) {
                matrix[n1][resultList.get(i)[1]]=0;
            }
        }
    }
    public List<int[]> findZero(int[][] matrix){
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    resultList.add(new int[]{i,j});
                }
            }
        }
        return  resultList;
    }

}
