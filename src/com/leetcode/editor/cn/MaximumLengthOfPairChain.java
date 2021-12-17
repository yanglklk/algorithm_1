package com.leetcode.editor.cn;

//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// Related Topics 贪心 数组 动态规划 排序 👍 187 👎 0


import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain{
	public static void main(String[] args) {
		Solution solution = new MaximumLengthOfPairChain().new Solution();
		int[][] paris = new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};

		solution.findLongestChain(paris);
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
    	if (pairs.length==0){
    		return 0;
		}
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return  o1[1] - o2[1];
			}
		});
    	int count = 1;
		int minx = pairs[0][1];
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i][0]>minx){
				int maxx = pairs[i][1];
				int ii =i;
				while (ii<pairs.length){
					if (pairs[ii][1]>=maxx){
						break;
					}
					ii++;
				}
				i=ii;
				minx = pairs[i][1];
				count++;
			}
		}
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
