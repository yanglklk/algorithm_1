package com.leetcode.editor.cn;

//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。 
//
// 返回 只删除一个 子数组可获得的 最大得分 。 
//
// 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,4,5,6]
//输出：17
//解释：最优子数组是 [2,4,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,2,1,2,5,2,1,2,5]
//输出：8
//解释：最优子数组是 [5,2,1] 或 [1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 44 👎 0


import com.yanglk.algorithm.design_model.FactoryModel;
import com.yanglk.algorithm.tree_.TreeNode;
import org.apache.commons.lang.text.StrBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumErasureValue{
	public static void main(String[] args) {
		Solution solution = new MaximumErasureValue().new Solution();
		//System.out.println(solution.maximumUniqueSubarray(new int[]{4,2,4,5,6}));
		// System.out.println(solution.checkInclusion("ad","eidboaoo"));
//		String s1 = new StringBuilder("go")
//				.append("od").toString();
//		System.out.println(s1.intern() == s1);
		String s2 = new String("ja")+ new String("va");
		String s3 = "jj";
		String s4 = new String("jj");
		System.out.println(s3.intern()==s4.intern());
		System.out.println(s3==s4);
		s4.hashCode();
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s3.intern());
		System.out.println(s4.intern());
		System.out.println(s2.intern() == s2);
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
		int length = nums.length;
		int max = nums[0];
		Set<Integer> set = new HashSet<>();
		int i= 0;
		int sum =0;
		int r = 0;
		for (r = 0; r < length; r++) {
			while (set.contains(nums[r])){
				sum-=nums[i];
				set.remove(nums[i]);
				i++;
			}
			set.add(nums[r]);
			sum+=nums[r];
			max=Math.max(sum,max);
		}
		return max;
	}

	public int maximumUniqueSubarray1(int[] nums) {
		int length = nums.length;
		int max = nums[0];
		Map<Integer,Integer> map = new HashMap<>();
		int i= 0;
		int sum =0;
		int r = 0;
		for (r = 0; r < length; r++) {
			if(map.keySet().contains(nums[r])){
				sum-=map.get(nums[r]);
				map.remove(nums[r]);
			}
			sum+=nums[r];
			map.put(nums[r],sum);
			max=Math.max(sum,max);
		}
		return max;
	}

	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int i =0;
		int r =0;
		Set<Character> characters = new HashSet<>();
		int maxLen = 0;
		for ( r = 0; r < length; r++) {
			while (characters.contains(s.charAt(r))){
				characters.remove(s.charAt(i++));
			}
			characters.add(s.charAt(r));
			maxLen= Math.max(maxLen,r-i+1);
		}

		return maxLen;
	}

	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1>len2){
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i)-'a']++;
			count[s2.charAt(i)-'a']--;
		}
		int l = 0;
		for (int r = len1-1; r < len2; ) {
			boolean flag = true;
			for (int i = 0; i < count.length; i++) {
				if (count[i]!=0){
					flag = false;
					break;
				}
			}
			if (flag){
				return true;
			}
			count[s2.charAt(l++)-'a']++;
			if (++r<len2){
				count[s2.charAt(r)-'a']--;
			}


		}
		return false;

	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		return dfs(root,subRoot);
	}
	public boolean dfs(TreeNode r,TreeNode s){
    	if (r==null){
    		return false;
		}
    	return check(r,s) || dfs(r.right,s) || dfs(r.left,s);
	}
	public boolean check(TreeNode r,TreeNode s){
    	if (r==null && s ==null) {
    		return true;
		}
    	if (r==null || s==null || r.val!=s.val){
    		return false;
		}
		return check(r.right,s.right) && check(r.left,s.left);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
