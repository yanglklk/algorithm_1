package com.yanglk.algorithm.offer;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {
        Heap h=new Heap();
        h.Insert(1);
        h.Insert(2);
        h.Insert(4);
        h.Insert(3);
        h.Insert(7);
        h.Insert(5);
        h.Insert(2);
        h.Insert(6);
        System.out.println(h.GetMedian());
    }

    PriorityQueue<Integer> min_heap=new PriorityQueue<>();
    PriorityQueue<Integer> max_heap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void Insert(Integer num) {
        // 小顶堆放大数 大顶堆放小数
        // 先放大顶堆
        if (min_heap.size()==0&&max_heap.size()==0){
            max_heap.add(num);
            return;
        }
        // 相同
        if (min_heap.size()==max_heap.size()){
            if (num<=max_heap.peek()){
                max_heap.add(num);
            }
            else {
                min_heap.add(num);
            }
        }
        //小顶堆少 要放进小顶堆
        else if (min_heap.size()<max_heap.size()){
            //该数必大顶堆的大 直接放进小顶堆
            if (num>=max_heap.peek())
                min_heap.add(num);
            // 比大顶对最大的还小 把大顶堆最大的放进小顶堆，该数放进大顶堆
            else {
                min_heap.add(max_heap.poll());
                max_heap.add(num);
            }
        }
        else {
            if (num<=min_heap.peek()){
                max_heap.add(num);
            }
            else {
                max_heap.add(min_heap.poll());
                min_heap.add(num);
            }
        }

    }

    public Double GetMedian() {
        if (max_heap.size()==0&&min_heap.size()==0)
            return null;
        if (max_heap.size()==min_heap.size())
            return (double) ((max_heap.peek()+min_heap.peek())/2.0);
        return max_heap.size()>min_heap.size()? (double) max_heap.peek(): (double) min_heap.peek();
    }
}
