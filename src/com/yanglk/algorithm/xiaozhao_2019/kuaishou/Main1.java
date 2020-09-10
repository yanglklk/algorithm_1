package com.yanglk.algorithm.xiaozhao_2019.kuaishou;

import com.yanglk.algorithm.offer.Array;
import com.yanglk.algorithm.offer.Str;

import javax.annotation.processing.SupportedSourceVersion;
import javax.sound.midi.Soundbank;
import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.zip.CheckedOutputStream;

public class Main1 {
    public static void main_(String[] args) {
        long[] result = new long[1001];
        result[0] = 1;
        for (int i1 = 1; i1 <= 1000; i1++) {
            int i = 0;
            int step = 0;
            while (Math.pow(2, i) <= i1) {
                step += result[i1 - (int) Math.pow(2, i)];
                step %= 1000000003;
                i++;
            }
            result[i1] = step % 1000000003;
        }
        System.out.println(Arrays.toString(result));
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            System.out.println(result[k]);
        }


    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.keySet().contains(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character character : map.keySet()) {
            sb.append(character);
            sb.append(map.get(character));
        }
        System.out.println(sb.toString());

    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int[] s_nums = new int[m];
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            s_nums[i] = Integer.parseInt(s.substring(s.length() - 6));
        }
        Arrays.sort(s_nums);
        for (int s_num : s_nums) {
            System.out.println(s_num);
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer(sc.nextLine());
        int len = sb.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            for (int i1 = 0; i1 < (len + 1); i1++) {
                char c = (char) (i + 'a');
                set.add(sb.insert(i1, c).toString());
                sb.deleteCharAt(i1);
            }
        }
        System.out.println(set.size());

    }

    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String[] ss = sc.nextLine().split(" ");
            String s = ss[0];
            String t = ss[1];
            int temp = s.contains(t) || t.contains(s) ? 1 : 0;
            System.out.println(temp);
        }

    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] opt = new int[n + 1];
        opt[0] = Integer.MAX_VALUE;
        for (int i = 1; i < opt.length; i++) {
            if (i == 3 || i == 5 || i == 7) {
                opt[i] = 1;
            } else {
                int temp3 = Integer.MAX_VALUE;
                int temp5 = Integer.MAX_VALUE;
                int temp7 = Integer.MAX_VALUE;
                if (i - 3 >= 0)
                    temp3 = opt[i - 3];
                if (i - 5 >= 0)
                    temp5 = opt[i - 5];
                if (i - 7 >= 0)
                    temp7 = opt[i - 7];
                int temp = Math.min(temp3, Math.min(temp5, temp7));
                if (temp == Integer.MAX_VALUE)
                    opt[i] = temp;
                else opt[i] = temp + 1;
            }

        }
        System.out.println(opt[n] == Integer.MAX_VALUE ? -1 : opt[n]);
    }

    public static void main6(String[] args) {
        //System.out.println(Arrays.toString("21".split("-")));
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("\\+");
        int sum = 0;
        for (int i = 0; i < s.length; i++) {

            String[] sub = s[i].split("-");
            int temp = 0;
            if (!sub[0].equals(""))
                temp = Integer.parseInt(sub[0]);
            for (int j = 1; j < sub.length; j++) {
                temp -= Integer.parseInt(sub[j]);
            }
            sum += temp;
        }
        System.out.println(sum);

    }

    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int[] opt = new int[ss.length];
        opt[0] = Integer.parseInt(ss[0]);
        for (int i = 1; i < opt.length; i++) {
            int temp = Integer.parseInt(ss[i]);
            opt[i] = Math.max(opt[i - 1] + temp, temp);
        }
        Arrays.sort(opt);
        int t = opt[ss.length - 1];
        t = t > 0 ? t : 0;
        System.out.println(t);
    }

    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        boolean run = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            run = true;
        int[] months = new int[13];
        months[1] = 31;
        months[3] = 31;
        months[5] = 31;
        months[7] = 31;
        months[8] = 31;
        months[10] = 31;
        months[12] = 31;
        months[4] = 30;
        months[6] = 30;
        months[9] = 30;
        months[11] = 30;
        months[2] = run ? 29 : 28;
        int count = day;
        for (int i = 0; i < month; i++) {
            count += months[i];
        }
        System.out.println(count);


    }

    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() * 2;
        int k = 1;
        while (true) {
            int max = k * (k + 1);
            int min = k * (k - 1);
            if (n > min && n <= max) {
                break;
            }
            k++;
        }
        System.out.println(k);
    }

    public static void main10(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a % b == 0) {
            System.out.println(a / b);
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(a / b);
        sb.append(".");
        a = a % b;
        Map<Integer, Integer> map = new HashMap<>();
        while (a != 0) {
            if (map.keySet().contains(a)) {
                sb.insert(map.get(a), "(");
                sb.append(")");
                break;
            }
            map.put(a, sb.length());
            sb.append(a * 10 / b);
            a = (10 * a) % b;
        }
        System.out.println(sb.toString());
    }

    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int len = ss.length + 1;
        int[] cost = new int[len];
        int[] opt = new int[len];

        for (int i = 0; i < len - 1; i++) {
            cost[i] = Integer.parseInt(ss[i]);
        }
        opt[0] = 0;
        opt[1] = 0;
        for (int i = 2; i < len; i++) {
            opt[i] = Math.min(opt[i - 1] + cost[i - 1], opt[i - 2] + cost[i - 2]);
        }
        System.out.println(opt[len - 1]);
    }

    public static void main12(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.substring(1, s.length() - 1).replace("\"", "").split(",");
        int len = ss.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (ss[i] == "")
                continue;
            Set<Character> set = new HashSet<>();
            char[] chars = ss[i].toCharArray();
            for (char aChar : chars) {
                set.add(aChar);
            }
            for (int j = i + 1; j < len; j++) {
                char[] temp = ss[j].toCharArray();
                int k = 0;
                for (; k < temp.length; k++) {
                    if (set.contains(temp[k])) {
                        break;
                    }
                }
                if (k == temp.length) {
                    max = Math.max(ss[i].length() * ss[j].length(), max);
                }
            }
        }
        System.out.println(max);
    }

    public static void main13(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        int[] count = new int[s.length() + 1];
        if (k > s.length()) {
            System.out.println(0);
            return;
        }
        count[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count[i + 1] = count[i] + 1;
            } else count[i + 1] = count[i];
        }
        int ret = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = i + k; j < count.length; j++) {
                if (count[j] - count[i] == k)
                    ret++;
            }
        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        char[][] shudu = new char[n][n];
        for (int i = 0; i < (n); i++) {
            char[] s = sc.next().toCharArray();
            shudu[i] = s;
        }
        for (int i = 0; i < n; i++) {
            Set<Character> set=new HashSet<>();
            for (int j = 0; j < n; j++) {
                char c=shudu[i][j];
                if(c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Set<Character> set=new HashSet<>();
            for (int j = 0; j < n; j++) {
                char c=shudu[j][i];
                if(c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
            }
        }
        for (int i = 1; i < n-2; i=i+3) {

            for (int j = 1; j < n-2; j=j+3) {
                Set<Character> set=new HashSet<>();
                char c;
                c=shudu[i][j];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i-1][j];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i+1][j];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i][j-1];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i][j+1];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i-1][j-1];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i-1][j+1];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i+1][j-1];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
                c=shudu[i+1][j+1];
                if (c!='X'){
                    if (!set.isEmpty()&&set.contains(c)){
                        System.out.println(false);
                        return;
                    }
                    set.add(c);
                }
            }
        }
        System.out.println(true);

    }

    public static void main14(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split("\\+");
        int l=ss.length-2;
        StringBuffer sb=new StringBuffer();
        for (int i = l; i >= 0; i--) {
            sb.append(ss[i]+" ");
        }
        sb.deleteCharAt(l);
        sb.append(".");
        System.out.println(sb.toString());
    }

    public static void main15(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] s1=sc.nextLine().toCharArray();
        char[] s2=sc.nextLine().toCharArray();
        int l1=s1.length+1;
        int l2=s2.length+1;
        int[][] opt=new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            opt[i][0]=i;
        }
        for (int i = 0; i < l2; i++) {
            opt[0][i]=i;
        }
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                //if ()
            }
        }
        
    }

    public static void main16(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] opt=new int[n+1];
        for (int i = 2; i <= n; i++) {
            int t= (int) Math.pow(i,0.5);
            boolean flag=false;
            int j = 2;
            for (; j < t; j++) {
                if (i%j==0){
                    flag=true;
                    break;
                }
            }
            if (flag){
                opt[i]=opt[i-1]+opt[j]+opt[i/j];
                continue;
            }
            opt[i]=opt[i-1]+1;
        }
        System.out.println(opt[n]);
    }

    public static void main17(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int rn=0;
            int ri=i+1;
            int ln=0;
            int li=i-1;
            if (ri<n){
                int rmax=nums[ri];
                rn=1;
                while (ri<n-1){
                    if (nums[ri+1]>nums[ri]){
                        rn++;
                        rmax=nums[ri+1];
                    }
                    ri++;
                }
            }
            if (li>=0){
                int lmax=nums[li];
                ln=1;
                while (li-1>=0){
                    if (nums[li-1]>nums[li]){
                        ln++;
                        lmax=nums[li-1];
                    }
                    li--;
                }
            }
            System.out.printf("%d ",rn+ln+1);

        }
    }

    public static void main18(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Stack<Integer> ls=new Stack<>();
        int sum=0;
        for (int i = 0; i <= n; i++) {
            int k= i==n? Integer.MAX_VALUE:nums[i];
            if (ls.isEmpty()||nums[ls.peek()]>k){
                ls.push(i);
            }
            else {
                while (!ls.empty()&&nums[ls.peek()]<=k){
                   int t=ls.pop();
                   sum+=(i-t-1);
                }

            }
        }
    }










}
