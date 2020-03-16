package com.yanglk.algorithm.link_;

import java.util.PrimitiveIterator;

public class Test {
    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        ListNode a6=new ListNode(6);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        a6.next=a3;

        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(4);
        b1.next=b2;
        b2.next=null;

        ListNode c1=new ListNode(3);
        ListNode c2=new ListNode(6);
        c1.next=c2;
        c2.next=null;

        ListNode d1=new ListNode(0);
        ListNode d2=new ListNode(1);
        ListNode d3=new ListNode(2);
        d1.next=d2;
        d2.next=d3;
        d3.next=null;
//        ListNode[] listNode=new ListNode[]{a1,b1,d1};
//        ListNode l=new Solution().mergeKLists(listNode);
//        while (l!=null){
//            System.out.println(l.val);
//            l=l.next;
//        }
        ListNode listNode=new Solution().EntryNodeOfLoop(a1);
        print(listNode);

    }
    public static void print(ListNode node){
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
