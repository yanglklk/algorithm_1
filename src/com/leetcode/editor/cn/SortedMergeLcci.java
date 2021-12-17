package com.leetcode.editor.cn;

//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 排序 👍 122 👎 0


public class SortedMergeLcci{
	public static void main(String[] args) {
		Solution solution = new SortedMergeLcci().new Solution();
		solution.merge(new int[]{2,0},1, new int[]{1},1);
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
    	int index = m+n-1;
    	m--;
    	n--;
		for (int i = index; i >= 0; i--) {
			if (m<0 || n<0){
				break;
			}
			int a = A[m];
			int b = B[n];
			if (a>b){
				A[i]=a;
				m--;
			}else {
				A[i]=b;
				n--;
			}
		}
		if (n>=0){
			for (int i = n; i >= 0; i--) {
				A[i] =B[i];
			}
		}

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
