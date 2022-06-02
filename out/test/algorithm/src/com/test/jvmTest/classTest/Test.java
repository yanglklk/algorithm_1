package com.test.jvmTest.classTest;

import com.sun.tools.javac.code.Attribute;
import com.test.jvmTest.A;
import com.yanglk.algorithm.offer.Array;
import com.yanglk.algorithm.tree_.TreeNode;
import org.apache.commons.lang3.StringUtils;
import sun.jvmstat.perfdata.monitor.CountedTimerTask;
import sun.security.rsa.SunRsaSign;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.OpenOption;
import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws Exception{
//        ClassLoader classLoader = Test.class.getClassLoader();
//        System.out.println(classLoader);
//        classLoader.loadClass("com.test.jvmTest.classTest.AAAA");
//        Class.forName("com.test.jvmTest.classTest.AAAA");
//        Class.forName("com.test.jvmTest.classTest.AAAA",true,classLoader);
//        System.out.println(String.class.getClassLoader());


        ClassLoader MyClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream in = this.getClass().getResourceAsStream(fileName);
                    if (in==null){
                        return super.loadClass(name);
                    }
                    int n = in.available();
                    byte[] bytes = new byte[n];
                    in.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        Object o1 = MyClassLoader.loadClass("com.test.jvmTest.classTest.Test").newInstance();
        System.out.println(o1.getClass().getClassLoader());
        Object o2 = ClassLoader.getSystemClassLoader().loadClass("com.test.jvmTest.classTest.Test").newInstance();
        System.out.println(o2.getClass().getClassLoader());
        Object o3 = Class.forName("com.test.jvmTest.classTest.Test").newInstance();
        System.out.println(o3.getClass().getClassLoader());
        Object o4 = Class.forName("com.learn.leetcode.everyday.thread.Test").newInstance();
        System.out.println(o4.getClass().getClassLoader());
        System.out.println();

//        Object o1 = MyClassLoader.loadClass("java.lang.String").newInstance();
//        System.out.println(o1.getClass().getClassLoader());
//        Object o2 = ClassLoader.getSystemClassLoader().loadClass("java.lang.String").newInstance();
//        System.out.println(o2.getClass().getClassLoader());
    }
}

class AAAA{
    static {
        System.out.println("load A");


    }

    public boolean canJump(int[] nums){
        int n = nums.length;
        int opt = 0;
        for (int i = 0; i < n; i++) {
            if (i<opt){
                opt=Math.max(opt,i+nums[i]);
                if (opt>=n-1){
                    return true;
                }
            }
        }
        return false;

    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = (25); i >= 0; i--) {
            char c = (char) (i+'a');
            int times= Math.min(repeatLimit,count[i]);
            for (int i1 = 0; i1 < times; i1++) {
                sb.append(c);
            }
            count[i]-=times;
            if (count[i]==0) {
                continue;
            }
            int j = i-1;
            while (j>=0 && count[j]==0) {
                j--;
            }
            if (j>=0){
                sb.append((char) (j+'a'));
                count[j]--;
                i++;
            }
        }

        return sb.toString();
    }

    public String repeatLimitedString2(String s, int repeatLimit) {
        int n = s.length();
        char[] chars = s.toCharArray();
        List<Character> list = new LinkedList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        List<Character> sort = list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        int l = 0;
        int r = 0;
        int c = 1;
        while (l<r){
            while (sort.get(l)==sort.get(r)){
                r++;
            }
            while (l<0){

            }
        }
        return  null;
    }

    public static void main(String[] args) {
        //System.out.println(new AAAA().findCircleNum2(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
        //new AAAA().restoreIpAddresses("0000");
        char[][] board={{'X','X','X','X'},{'X','O','O','O'},{'X','X','O','X'},{'X','O','X','X'}};
        new AAAA().solve(board);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0]=0;
        Map<Integer,Integer> map  =new HashMap<>();
        map.put(0,0);
        for (int i = 1; i < n+1; i++) {
            sum[i]=nums[i-1]+sum[i-1];
            int m= sum[i]%k;
            if (map.containsKey(m)&&i-map.get(m)>=2){
                return true;
            }
            if (map.containsKey(m)){
                continue;
            }
            map.put(m,i);
        }
        return false;
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Map<Integer,Integer> map  =new HashMap<>();
        map.put(0,-1);
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                sum++;
            }
            if (nums[i] == 0) {
                sum--;
            }
            if (map.containsKey(sum)) {
                maxlen = Math.max(maxlen, i - map.get(sum));
            }
            map.put(sum, i);
        }
        return maxlen;
    }


    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n==1){
            return true;
        }
        if (set.contains(n)){
            return false;
        }
        set.add(n);
        int c = 0;
        while (n!=0){
           int m = n%10;
           c+=(m*m);
           n/=10;
        }

        return isHappy(c);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int[] visit= new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]==1){
                    Set<Integer> list = map.getOrDefault(i, new HashSet<>());
                    list.add(j);
                    map.put(i,list);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)){
                count++;
                findCircleNum1(map,i,visit);
            }
        }
        return count;


    }

    public void findCircleNum1(Map<Integer,Set<Integer>> map,int i,int[] visit){
        Set<Integer> list = map.get(i);
        Set<Integer> res = new HashSet<>();
        res.addAll(list);
        for (Integer j : list) {
            if (j!=i && visit[j]==0){
                visit[j]=1;
                findCircleNum1(map,j,visit);
                res.addAll(map.getOrDefault(j,new HashSet<>()));
                map.remove(j);
                map.put(i,res);
            }

        }

    }

    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        Queue<int[]> queue = new LinkedList<>();
        int[] visit= new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]==0){
                count++;
                queue.add(isConnected[0]);
                visit[i]=1;
            }
            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                for (int j = 0; j < poll.length; j++) {
                    if (poll[j]==1 && visit[j]==0){
                        visit[j]=1;
                        queue.add(isConnected[j]);
                    }
                }

            }
        }

        return count;
    }
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] tep = new int[n][2];
        for (int i = 0; i < n; i++) {
            tep[i][1]=arr[n];
            int num = arr[n];
            while(num!=0)
            {
                num &= (num-1);
                tep[i][0]++;
            }
        }
        Arrays.sort(tep, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]!=0? o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i]=tep[i][1];
        }
        return res;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses1(s,0,new ArrayList<>(),res);
        return res;

    }

    public void restoreIpAddresses1(String s,int index,List<String> sb,List<String> res) {
        // 截至条件
        if (index==s.length() || sb.size()==4){
            if (index==s.length() &&sb.size()==4){
                res.add(sb.stream().collect(Collectors.joining(".")));
            }
            return;
        }

        for (int i = 1; i < (4); i++) {
            String sub = s.substring(index,Math.min(index+i,s.length()));
            int x = Integer.valueOf(sub);
            if ((!sub.startsWith("0") || (sub.length()==1 &&x==0)) && x<256){
                sb.add(sub);
                restoreIpAddresses1(s,index+i,sb,res);
                sb.remove(sb.size()-1);
            }
        }
    }




    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n==1){
            res.add(0);
            return res;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            map.put(edges[i][0],list);

            list = map.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);
            map.put(edges[i][1],list);
        }
        int[] visit;
        int max = n;

        for (int i = 0; i < n; i++) {
            visit = new int[n];
            Node root =findMinHeightTrees1(i,map,visit);
            int heigh = findMinHeightTrees1(root);
            if (heigh<=max){
               if (heigh<max){
                   res.clear();
               }
               res.add(i);
               max=heigh;
            }
        }
        return res;
    }

    public Node findMinHeightTrees1(int index, Map<Integer,List<Integer>> map,int[] visit) {
        List<Integer> list = map.get(index);
        visit[index]=1;
        Node node = new Node(index);
        for (int i = 0; i < list.size(); i++) {
            if (visit[list.get(i)]==0){
                node.next.add(findMinHeightTrees1(list.get(i),map,visit));
            }
        }

        return node;
    }

    public int findMinHeightTrees1(Node root) {
        List<Node> next = root.next;
        if (next.size()==0){
           return 1;
        }
        int max = 0;
        for (int i = 0; i < next.size(); i++) {
           max=Math.max(max,findMinHeightTrees1(next.get(i)));
        }
        return max+1;
    }

    TreeNode xP;
    TreeNode yP;
    int xD;
    int yD;


    public boolean isCousins(TreeNode root, int x, int y) {
        findSon(root,x,y,0);
        return xP!=yP && xD==yD;

    }

    TreeNode p;
    public void findSon(TreeNode root,int x,int y,int deep) {
        if (root==null){
            return;
        }
        if ((root.right!=null &&root.right.val==x) || (root.left!=null &&root.left.val==x)){
            xP=root;
            xD=deep;
        }
        if ((root.right!=null &&root.right.val==y) || (root.left!=null &&root.left.val==y)){
            yP=root;
            yD=deep;
        }
        if (xP!=null && yP !=null){
            return;
        }
        findSon(root.left,x,y,deep+1);
        findSon(root.right,x,y,deep+1);
    }


    int sum =0;
    public int findTilt(TreeNode root) {
         sum(root);
         return sum;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = sum(root.left);
        int r = sum(root.right);
        sum+=Math.abs(l-r);
        return l+r+root.val;
    }
    public void arrayNesting1(int[] nums,int index,Set<Integer> set,int[] visit) {
        if (set.contains(index)){
            return;
        }
        int next = nums[index];
        if (next==index) {
            return;
        }
        if (visit[next]!=0) {
            visit[index]+=visit[next];
            return;
        }
        set.add(index);
        for (Integer i : set) {
            visit[i]++;
        }
        arrayNesting1(nums,next,set,visit);
    }

    public int totalSteps(int[] nums) {
        List<Integer> sou = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sou.add(nums[i]);
        }
        int[] len = new int[1];
        len[0]=n;
        int c=0;
        while (true){
            totalSteps(sou,res,n,len);
            if (n==len[0]){
                return c;
            }
            c++;
            n=len[0];
            sou=new ArrayList<>(res);
            res=new ArrayList<>();

        }

    }
    public void totalSteps(List<Integer> sou,List<Integer> res,int n,int[] len) {
        res.add(sou.get(0));
        for (int i = 1; i < n; i++) {
            if (sou.get(i) < sou.get(i - 1)) {
                len[0]--;
                continue;
            }
            res.add(sou.get(i));
        }
    }

    public int mostWordsFound(String[] sentences) {
        int n = sentences.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = sentences[i].split("\\s+").length;
            max=Math.max(l,max);
        }
        return max;

    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode top=null;
        while (!queue.isEmpty()){
            top = queue.peek();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                }
        }
        return top.val;
    }

    boolean[] flag = new boolean[1];
    List<int[]> list = new ArrayList<>();
    List<int[]> res = new ArrayList<>();
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='V';
                    flag[0] = true;
                    list = new ArrayList<>();
                    solve1(board,i,j,n,m);
                    if (flag[0]){
                        for (int[] ints : list) {
                           board[ints[0]][ints[1]]='X';
                        }
                    }
                    else {
                        res.addAll(list);
                    }
                }
            }
        }

            for (int[] ints : res) {
                board[ints[0]][ints[1]]='O';
            }



    }


    public void solve1(char[][] board,int i,int j, int n, int m) {
        list.add(new int[]{i,j});
        if ((i==0 ||j==0 || i==n-1 || j==m-1)){
            flag[0]=false;
        }
        // 候选节点
        List<int[]> next = next(i, j, n, m);
        for (int[] ner : next) {
            // 筛选临近为'O' 的节点
            if(board[ner[0]][ner[1]]=='O'){
                // 标识遍历过的为 'O' 的节点
                board[ner[0]][ner[1]]='V';
                solve1(board,ner[0],ner[1],n,m);
            }
        }

    }

    public List<int[]> next(int i,int j,int n,int m) {
        List<int[]> list = new ArrayList<>();
        if (i-1>=0){
            list.add(new int[]{i-1,j});
        }
        if (i+1<n){
            list.add(new int[]{i+1,j});
        }
        if (j-1>=0){
            list.add(new int[]{i,j-1});
        }
        if (j+1<m){
            list.add(new int[]{i,j+1});
        }
        return list;
    }

    }



    class Node{
    int val;
    List<Node> next;

        public Node(int val, List<Node> next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
            this.next = new ArrayList<>();
        }
    }
