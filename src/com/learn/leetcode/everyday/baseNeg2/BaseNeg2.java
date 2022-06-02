package com.learn.leetcode.everyday.baseNeg2;

import java.math.BigDecimal;
import java.util.*;

public class BaseNeg2 {
    public String baseNeg2(int n) {
        if (n==0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (n!=0){
            int res = n%(-2);
            res = (res+2)%2;
            sb.append(res);
            n=(n-res)/-2;
        }
        return sb.reverse().toString();
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i]++;
                return digits;
            } else {
                digits[i]++;
            }
        }
        if (digits[0]==0){
            int[] ints = new int[n + 1];
            ints[0]=1;
            for (int i = 0; i < n; i++) {
                ints[i + 1] = digits[i];
            }
            return ints;
        }else {
            return digits;
        }


    }

    public int eatenApples(int[] apples, int[] days) {
        // now+days[now]-1 最后能吃的日期
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int now =0 , sum=0,n=apples.length;
        while (now<n || !priorityQueue.isEmpty()){
            // 今天产生了，放进去
            if (now<n && apples[now]>0){
                priorityQueue.add(new int[]{now+days[now]-1,apples[now]});
            }
            // 最后能吃日期< 当前了 直接 扔了 出队
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0]<now){
                priorityQueue.poll();
            }
            if (!priorityQueue.isEmpty()){
                int[] poll = priorityQueue.poll();
                sum++; // 吃掉一个
                // 取出最早能吃的 吃掉一个后能吃的还>1 且 最后能吃日期 >now
//                if (--poll[1]>0 && poll[0]>now ){
//                    priorityQueue.add(poll); // 放回队列
//                }
                // 还有两个以上
                if (poll[1]>=2){
                    poll[1]--; // 吃掉一个 下次还能吃
                    priorityQueue.add(poll);
                }
            }

            now++;
        }
        return sum;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        for (int i = 0; i < n; i++) {
            if (queue.size()<k){
                queue.add(nums[i]);
            }else if (nums[i]>queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a, b)->a.getValue()-b.getValue());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (queue.size()<k){
                queue.add(integerIntegerEntry);
            }else if (integerIntegerEntry.getValue()>queue.peek().getValue()){
                queue.poll();
                queue.add(integerIntegerEntry);
            }
        }
        int[] res = new int[queue.size()];
        int i =0;
        while (!queue.isEmpty()){
            res[i++]= queue.poll().getKey();
        }

        return res;

    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{matrix[i][0],i,0});
        }
        for (int i = 0; i < k-1; i++) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[2];
            if (y<n-1){
                queue.add(new int[]{matrix[x][y+1],x,y+1});
            }
        }
        return queue.poll()[0];
    }


    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < n; i++) {
            if (lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        if (queue.isEmpty()){
            return null;
        }
        ListNode root = new ListNode(-1);
        ListNode next = root;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            next.next=poll;
            if (poll.next!=null){
                queue.add(poll.next);
            }
            next = poll;
        }
        return root.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        //new BaseNeg2().mergeKLists(new ListNode[]{l1,l2,l3});
        //new BaseNeg2().maxSlidingWindow(new int[]{1,-1},1);
        new BaseNeg2().nthUglyNumber(10);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
           queue.add(new int[]{nums[i],i});
        }
        int[] res = new int[n-k+1];
        for (int i = k; i <= n; i++) {
            while (!queue.isEmpty() && queue.peek()[1]<i-k){
                queue.poll();
            }
            res[i-k]= queue.peek()[0];
            if (i!=n){
                queue.add(new int[]{nums[i],i});
            }
        }
        return res;
    }

    public int nthUglyNumber(int n) {
        int c=1;
        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
        queue.add(1L);
        while (!queue.isEmpty() && c<n){
            Long min = queue.poll();
            if (!queue.contains(min*2)){
                queue.add(min*2);
            }
            if (!queue.contains(min*3)){
                queue.add(min*3);
            }
            if (!queue.contains(min*5)){
                queue.add(min*5);
            }
            c++;
        }

        return Integer.valueOf(queue.poll().toString());
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int c=1;
        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
        queue.add(1L);
        while (!queue.isEmpty() && c<n){
            Long min = queue.poll();
            for (int prime : primes) {
                if (prime*min<=Integer.MAX_VALUE){
                    queue.add(min*prime);
                }
                if (min%prime==0){
                    break;
                }
            }
            c++;
        }

        return Integer.valueOf(queue.poll().toString());
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
