package com.leetcode.editor.cn;

//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 字符串 👍 246 👎 0


import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestStringWithSwaps{
	public static void main(String[] args) {
		Solution solution = new SmallestStringWithSwaps().new Solution();
		System.out.println(129== new Integer(129));
		//solution.smallestStringWithSwaps("dcab", Lists.newArrayList(Lists.newArrayList(0,3),Lists.newArrayList(1,2),Lists.newArrayList(0,2)));
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    	if (pairs.size()==0){
    		return s;
		}
		int len = s.length();
    	Union union = new Union(len);
		for (List<Integer> pair : pairs) {
			int i = pair.get(0);
			int j = pair.get(1);
			union.union(i,j);
		}
		Map<Integer,Set<Integer> > unions =new HashMap<>();
		for (int i = 0; i < len; i++) {
			int root = union.find(i);
			// TreeSet 会排序 这里要求最后元素的位置也是排好序的
			Set<Integer> set = unions.getOrDefault(root,new TreeSet<>());
			set.add(i);
			unions.put(root,set);
		}
		System.out.println(unions.values());

    	char[] results = new char[len];
		for (Set<Integer> unioni : unions.values().stream().collect(Collectors.toList())) {
			List<Character> characters = unioni.stream().map(c->s.charAt(c)).sorted().collect(Collectors.toList());
			System.out.println(characters);
    		int i =0;
			for (Integer num : unioni) {
				results[num]=characters.get(i++);
			}
		}
		return String.valueOf(results);

    }

    class Union {
    	int n;
    	int[] parent;
    	int[] rank;

		public Union(int n) {
			this.n = n;
			this.parent = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i]=i;
				rank[i]=1;
			}
		}

		public int find(int x){
    		if (parent[x]!=x){
    			parent[x]=find(parent[x]);
			}
    		return parent[x];
		}
		public void union(int x ,int y){
			int px = find(x);
			int py = find(y);
			if (px == py){
				return;
			}
			if (rank[px] == rank[py]){
				parent[px] = py;
				rank[px]++;
			}
			else if (rank[px]<rank[py]){
				parent[py] = px;
			}else {
				parent[px] = py;
			}
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
