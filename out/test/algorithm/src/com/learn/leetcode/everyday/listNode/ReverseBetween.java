package com.learn.leetcode.everyday.listNode;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yanglk.algorithm.link_.ListNode;
import com.yanglk.algorithm.tree_.TreeNode;

import java.util.List;

public class ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        //System.out.println(new ReverseBetween().reverseBetween(listNode, 1, 4));

        //new ReverseBetween().largestMerge("guguuuuuuuuuuuuuuguguuuuguug","gguggggggguuggguugggggg");

        new ReverseBetween().maxNumberOfBalloons("nlaebolko");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode start = null;
        ListNode end = null;
        int count = 1;
        while (cur!=null){
            if (count==left){
                start = pre;
            }
            if (count==right){
                end = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
            count++;
        }


        if (start==null){
            start = new ListNode(-1,head);
            ListNode c = start.next;
            start.next= end.next;
            end.next= null;
            while (c!=null){
                ListNode node = c.next;
                c.next= start.next;
                start.next=c;
                c= node;
            }
            return start.next;
        }
        ListNode c = start.next;
        start.next= end.next;
        end.next= null;
        while (c!=null){
            ListNode node = c.next;
            c.next= start.next;
            start.next=c;
            c= node;
        }

        return head;

    }

    public ListNode reverse(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode next = head.next;
        while (next != null) {
            head.next=next.next;
            next.next= root.next;
            root.next=next;
            next=head.next;
        }
        return root.next;
    }

    public ListNode reverseHelper(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode node = reverseHelper(head.next);
        head.next.next = head;
        head.next=null;
        return node;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric1(root,root);
    }
    public boolean isSymmetric1(TreeNode right,TreeNode left) {
        if (right==null && left==null){
            return true;
        }
        if ((right==null && left!=null) || (right!=null && left==null)){
            return false;
        }
        return right.val==left.val && isSymmetric1(right.right,left.left) && isSymmetric1(right.left,left.right);
    }

    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int r1 =0, r2=0;
        StringBuffer sb = new StringBuffer();
        while (r1<n1 || r2 < n2){
            if (word1.substring(r1).compareTo(word2.substring(r2))<0){
                sb.append(word2.charAt(r2++));
            }else {
                sb.append(word1.charAt(r1++));
            }
        }

        return sb.toString();
    }

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            if (aChar=='b'){
                count[0]++;
            }
            if (aChar=='a'){
                count[1]++;
            }
            if (aChar=='l'){
                count[2]++;
            }
            if (aChar=='o'){
                count[3]++;
            }
            if (aChar=='n'){
                count[4]++;
            }
        }

        return Math.min(Math.min(Math.min(count[0],count[1]),count[4]),(Math.min(count[2]/2,count[3]/2)));

    }

}
