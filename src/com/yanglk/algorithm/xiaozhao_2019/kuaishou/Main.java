package com.yanglk.algorithm.xiaozhao_2019.kuaishou;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int rn = 0;
            int ri = i + 1;
            int ln = 0;
            int li = i - 1;
            if (ri < n) {
                int rmax = nums[ri];
                rn = 1;
                while (ri < n - 1) {
                    if (nums[ri + 1] > rmax) {
                        rn++;
                        rmax = nums[ri + 1];
                    }
                    ri++;
                }
            }
            if (li >= 0) {
                int lmax = nums[li];
                ln = 1;
                while (li - 1 >= 0) {
                    if (nums[li - 1] > lmax) {
                        ln++;
                        lmax = nums[li - 1];
                    }
                    li--;
                }
            }
            System.out.printf("%d ", rn + ln + 1);

        }
    }
}
