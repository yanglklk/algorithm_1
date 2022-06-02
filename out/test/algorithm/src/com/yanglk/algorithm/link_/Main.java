package com.yanglk.algorithm.link_;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        ListNode p=new Main().reverse1(l1);
        while (p!=null) {
            System.out.println(p.val);
            p=p.next;
        }


    }
    public ListNode reverse(ListNode listNode){
        if (listNode==null){
            return listNode;
        }
        ListNode p;
        ListNode H=new ListNode(-1);
        H.next=null;
        ListNode next;
        p=listNode;
        while (p!=null){
            next=p.next;
            p.next=H.next;
            H.next=p;
            p=next;
        }
        return H.next;
    }

    public ListNode reverse1(ListNode listNode){
        if (listNode==null||listNode.next==null)
            return listNode;
        ListNode h=reverse1(listNode.next);
        listNode.next.next=listNode;
        listNode.next=null;
        return h;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<2)
            return head;
        Stack<ListNode> stack=new Stack<>();
        ListNode newHead=head;
        ListNode cur=head;
        ListNode next=null;
        ListNode pre=null;
        while (cur!=null){
            next=cur.next;
            stack.add(cur);
            if (stack.size()==k){
               pre =resign(stack,pre,next);
               newHead=newHead==head? cur: newHead;
            }
            cur=next;
        }
        return newHead;
    }

    ListNode resign(Stack<ListNode> stack,ListNode left,ListNode right){
        ListNode cur=stack.pop();
        if (left!=null){
            left.next=cur;
        }
        ListNode next=null;
        while (!stack.empty()){
            next=stack.pop();
            cur.next=next;
            cur=next;
        }
        next.next=right;
        return cur;
    }



    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k<2)
            return head;

        ListNode cur=head;
        ListNode next=null;
        ListNode pre=null;
        ListNode start=null;
        int count=1;
        while (cur!=null){
            next=cur.next;
            if (count==k){
                start=pre==null? head:pre.next;
                head= pre==null? cur: head;
                resign1(pre,next,start,cur);
                pre=start;
                count=0;
            }
            count++;
            cur=next;
        }
        return head;
    }

    void resign1(ListNode left,ListNode right,ListNode start,ListNode end){
      ListNode pre=start;
      ListNode next=null;
      ListNode cur=start.next;
      while (cur!=right){
          next=cur.next;
          cur.next=pre;
          pre=cur;
          cur=next;
      }
      if (left!=null)
          left.next=end;
      start.next=right;
    }

}
