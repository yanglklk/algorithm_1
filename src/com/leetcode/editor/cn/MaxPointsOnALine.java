package com.leetcode.editor.cn;

//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// points 中的所有点 互不相同 
// 
// Related Topics 几何 哈希表 数学 
// 👍 334 👎 0




import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MaxPointsOnALine{
	public static void main(String[] args) {
		int[][] ints =new int[][]{{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
		//int[][] ints =new int[][]{{0,0},{1,1},{2,2}};
		ints=  new int[][]{{54,153},{1,3},{0,-72},{-3,3},{12,-22},{-60,-322},{0,-5},{-5,1},{5,5},{36,78},{3,-4},{5,0},{0,4},{-30,-197},{-5,0},{60,178},{0,0},{30,53},{24,28},{4,5},{2,-2},{-18,-147},{-24,-172},{-36,-222},{-42,-247},{2,3},{-12,-122},{-54,-297},{6,-47},{-5,3},{-48,-272},{-4,-2},{3,-2},{0,2},{48,128},{4,3},{2,4}};
		Solution solution = new MaxPointsOnALine().new Solution();
		solution.maxPoints(ints);
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
		int n = points.length;
		if (n==1){
			return 1;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0]){
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
			}
		});
		Map<Double,Map<Double,Integer>> map = new HashMap<>();
		DecimalFormat    df   = new DecimalFormat("######0.000000");
		for (int i = 0; i < n; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			for (int j = i+1; j < n; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];
				double k;
				double b;
				if (x2 != x1){
					k = (double) (y2-y1)/ (x2-x1);
					b = y1-k*x1;
				}else {
					k= Integer.MAX_VALUE;
					b = x2;
				}
				List<Double> kset = map.keySet().stream().filter(kk-> Math.abs(kk-k)<0.000000000001).collect(Collectors.toList());
				if(kset.isEmpty()){
					Map<Double,Integer> mapi = new HashMap<>();
					mapi.put(b,1);
					map.put(k,mapi);
				}
				else {
					Map<Double,Integer> mapi= map.get(kset.get(0));
					List<Double> bset = mapi.keySet().stream().filter(bb-> Math.abs(bb-b)<0.000000000001).collect(Collectors.toList());
					if (bset.isEmpty()){
						mapi.put(b,1);
					}
					else {
						mapi.put(bset.get(0),mapi.get(bset.get(0))+1);
					}
					map.put(kset.get(0),mapi);
				}
			}
		}

		int An = map.values().stream().flatMap(f->f.values().stream()).max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}).get() *2;

		int i =2;
		while (i*(i-1)<An){
			i++;
		}
		return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
