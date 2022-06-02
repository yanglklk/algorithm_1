package com.yanglk.algorithm.other_;

import java.util.ArrayList;

class NumMatrix {
    private int[][] sums;
    public NumMatrix(int[][] matrix) {
        if (matrix==null||matrix.length==0)
            sums=null;
        else {
            int m = matrix.length;
            int n = matrix[0].length;
            sums = new int[m][n];
            int s = 0;
            int[][] sumrow = new int[m][n];
            int[][] sumclo = new int[m][n];
            for (int i = 0; i < m; i++) {
                s = 0;
                for (int j = 0; j < n; j++) {
                    s += matrix[i][j];
                    sumrow[i][j] = s;
                }
            }
            for (int i = 0; i < n; i++) {
                s = 0;
                for (int j = 0; j < m; j++) {
                    s += matrix[j][i];
                    sumclo[j][i] = s;
                }
            }
            s = 0;
            for (int i = 0; i < m; i++) {
                s += matrix[i][0];
                sums[i][0] = s;
            }
            s = 0;
            for (int i = 0; i < n; i++) {
                s += matrix[0][i];
                sums[0][i] = s;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    sums[i][j] = sums[i - 1][j - 1] + sumclo[i - 1][j] + sumrow[i][j - 1] + matrix[i][j];
                }
            }
        }
//        p(matrix);
//        p(sumrow);
//        p(sumclo);
//        p(sums);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int s1=row1<1||col1<1? 0:sums[row1-1][col1-1];
        int s2=sums[row2][col2];
        int s3=row1<1? 0:sums[row1-1][col2];
        int s4=col1<1? 0:sums[row2][col1-1];
        return s2-s3-s4+s1;
    }
    public static  void p(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("___________________________");
    }
public static void main(String[] args) {

    int[][] m={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
    NumMatrix x=new NumMatrix(m);
    System.out.println(x.sumRegion(1,2,2,4));

    ArrayList list=new ArrayList();
    list.add('s');
    System.out.println(list.contains('s'));
    list.remove(new Character('a'));
    System.out.println(list);
    }

}
