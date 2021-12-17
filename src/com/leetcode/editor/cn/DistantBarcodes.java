package com.leetcode.editor.cn;

//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 输入：[1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 73 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class DistantBarcodes{
	public static void main(String[] args) {
		Solution solution = new DistantBarcodes().new Solution();
		int[]  bb= new int[]{1,1,2};
		solution.rearrangeBarcodes(bb);
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
    	if (barcodes.length==1){
    		return barcodes;
		}
		int[] result = new int[barcodes.length];
		Arrays.sort(barcodes);
		List<Integer> list =new ArrayList<>();

		int l =0;
		int r =barcodes.length-1;
		while (l<=r){
			if (l==r){
				addToList(barcodes[l],list);
			}
			int lNum = barcodes[l];
			int rNum = barcodes[r];
			if (lNum!=rNum){
				list.add(lNum);
				list.add(rNum);
			}else {
				addToList(lNum,list);
				addToList(rNum,list);
			}
			l++;
			r--;
		}

		for (int i = 0; i < list.size(); i++) {
			result[i]=list.get(i);
		}
		return result;

    }
    public void addToList(int num,List<Integer> list){
		for (int i = 0; i < list.size(); i++) {
			if (i == 0 && list.get(0)!=num){
				list.add(0,num);
				break;
			}else if (i== list.size()-1 && list.get(list.size()-1) !=num){
				list.add(list.size(),num);
				break;
			}
			else if (i != 0 && i!= list.size()-1 &&list.get(i-1) != num && list.get(i)!=num){
				list.add(i,num);
				break;
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
