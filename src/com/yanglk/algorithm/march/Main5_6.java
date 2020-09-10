package com.yanglk.algorithm.march;

public class Main5_6 {
    public static void main(String[] args) {

    }
    public int mincostTickets(int[] days, int[] costs) {
        int max_day=days[days.length-1];
        int min_day=days[0];
        int[] opt=new int[max_day+31];
        for (int day = max_day, i=days.length-1; day >=min_day; day--) {
            if (day==days[i]){
                opt[day]=Math.min(opt[day+1]+costs[0],opt[day+7]+costs[1]);
                opt[day]=Math.min(opt[day],opt[day+30]+costs[2]);
                i--;
            }
            else {
                opt[day]=opt[day+1];
            }
        }
        return opt[min_day];
    }
}
