package com.leetcode.editor.cn;

//编写一个 SQL 查询来实现分数排名。 
//
// 如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。 
//
// +----+-------+
//| Id | Score |
//+----+-------+
//| 1  | 3.50  |
//| 2  | 3.65  |
//| 3  | 4.00  |
//| 4  | 3.85  |
//| 5  | 4.00  |
//| 6  | 3.65  |
//+----+-------+
// 
//
// 例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）： 
//
// +-------+------+
//| Score | Rank |
//+-------+------+
//| 4.00  | 1    |
//| 4.00  | 1    |
//| 3.85  | 2    |
//| 3.65  | 3    |
//| 3.65  | 3    |
//| 3.50  | 4    |
//+-------+------+
// 
//
// 重要提示：对于 MySQL 解决方案，如果要转义用作列名的保留字，可以在关键字之前和之后使用撇号。例如 `Rank` 
// Related Topics 数据库 
// 👍 780 👎 0


public class RankScores{
	public static void main(String[] args) {

		// row_number() 在排名是序号 连续 不重复，即使遇到表中的两个一样的数值亦是如此

		//  rank() 函数会把要求排序的值相同的归为一组且每组序号一样，排序不会连续执行

		// dense_rank() 排序是连续的，也会把相同的值分为一组且每组排序号一样
		/*
		select Score,
		dense_rank() over (order by Score desc)
		AS 'Rank'
		from Scores
		 */
		// ntile(group_num) 将所有记录分成group_num个组，每组序号一样
		/*
		select Score,
		Ntile(4) over (order by Score )
		AS 'Rank'
		from Scores
		 */

		/*
		select Score,
		(select count(distinct s2.Score) from Scores s2 where s2.Score >= s1.Score)
		AS 'Rank'
		from Scores s1
		order by s1.Score desc
		 */
		
	}
	
//There is no code of Java type for this problem
}
