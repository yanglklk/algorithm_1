package com.yanglk.algorithm.backtrack;

import com.yanglk.algorithm.offer.Str;

import java.util.*;

public class Combine {
    public Combine() {
    }

    public static void main1(String[] args) {
//        int[] nums={2,1,2};
//        List<List<Integer>> l;
//        Combine combine=new Combine();
//       //l=combine.combine(5,3);
//        //System.out.println(combine.combinationSum(nums,5));
//        System.out.println(combine.subsetsWithDup(nums));

        new Combine().generateParenthesis(3);
    }
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list =new ArrayList<>();
        int[] nums=new int[n];
        int[] vis=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i+1;
        }
        combine1(k,lists,new ArrayList<>(),nums,vis);
        return lists;
    }
    public void combine1(int k,List<List<Integer>> lists,List<Integer> list,int[] nums,int[] vis){
        if (list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (vis[i]==1||list.size()>0&&nums[i]>list.get(list.size()-1))
//                continue;
//            vis[i]=1;
//            list.add(nums[i]);
//            combine1(k,lists,list,nums,vis);
//            vis[i]=0;
//            list.remove(list.size()-1);
//        }
        for (int i = 0; i<nums.length; i++) {
            if (vis[i]==1||list.size()>0&&nums[i]<list.get(list.size()-1))
                continue;
            vis[i]=1;
            list.add(nums[i]);
            combine1(k,lists,list,nums,vis);
            vis[i]=0;
            list.remove(list.size()-1);
        }


    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        int sum=0;
        int[] vis=new int[nums.length];
        combinationSum2(nums,target,sum,vis,lists,new ArrayList<>());
        return lists;
    }
    public void combinationSum2(int[] nums,int target,int sum,int[] vis,List<List<Integer>> lists,List<Integer> list){
        if (sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]&&vis[i-1]==0){
                continue;

            }
            if (sum+nums[i]>target)
                break;
            if (vis[i]==1||list.size()>0&&nums[i]<list.get(list.size()-1))
                continue;

//            if(lists.size()>0 && lists.get(lists.size()-1).get(lists.get(lists.size()-1).size()-1)==nums[i]){
//                continue;
//            }
            vis[i]=1;
            list.add(nums[i]);
            sum+=nums[i];
            combinationSum2(nums,target,sum,vis,lists,list);
            list.remove(list.size()-1);
            sum-=nums[i];
            vis[i]=0;
        }

    }
    public void combinationSum1(int[] nums,int target,int sum,List<List<Integer>> lists,List<Integer> list){
        if (sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum+nums[i]>target)
                break;
            if (list.size()>0&&nums[i]<list.get(list.size()-1))
                continue;

            list.add(nums[i]);
            sum+=nums[i];
            combinationSum1(nums,target,sum,lists,list);
            list.remove(list.size()-1);
            sum-=nums[i];
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack1(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack1(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //if (i>0&&nums[i]==nums[i-1]&&visited[i-1]==0)
            if ((visited[i] == 1)|| (i>0&&nums[i]==nums[i-1]&&visited[i-1]==0 )) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack1(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public String getPermutation(int n,int k){
        int[] nums=new int[n];
        int[] vis= new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        List<Integer> list=new ArrayList<>();
        getPermutation1(nums,vis,0,k,list);
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();

    }
    public int getPermutation1(int[] nums,int[] vis,int k,int nk,List<Integer> list){
        if (list.size()==nums.length){
            return ++k;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]==1)
                continue;
            vis[i]=1;
            list.add(nums[i]);
            k=getPermutation1(nums,vis,k,nk,list);
            if (k==nk){
                break;
            }
            vis[i]=0;
            list.remove(list.size()-1);
        }
        return k;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        int[] vis=new int[nums.length];
        List<List<Integer>> lists =new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length+1; i++) {
            subsetsWithDup1(nums,vis,i,lists,new ArrayList<>());
        }
        return lists;
    }
    public void subsetsWithDup1(int[] nums,int[] vis,int k,List<List<Integer>> lists,List<Integer> list){
        if (list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((vis[i]==1)||(i>0&&nums[i]==nums[i-1]&&vis[i-1]==0))
                continue;
            if (vis[i]==0){
                boolean f=false;
                for (int i1 = i; i1 < nums.length; i1++) {
                    if (vis[i1]==1){
                        f=true;
                        i=i1;
                        break;
                    }
                }
                if (f)
                    continue;
            }
            vis[i]=1;
            list.add(nums[i]);
            subsetsWithDup1(nums,vis,k,lists,list);
            vis[i]=0;
            list.remove(list.size()-1);
        }
    }
    boolean f=false;
    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0)
            return false;
        int m=board.length;
        int n=board[0].length;
        boolean[][] visit=new boolean[m][n];
        exist1(board,visit,word,0,-1,-1);
        return  f;

    }

    public void exist1(char[][] board, boolean[][] visit, String word,int index,int last_i,int last_j) {
        if (index==word.length()){
            f=true;
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (f)
                return;
            for (int j = 0; j < visit[0].length; j++) {
                if (!visit[i][j]&&board[i][j]==word.charAt(index)){
                    if ((last_i==-1&&last_j==-1)||(Math.abs(last_i-i)==1&&Math.abs(last_j-j)==0)||(Math.abs(last_i-i)==0&&Math.abs(last_j-j)==1)){
                        visit[i][j]=!visit[i][j];
                        index++;
                        exist1(board,visit,word,index,i,j);
                        index--;
                        visit[i][j]=!visit[i][j];

                    }

                }
            }
        }

    }
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generateParenthesis1(n,new StringBuilder(),new int[]{1,1});
        return list;
    }
    public void generateParenthesis1(int n,StringBuilder sb,int[] count) {
        if (sb.length()==n*2){
            list.add(sb.toString());
            return;
        }
        if (count[0]>count[1]){
            char[] chars={'(',')'};
            for (int i = 0; i < chars.length; i++) {
                if (count[i]<n+1){
                    sb.append(chars[i]);
                    count[i]++;
                    generateParenthesis1(n,sb,count);
                    sb.deleteCharAt(sb.length()-1);
                    count[i]--;
                }

            }
        }
        if (count[0]==count[1]){
            sb.append('(');
            count[0]++;
            generateParenthesis1(n,sb,count);
            sb.deleteCharAt(sb.length()-1);
            count[0]--;
        }
//        else{
//            sb.deleteCharAt(sb.length()-1);
//            count[0]--;
//        }


    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length()>16)
            return null;
        restoreIpAddresses1(s,0,new ArrayList<>(),0);
        return list;
    }
    public void restoreIpAddresses1(String s,int index,List<String> sb,int count) {
        if (index==s.length()&&sb.size()==4&&count==s.length()){
            StringBuilder stringBuilder=new StringBuilder();
            for (String s1 : sb) {
                stringBuilder.append(s1);
                stringBuilder.append('.');
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            list.add(stringBuilder.toString());
            return ;
        }
        for (int i = index; i < s.length(); i++) {
            int temp=0;
            if (s.charAt(i) == '0') {
                sb.add(String.valueOf(0));
                count=count+1;
                restoreIpAddresses1(s,i+1,sb,count);
                sb.remove(sb.size()-1);
                count=count-1;
                continue;
            }
            for (int j = 0; j < (3)&&i+j<s.length(); j++) {
                temp=temp*10+s.charAt(i+j)-'0';
                if (temp<256){
                    sb.add(String.valueOf(temp));
                    count=count+j+1;
                    restoreIpAddresses1(s,i+j+1,sb,count);
                    sb.remove(sb.size()-1);
                    count=count-j-1;


                }
            }
        }


    }

    static  List<Set<Integer>> l=new ArrayList<>();

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] opt =new int[n+2];
//        opt[0]=1;
//        opt[1]=1;
//        opt[2]=1;
//        opt[3]=1;
//        opt[4]=2;
//        for(int i=5;i<=n+1;i++){
//            opt[i]=(opt[i-1]+opt[i-4])%1000000007;
//        }
//        System.out.println(opt[n+1]);
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(",");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        bp1(n,m,new HashSet<>(),  list);
        System.out.println(l.size());

    }
    public  static void bp1(int n,int m,Set<Integer> s,ArrayList<Integer> c){
        if (s.size()==m){
            Set<Integer> ss=new HashSet<Integer>();
            ss.addAll(c);
            if (ss.size()==n){
                l.add(s);
                return;
            }
        }
        for (int i = 0; i < m; i++) {
            if (!s.contains(i)){
                for (int j = 0; j < c.size(); j++) {
                    c.set(j,c.get(j)+1);
                    s.add(i);
                    bp1(n,m,s,c);
                    s.remove(i);
                    c.set(j,c.get(j)-1);
                }

            }

        }

    }

}
