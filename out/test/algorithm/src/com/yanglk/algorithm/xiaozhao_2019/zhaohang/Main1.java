package com.yanglk.algorithm.xiaozhao_2019.zhaohang;



import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Main1 {
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int l=s.length;
        int[] baby=new int[l];
        for (int i = 0; i < baby.length; i++) {
            baby[i]=Integer.parseInt(s[i]);
        }
        s=sc.nextLine().split(" ");
        l=s.length;
        int[] gift=new int[l];
        for (int i = 0; i < gift.length; i++) {
            gift[i]=Integer.parseInt(s[i]);
        }
        Arrays.sort(baby);
        Arrays.sort(gift);
        int j=0;
        for (int i = 0; i < gift.length&&j<baby.length; i++) {
            if (gift[i]>=baby[j]){
                j++;
            }
        }
        System.out.println(j);


    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] change=new int[10];
        change[0]=0;
        change[1]=1;
        change[2]=5;
        change[3]=-1;
        change[4]=-1;
        change[5]=2;
        change[6]=9;
        change[7]=-1;
        change[8]=8;
        change[9]=6;

        int count=0;
        for (int i = 1; i <= n; i++) {
            char[] chars=Integer.toString(i).toCharArray();
            int t=0;
            int j=0;
            for (; j < chars.length; j++) {
                int temp=change[chars[j]-'0'];
                if (temp!=-1)
                {
                    t=t*10+temp;
                }
                else break;
            }
            if (j==chars.length&&t!=j)
                count++;
        }

        System.out.println(count);



    }

    public static void main3(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=1;
        count+=n;
        if (n>1){
            count+=(n*(n-1)/2);
        }
        System.out.println(count);
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] chars=sc.nextLine().toCharArray();
        int[] opt=new int[chars.length+1];
        opt[0]=opt[1]=1;
        for (int i = 2; i < opt.length; i++) {
            int t_1=chars[i-1]-'0';
            int t_2=chars[i-2]-'0';
            if (t_1!=0){
                opt[i]=opt[i-1];
            }
            if (t_2==1||(t_2==2&&t_1<7)){
                opt[i]+=opt[i-2];
            }
        }
        System.out.println(opt[chars.length]);


    }

    public static void main5(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int len_p=s.length;
        int[] p=new int[len_p];
        for (int i = 0; i < len_p; i++) {
            p[i]=Integer.parseInt(s[i]);
        }
        int l=sc.nextInt();
        Arrays.sort(p);
        int j=len_p-1;
        int i=0;
        int count=0;
        while (i<j){
            if (p[j]+p[i]>l){
                count++;
                j--;
            }
            else {
                count++;
                i++;
                j--;
            }
        }
        count=i==j? count+1:count;
        System.out.println(count);
    }

    public static void main6(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] chars=s.toCharArray();
        int l=-1;
        int r=-1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='L'){
                if (r==-1){
                    for (int i1 = 0; i1 < i; i1++) {
                        chars[i1]='L';
                    }
                }
                else {
                    if (r>l){
                        int k=(i-r-1)/2;
                        for (int i1 = 0; i1 <=k; i1++) {
                            chars[r+i1]='R';
                            chars[i-i1]='L';
                        }
                    }
                    else {
                        for (int i1 = l; i1 < i; i1++) {
                            chars[i1]='L';
                        }
                    }

                }
                l=i;

            }
            else if (chars[i]=='R'){
               if (r==-1){
                   r=i;
               }
               else {
                   if (r>l){
                       for (int i1 = r; i1 < i; i1++) {
                           chars[i1]='R';
                       }
                   }

                   r=i;
               }
            }
        }
        if (r>l){
            for (int i = r+1; i < chars.length; i++) {
                chars[i]='R';
            }
        }
        StringBuffer sb=new StringBuffer();
        for (char c : chars) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    public static void main7(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[i])
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void main8(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] chars=sc.nextLine().toCharArray();
        int count1=0;
        int count2=0;
        int c=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='C'){
                c++;
            }
            else
                count1+=c;
        }
        c=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='D'){
                c++;
            }
            else
                count2+=c;
        }
        System.out.println(Math.min(count1,count2));
    }

    public static void main9(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int n=s.length;
        int[] nums=new int[n];
        int total=0;
        for (int i = 0; i < n; i++) {
            int t=Integer.parseInt(s[i]);
            nums[i]=t;
            total+=t;
        }
        int h=sc.nextInt();
        int k=total/h;
        while (eat(nums,k)>h){
            k++;
        }
        System.out.println(k);


    }
    public static int eat(int[] nums,int k){
        int h=0;
        for (int i = 0; i < nums.length; i++) {
            h+=(int) Math.ceil(nums[i]/(double)k);
        }
        return h;
    }

    public static void main10(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int w=sc.nextInt();
        double[] opt=new double[k+w];

        for(int i=k;i<=n;i++){
            opt[i]=1;
        }

        double s=Math.min(w,n-k+1);
        for(int i=k-1;i>=0;i--){
            opt[i]=s/w;
            s+=opt[i]-opt[i+w];
        }
        System.out.printf("%1.5f",opt[0]);

    }

    public static void main11(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] temp=new int[]{sc.nextInt(),sc.nextInt()};
            nums[i]=temp;
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              return o1[1]==o2[1]? o1[0]-o2[0]: o1[1]-o2[1];
            }
        });
        int count=2;
        int last1=nums[0][1]-1;
        int last2=nums[0][1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0]<=last1&&nums[i][1]>=last2){
                continue;
            }
            if (nums[i][0]>last2){
                last1=nums[i][1]-1;
                last2=nums[i][1];
                count+=2;
                continue;
            }
            if (nums[i][0]>last1){
                last1=last2;
                last2=nums[i][1];
                count++;
            }

        }
        System.out.println(count);
    }

    public static void main12(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int t=2*T;
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        map.put(0,list);
        for (int i = 1; i <=t; i++) {
            ArrayList<Integer> list2=new ArrayList<>();
            for (Integer integer : map.get(i-1)) {
                int temp1=integer+i;
                int temp2=integer-i;
                if (temp1==T||temp2==T){
                    System.out.println(i);
                    return;
                }
                list2.add(temp1);
                list2.add(temp2);
            }
            map.put(i,list2);
        }
        System.out.println(-1);

    }


}
