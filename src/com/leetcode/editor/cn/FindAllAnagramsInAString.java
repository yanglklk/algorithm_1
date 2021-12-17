package com.leetcode.editor.cn;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 706 👎 0


import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString{
	public static void main(String[] args) {
		Solution solution = new FindAllAnagramsInAString().new Solution();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int lenP = p.length();
		if (lenP>s.length()){
			return result;
		}

    	int[] mapP = new int[26];
    	int[] mapS = new int[26];

		for (char c : p.toCharArray()) {
			mapP[c-'a']++;
		}
		for (char c : s.substring(0, lenP).toCharArray()) {
			mapS[c-'a']++;
		}
		int l = 0;
		int r = lenP;

		while (r<=s.length()){
			boolean flag = arrayCompare(mapP,mapS,26);
			if (flag){
				result.add(l);
			}
			if (r<s.length()){
				mapS[s.charAt(l)-'a']--;
				mapS[s.charAt(r)-'a']++;
			}
			l++;
			r++;
		}
		return result;
    }
    public boolean arrayCompare(int[] a ,int[] b, int n){
    	int i = 0;
    	while (i<n){
    		if (a[i]!=b[i]){
    			return false;
			}
    		i++;
		}
    	return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
