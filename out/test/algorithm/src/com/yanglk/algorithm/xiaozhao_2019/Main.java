package com.yanglk.algorithm.xiaozhao_2019;




import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public int find(String str){
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.keySet().contains(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
            else {
                map.put(str.charAt(i),1);
            }
        }
        List<Character> list=new ArrayList<>();
        for (Character character : map.keySet()) {
            if (map.get(character)==1){
                list.add(character);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (list.contains(str.charAt(i)))
                return i;
        }
        return -1;
    }
    ListNode reconstruct(ListNode head, int value) {
       ListNode p1=new ListNode(0);
       ListNode p2=new ListNode(0);
       ListNode p=head;
       ListNode pp1=p1;
       ListNode pp2=p2;
       while (p!=null){
           if(p.val<value){
               pp1.next=p;
               pp1=p;
           }
           else {
               pp2.next=p;
               pp2=p;
           }
       }
       pp1.next=p2.next;
       pp2.next=null;
       return p1.next;

    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}



