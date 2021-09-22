package com.leetcode.editor.cn;

//给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一
//个整数。 
//
// 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 
//[1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。 
//
// 返回使数组 互补 的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,4,3], limit = 4
//输出：1
//解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
//nums[0] + nums[3] = 1 + 3 = 4.
//nums[1] + nums[2] = 2 + 2 = 4.
//nums[2] + nums[1] = 2 + 2 = 4.
//nums[3] + nums[0] = 3 + 1 = 4.
//对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,1], limit = 2
//输出：2
//解释：经过 2 次操作，你可以将数组 nums 变成 [2,2,2,2] 。你不能将任何数字变更为 3 ，因为 3 > limit 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,1,2], limit = 2
//输出：0
//解释：nums 已经是互补的。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 105 
// 1 <= nums[i] <= limit <= 105 
// n 是偶数。 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 50 👎 0


import java.util.*;
import java.util.stream.Collectors;

public class MinimumMovesToMakeArrayComplementary{
	public static void main(String[] args) {
		Solution solution = new MinimumMovesToMakeArrayComplementary().new Solution();
		solution.minMoves(new int[]{1,2,4,3},4);
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int minMoves(int[] nums, int limit) {
		int[] diff = new int[2*limit+2];
		int n = nums.length;
		for (int i = 0; i < n/2; i++) {
			int l = Math.min(nums[i],nums[n-1-i]);
			int r = Math.max(nums[i],nums[n-1-i]);
			diff[2] += 2;
			diff[2*limit+1] -= 2;

			diff[l+1] += -1;
			diff[r+limit+1] -=-1;

			diff[l+r] += -1;
			diff[l+r+1] -= -1;
		}
		int res = n;
		int sum = 0;
		for (int i = 2; i <= limit*2; i++) {
			sum += diff[i];
			res = Math.min(sum,res);
		}
		return res;
	}
    public int minMoves1(int[] nums, int limit) {
    	int count = 0;
    	int n = nums.length;
		Map<Integer, List<Integer>> map =new HashMap<>();
		int minSum = Integer.MAX_VALUE;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n/2; i++) {
			int sum = nums[i]+nums[n-1-i];
			List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
			list.add(i);
			map.put(sum,list);
			minSum = Math.min(sum,minSum);
			maxSum = Math.max(sum,maxSum);
		}
		if (map.keySet().size()==1){
			return count;
		}
		count = Integer.MAX_VALUE;
		int start = minSum;
		int end = 2*limit < maxSum ? 2*limit:maxSum;
		for (int key = end; key >= start; key--) {
			int iCount = 0;
			for (int i = 0; i < (n/2); i++) {
				if (nums[i]+nums[n-1-i] != key){
					int imin = Math.min(nums[i],nums[n-1-i]);
					int imax = Math.max(nums[i],nums[n-1-i]);
					if (imax+limit<key || imin>=key){
						iCount += 2;
					}
					else {
						iCount++;
					}
					if ( iCount>n/2 || iCount>=count){
						break;
					}
				}
			}
			count = Math.min(iCount,count);

		}
    	return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
