package com.leetcode.editor.cn;

//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
// Related Topics 贪心 数组 动态规划 👍 150 👎 0




import java.util.*;

public class GreatestSumDivisibleByThree{
	public static void main(String[] args) {
		Solution solution = new GreatestSumDivisibleByThree().new Solution();
		int [] ints = new int[]{3,6,5,1,8};
		solution.maxSumDivThree(ints);
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
    	int len = nums.length;
    	int[][] dp =new int[len+1][3];
    	dp[0][0] = 0;
    	dp[0][1] = Integer.MIN_VALUE;
    	dp[0][2] = Integer.MIN_VALUE;
    	int[] dp1 ={0,0,0};
//		for (int i = 1; i <= len; i++) {
//			if (nums[i-1]%3==0){
//				dp[i][0]= Math.max(nums[i-1]+dp[i-1][0],dp[i-1][0]);
//				dp[i][1]= Math.max(nums[i-1]+dp[i-1][1],dp[i-1][1]);
//				dp[i][2]= Math.max(nums[i-1]+dp[i-1][2],dp[i-1][1]);
//			}
//			else if (nums[i-1]%3==1){
//				dp[i][1]= Math.max(nums[i-1]+dp[i-1][0],dp[i-1][1]);
//				dp[i][2]= Math.max(nums[i-1]+dp[i-1][1],dp[i-1][2]);
//				dp[i][0]= Math.max(nums[i-1]+dp[i-1][2],dp[i-1][0]);
//			}
//			else {
//				dp[i][2]= Math.max(nums[i-1]+dp[i-1][0],dp[i-1][2]);
//				dp[i][0]= Math.max(nums[i-1]+dp[i-1][1],dp[i-1][0]);
//				dp[i][1]= Math.max(nums[i-1]+dp[i-1][2],dp[i-1][1]);
//			}
//		}
		//return dp[len][0];

		for (int i = 0; i < len; i++) {
			int a = dp1[0]+nums[i];
			int b = dp1[1]+nums[i];
			int c = dp1[2]+nums[i];
			dp1[a%3] = Math.max(a,dp1[a%3]);
			dp1[b%3] = Math.max(b,dp1[b%3]);
			dp1[c%3] = Math.max(c,dp1[c%3]);
		}
		return dp1[0];

//		for (int i = 1; i <= sum; i++) {
//			if (i<nums[0]){
//				continue;
//			}
//			for (int j = 0; j < len; j++) {
//				if (i == nums[j]){
//					dp[i][j]=1;
//					sums[i]=1;
//					break;
//				}
//				else if (i-nums[j]>=0){
//					int[] tep= dp[i-nums[j]];
//					if (tep[j]==0 && sums[i-nums[j]]==1){
//						dp[i]=Arrays.copyOf(tep,len);
//						dp[i][j]=1;
//						sums[i]=1;
//						break;
//					}
//				}
//
//			}
//		}
//		Map<Integer,List<Integer>> maps = new HashMap<>();
//		for (int i = sum; i >=3 ; i--) {
//			for (int j = 0; j < len; j++) {
//				if (i-nums[j]>=0){
//					List<Integer> tmp =maps.getOrDefault(i-nums[j],new ArrayList<>());
//					if (!tmp.contains(j) && sums.contains(i-nums[j])){
//						List<Integer> tepJ = new ArrayList<>();
//						tepJ.addAll(tmp);
//						tepJ.add(j);
//						maps.put(i, tepJ);
//						sums.add(i);
//						break;
//					}
//				}
//
//			}
//		}
//		for (int i = sums.size() - 1; i >= 0; i--) {
//			if (sums.get(i) % 3 ==0){
//				return sums.get(i);
//			}
//		}
		//
    }
    public void bp(int[] nums, int[] visit,  int len, List<Integer> list,int[] sums){
    	if (list.size()==len){
    		int sum = list.stream().reduce(0,Integer::sum);
			// System.out.println(list);
    		sums[sum] = 1;
    		return;
		}
		for (int i = 0; i < nums.length; i++) {
			if ( visit[i] ==0 ){
				list.add(nums[i]);
				visit[i] = 1;
				bp(nums,visit,len,list,sums);
				list.remove(list.size()-1);
				visit[i] =0;
			}
		}

	}


}
//leetcode submit region end(Prohibit modification and deletion)

}
