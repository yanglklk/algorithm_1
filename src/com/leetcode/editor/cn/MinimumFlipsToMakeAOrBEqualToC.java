package com.leetcode.editor.cn;

//给你三个正整数 a、b 和 c。 
//
// 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算 a OR b == c 成立的最小翻转次数。 
//
// 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：a = 2, b = 6, c = 5
//输出：3
//解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c 
//
// 示例 2： 
//
// 输入：a = 4, b = 2, c = 7
//输出：1
// 
//
// 示例 3： 
//
// 输入：a = 1, b = 2, c = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 10^9 
// 1 <= b <= 10^9 
// 1 <= c <= 10^9 
// 
// Related Topics 位运算 👍 32 👎 0


import com.yanglk.algorithm.offer.Str;

public class MinimumFlipsToMakeAOrBEqualToC{
	public static void main(String[] args) {
		Solution solution = new MinimumFlipsToMakeAOrBEqualToC().new Solution();
		solution.minFlips(2,6,5);
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlips(int a, int b, int c) {
		String sa = Integer.toBinaryString(a);
		String sb = Integer.toBinaryString(b);
		String sc = Integer.toBinaryString(c);

		int len = Math.max(Math.max(sa.length(),sb.length()),sc.length());

		StringBuffer addStr =new StringBuffer("");
		for (int i = 0; i < (len - sa.length()); i++) {
			addStr.append("0");
		}
		sa = addStr.toString()+sa;
		addStr=new StringBuffer("");
		for (int i = 0; i < (len - sb.length()); i++) {
			addStr.append("0");
		}
		sb = addStr.toString()+sb;

		addStr=new StringBuffer("");
		for (int i = 0; i < (len - sc.length()); i++) {
			addStr.append("0");
		}
		sc = addStr.toString()+sc;

		int count =0;
		for (int i = 0; i < len; i++) {
			char ca = sa.charAt(i);
			char cb = sb.charAt(i);
			char cc = sc.charAt(i);

			if (Math.max(ca,cb)==cc){
				continue;
			}
			if (cb==ca && cb=='1' && cc=='0' ){
				count+=2;
			}
			else {
				count++;
			}

		}


//		System.out.println(sa);
//		System.out.println(sb);
//		System.out.println(sc);
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
