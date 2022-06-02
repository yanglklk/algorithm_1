package com.learn.leetcode.everyday.june;

import java.util.*;
//["RLEIterator","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next"]
//        [[[635,606,576,391,370,981,36,21,961,185,124,210,801,937,22,426,101,260,221,647,350,180,504,39,101,989,199,358,732,839,919,169,673,967,58,676,846,342,250,597,442,174,472,410,569,509,311,357,838,251]],[5039],[62],[3640],[671],[67],[395],[262],[839],[74],[43],[42],[77],[13],[6],[3],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1],[1]]

public class June7_900 {
    public static void main(String[] args) {
        June7_900 june7_900 =  new June7_900();
        june7_900. RLEIterator(new int[]{635,606,576,391,370,981,36,21,961,185,124,210,801,937,22,426,101,260,221,647,350,180,504,39,101,989,199,358,732,839,919,169,673,967,58,676,846,342,250,597,442,174,472,410,569,509,311,357,838,251});
        int[] doi =new int[]{5039,62,3640,671,67,395,262,839,74,43,42,77,13,6,3,1,1,1};
        for (int i = 0; i < doi.length; i++) {
            System.out.println(june7_900.next(doi[i]));
        }


    }




    int[] encoding = null;
    long[] count = null;
    int p = 0;
    int length =0;
    public void RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.length = encoding.length;
        this.count = new long[length/2];
        count[0] = encoding[0];
        for (int i = 2; i < length; i+=2) {
            count[i/2] = encoding[i];
        }
    }
    public int next(int n) {
        int result = -1;
        int pi = p;
        for (; n > 0; ) {
            if (pi>=length/2){
                count[pi-1]=0;
                return  result;
            }
            n -= count[pi++];
        }
        p = --pi;
        count[pi] =  -n;
        return encoding[pi*2+1];
    }



//    class RLEIterator1{
//        Queue<Integer> queue = new ArrayDeque<>();
//        public RLEIterator1(int[] encoding) {
//            for (int i = 0; i < encoding.length; i+=2 ) {
//                int count = encoding[i];
//                int num = encoding[i+1];
//                for (int c = 0; c < count; c++) {
//                    queue.offer(num);
//                }
//            }
//
//        }
//        public int next(int n) {
//            int result = -1;
//            if(n>queue.size()){
//                return result;
//            }
//            for (int i = 0; i < n; i++) {
//                result = queue.poll();
//            }
//            return result;
//        }
//
//    }

//    class RLEIterator{
//        int[] encoding = null;
//        long[] count = null;
//        int p = 0;
//        int length =0;
//        public void RLEIterator(int[] encoding) {
//            this.encoding = encoding;
//            this.length = encoding.length;
//            this.count = new long[length/2];
//            count[0] = encoding[0];
//            for (int i = 2; i < length; i+=2) {
//                count[i/2] = encoding[i] + count[(i/2)-1];
//            }
//        }
//        public int next(int n) {
//            int result = -1;
//            int pi = p;
//            for (; n > 0; ) {
//                if (pi>=length/2){
//                    return  result;
//                }
//                n -= count[pi++];
//            }
//            if(pi>0){
//                pi--;
//            }else {
//                pi = 0;
//            }
//            p = pi;
//            count[pi]= -count[pi];
//            return encoding[pi*2+1];
//        }
//
//    }



}
