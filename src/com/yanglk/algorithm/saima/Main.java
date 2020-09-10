package com.yanglk.algorithm.saima;


import java.util.*;

public class Main {
    public static void main_(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] s=sc.nextLine().split(" ");
            int n,m;
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            Set<Integer> set=new TreeSet<>();

            s=sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                set.add(Integer.parseInt(s[i]));
            }

            s=sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                set.add(Integer.parseInt(s[i]));
            }
            for (Integer integer : set) {
                System.out.printf("%d ",integer);
            }

        }
    }

    public static void main__(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<int[]> ll=new ArrayList<>();
        while (sc.hasNext()){

            int n,m;
            n=sc.nextInt();
            m=sc.nextInt();
            int[] price=new int[n];

            for (int i = 0; i < n; i++) {
                price[i]=sc.nextInt();
            }
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i < m; i++) {
                String ss=sc.next();
                if (map.containsKey(ss)){
                    map.put(ss,map.get(ss)+1);
                }
                else map.put(ss,1);
            }
            List<Integer> list=new ArrayList<>();
            for (String s1 : map.keySet()) {
                list.add(map.get(s1));
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            Arrays.sort(price);
            int min=0;
            int max=0;
            for (int i = 0; i < list.size(); i++) {
                min+=(list.get(i)*price[i]);
                max+=(list.get(i)*price[n-i-1]);
            }
            System.out.println(min+" "+max);
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for (int i = 0; i <= list.size()-3; i++) {
            int a = list.get(i);
            int ii=i+1;
            for (int j = i + 1; j <= list.size() - 2; j++) {
                int b = list.get(j);

                if (b - a > 10) {
                    list.add(ii++, b - 10);
                    j++;
                    continue;
                }
                int jj=j+1;
                for (int k = j + 1; k <= list.size() - 1; k++) {
                    int c = list.get(k);
                    if (c - b > 10) {
                        list.add(jj++, c - 10);
                        k++;
                        continue;
                    }
                }
            }
        }
        System.out.println(list.size()-n);
    }
}
