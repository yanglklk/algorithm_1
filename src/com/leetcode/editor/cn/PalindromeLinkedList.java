package com.leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1066 👎 0


import com.yanglk.algorithm.link_.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList{
	public static void main(String[] args) {
		Solution solution = new PalindromeLinkedList().new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;

		node2.next = node3;

		node3.next = node4;

		node4.next = node5;
		node4.next = null;
		solution.isPalindrome(node1);


	}
	
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome1(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode p = head;
		while (p != null){
			list.add(p.val);
			p = p.next;
		}
		for (int i = 0; i < (list.size() / 2); i++) {
			if (! list.get(i).equals(list.get(list.size()-1-i))){
				return false;
			}
		}
		return true;
    }

	public boolean isPalindrome(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (p != null && p.next != null){
			p = p.next.next;
			q = q.next;
		}
		ListNode h = q;
		q= h.next;
		h.next = null;
		while (q != null){
			p = q.next;
			q.next = h;
			h = q;
			q = p;
		}
		p = head;
		ListNode h1 = h;
		while (h != null){
			if (h.val != p.val){
				return false;
			}
			h = h.next;
			p = p.next;
		}

		while (h1 != null && p != null && h1 != p ){
			h = h1.next;
			h1.next = p.next;
			p.next = h1;
			h1 = h;
		}

		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
