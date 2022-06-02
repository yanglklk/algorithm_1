package com.yanglk.algorithm.link_;

import com.sun.corba.se.spi.oa.ObjectAdapterFactory;
import com.sun.javafx.image.BytePixelSetter;
import com.sun.org.apache.bcel.internal.generic.I2D;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public ListNode mergeKLists1(ListNode[] lists){
        List<ListNode> list=new ArrayList();
        for (int i = 0; i < lists.length; i++) {
            ListNode head=lists[i];
            while (head!=null){
                list.add(head);
                head=head.next;
            }
        }
        if (list.size()==0)
            return null;
        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next=list.get(i+1);
            list.get(i+1).next=null;
        }
        return list.get(0);

    }

    public ListNode merge(ListNode[] listNodes){
        ListNode l1=listNodes[0];
        ListNode l2=listNodes[1];
        ListNode head=new ListNode(0);
        ListNode pre=head;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }
            else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if (l1!=null)
            head.next=l1;
        if (l2!=null)
            head.next=l2;
        return pre.next;
    }

    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length==0)
            return null;
        if (lists.length==1)
            return lists[0];
        if (lists.length==2){
            return merge(lists);
        }
        else{
            int mid=(int) lists.length/2;
            ListNode[] l1=Arrays.copyOfRange(lists,0,mid);
            ListNode[] l2=Arrays.copyOfRange(lists,mid,lists.length);
            ListNode listNode1=mergeKLists(l1);
            ListNode listNode2=mergeKLists(l2);
            return merge(new ListNode[]{listNode1,listNode2});
        }
    }

    public ListNode deleteDuplicates1(ListNode head){
        if (head==null)
            return head;
        ListNode pre=head;
        ListNode H=head;
        ListNode next=head.next;
        while (next!=null){
            if (pre.val!=next.val){
                pre.next=next;
                pre=next;
                next=next.next;
            }
            else{
                next=next.next;
            }
        }
        pre.next=null;
        return H;
    }

    public ListNode deleteDuplicates(ListNode head){
        if (head==null)
            return head;
        ListNode fast=head.next;
        ListNode slow=head;
        ListNode H=new ListNode(0);
        ListNode h=H;
        boolean flag=false;
        while (fast!=null){
            if (fast.val==slow.val){
                fast=fast.next;
                flag=true;
            }
            else if(!flag) {
                h.next=slow;
                h=h.next;
                slow=fast;
                fast=fast.next;
                flag = false;
            }
            else {
                slow=fast;
                fast=fast.next;
                flag=false;
            }
        }
        if (!flag){
            h.next=slow;
            h=h.next;
        }
        h.next=null;
        return H.next;
    }

    public ListNode rotateRight(ListNode head,int k){
        if (head==null||k==0)
            return head;
        ListNode H=head;
        ListNode h=head;
        ListNode ll=head;
        int len=0;
        while (ll!=null){
            len++;
            ll=ll.next;
            if (len==k)
                h=ll;
        }
        if (k==len)
            return head;
        if (k>len){
            h=H;
            for (int i = 0; i < (k % len); i++) {
                h=h.next;
            }
        }
        ListNode p=H;
        ListNode q=h;
        while (q.next!=null){
            q=q.next;
            p=p.next;
        }
        q.next=H;
        h=p.next;
        p.next=null;
        return h;

    }

    public ListNode partition(ListNode head,int x){
        ListNode P=new ListNode(0);
        ListNode Q=new ListNode(0);
        ListNode p=P;
        ListNode q=Q;
        ListNode h=head;
        while (h!=null){
            if (h.val<x){
                p.next=h;
                p=h;
            }
            else {
                q.next=h;
                q=h;
            }
            h=h.next;
        }
        p.next=Q.next;
        q.next=null;
        return P.next;
    }

    public ListNode removeElements(ListNode head,int val){
        ListNode h=head;
        ListNode P=new ListNode(0);
        ListNode p=P;
        while (h!=null){
            if (h.val!=val){
                p.next=h;
                p=p.next;
            }
            h=h.next;
        }
        p.next=null;
        return P.next;
    }

    public ListNode reverseBetween(ListNode head,int m,int n){
        if (head==null||m==n)
            return head;

        ListNode H=new ListNode(0);
        ListNode l;
        ListNode h;
        ListNode p;
        ListNode pre=head;
        if (m==1)
            h=head;
        else {
            for (int i = 0; i < m - 2; i++) {
                pre = pre.next;
            }
            h=pre.next;
        }
        l=h;
        for (int i = 0; i < (n - m+1); i++) {
            p=h;
            h=h.next;
            p.next=H.next;
            H.next=p;
        }
        if (m==1){
            l.next=h;
            return H.next;
        }
        else {
            pre.next=H.next;
            l.next=h;
            return head;
        }

    }

    public ListNode sortList(ListNode head){
        if (head==null)
            return head;
        List<ListNode> listNodes=new ArrayList<>();
        while (head!=null){
            listNodes.add(head);
            head=head.next;
        }
        listNodes.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < listNodes.size()-1; i++) {
            listNodes.get(i).next=listNodes.get(i+1);
        }
        listNodes.get(listNodes.size()-1).next=null;
        return listNodes.get(0);
    }

    public ListNode insertionSortList(ListNode head){
        ListNode h= head;
        ListNode H=new ListNode(0);
        while (h!=null){
            ListNode h1=h;
            ListNode pp=H;
            ListNode p=pp.next;
            while (p!=null&&h1.val>p.val){
                pp=p;
                p=p.next;
            }
            h=h.next;
            h1.next=p;
            pp.next=h1;

        }
        return H.next;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1=0;
        int len2=0;
        ListNode p=pHead1;
        while (p!=null){
            p=p.next;
            len1++;
        }
        p=pHead2;
        while (p!=null){
            p=p.next;
            len2++;
        }
        int len;
        ListNode q;
        if (len1>len2){
            p=pHead1;
            len=len1-len2;
            q=pHead2;
        }
        else {
            p=pHead2;
            len=len2-len1;
            q=pHead1;
        }
        for (int i = 0; i < len; i++) {
            p=p.next;
        }
        while (p!=null&&q!=null&&q!=p){
            p=p.next;
            q=q.next;
        }
        return p;

    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode p=pHead;
        ListNode q=pHead;
        do {
            p = p.next;
            if (q == null||q.next==null)
                return null;
            q=q.next.next;
        }
        while (p!=q);
        q=pHead;
        while (p!=q){
            p=p.next;
            q=q.next;
        }
        return p;


    }
}
