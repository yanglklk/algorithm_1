package com.leetcode.editor.cn;

//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 138 👎 0


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInBinaryMatrix{
	public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        solution.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}});

    }

	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] count = new int[n][n];
        count[0][0] = -1;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0});
        int[][] visit = new int[n][n];
        visit[0][0] = 1;
        BFS(list, visit, n, count, grid);
        return count[n - 1][n - 1]==0 ? -1:-count[n - 1][n - 1];
    }

    public void isNext(int i, int j, int n, List<int[]> list, int[][] visit, int[][] count, int[][] grid, int c) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            if (visit[i][j]==0){
                if (grid[i][j] == 0) {
                    count[i][j] = Math.min(count[i][j], c - 1);
                }
                visit[i][j]=1;
                list.add(new int[]{i,j});
            }
        }
    }

    public void BFS(List<int[]> list, int[][] visit, int n, int[][] count, int[][] grid) {
        if (list.size() == 0) {
            return;
        }
        int[] start = list.remove(0);
        int i = start[0];
        int j = start[1];
        int c = count[i][j];

        if (grid[i][j]==0){
            isNext(i - 1, j, n, list, visit, count, grid, c);
            isNext(i, j - 1, n, list, visit, count, grid, c);
            isNext(i - 1, j - 1, n, list, visit, count, grid, c);
            isNext(i + 1, j, n, list, visit, count, grid, c);
            isNext(i, j + 1, n, list, visit, count, grid, c);
            isNext(i + 1, j + 1, n, list, visit, count, grid, c);
            isNext(i - 1, j + 1, n, list, visit, count, grid, c);
            isNext(i + 1, j - 1, n, list, visit, count, grid, c);
        }
        BFS(list, visit, n, count, grid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
