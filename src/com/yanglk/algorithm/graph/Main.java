package com.yanglk.algorithm.graph;



import sun.awt.image.GifImageDecoder;

import java.awt.datatransfer.FlavorListener;
import java.util.*;

public class Main {


    public Node cloneGraph(Node node){
       if (node==null)
           return node;
       Queue<Node> queue=new LinkedList<>();
       queue.add(node);
       Map<Node,Node> visit=new HashMap<>();
       visit.put(node,new Node(node.val,new ArrayList<>()));
       while (!queue.isEmpty()){
           Node n=queue.poll();
           for (Node neighbor : n.neighbors) {
               if (!visit.keySet().contains(neighbor)){
                   visit.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                   queue.add(neighbor);
               }
               visit.get(n).neighbors.add(visit.get(neighbor));
           }
       }
       return visit.get(node);


   }

   public int ladderLength(String beginWord, String endWord,List<String> wordList){
       if (!wordList.contains(endWord))
           return 0;
       Map<String,List<String>> map=new HashMap<>();
       wordList.add(beginWord);
       Map<String,String> parent=new HashMap<>();
       for (String s : wordList) {
           int l=s.length();
           parent.put(s,null);
           ArrayList<String> list=new ArrayList<>();
           for (int i = 0; i < l; i++) {
               String ss=s.substring(0,i)+"(.*)"+s.substring(i+1,l);
               for (String s1 : wordList) {
                   if ((!s1.equals(s))&&s1.length()==s.length()&&s1.matches(ss)){
                       list.add(s1);
                   }
               }
           }
           map.put(s,list);
       }
       Queue<String> queue=new LinkedList<>();
       Set<String> set=new HashSet<>();
       queue.add(beginWord);
       set.add(beginWord);
       while (!queue.isEmpty()){
           String s=queue.poll();
           for (String s1 : map.get(s)) {
               if (!set.contains(s1)){
                   queue.add(s1);
                   parent.put(s1,s);
                   set.add(s1);
               }
           }
       }
       int count=0;

       while (endWord!=beginWord){
           endWord=parent.get(endWord);
           if (endWord==null)
               return 0;
           count++;
       }
       return count+1;
   }

   int[][] pis={{0,1},{0,-1},{1,0},{-1,0}};


   public void solve(String[][] board){

       int row=board.length;
       int col=board[0].length;
       for (int i = 0; i < row; i++) {
           if (board[i][0]=="O"){
                board_bfs(i,0,board,row,col);
           }
           if (board[i][col-1]=="O"){
               board_bfs(i,col-1,board,row,col);
           }
       }
       for (int i = 0; i < col; i++) {
           if (board[0][i]=="O"){
               board_bfs(0,i,board,row,col);
           }
           if (board[row-1][i]=="O"){
               board_bfs(row-1,i,board,row,col);
           }
       }
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               if (board[i][j]=="*"){
                   board[i][j]="O";
               }
               else if (board[i][j]=="O"){
                   board[i][j]="X";
               }
           }
       }

   }
   public void board_bfs(int i, int j,String[][] board,int row,int col){
       Queue<Pistion> queue=new LinkedList<>();
       Pistion pp=new Pistion(i,j);
       queue.add(pp);
       while (!queue.isEmpty()){
           Pistion p=queue.poll();
           if (p.x>=0&&p.x<row&&p.y>=0&&p.y<col&&board[p.x][p.y]=="O"){
               board[p.x][p.y]="*";
               for (int i1 = 0; i1 < pis.length; i1++) {
                   int ii=p.x+pis[i1][0];
                   int jj=p.y+pis[i1][1];
                   Pistion ppp=new Pistion(ii,jj);
                   queue.add(ppp);
               }
           }

       }
   }

    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList=new ArrayList<>();
        String[] ss={"hot","dot","dog","lot","log","cog"};
        for (String s : ss) {
            wordList.add(s);
        }

        int[][] c={{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};

        //new Main().ladderLength(beginWord,endWord,wordList);
        String[][] board={{"X","X","X","X"},{"X","O","O","X"},{"X","X","O","X"},{"X","O","X","X"}};
        new Main().canFinish(7,c);
        int a=000;
    }

    public int numsIsland(char[][] grid){
        if (grid==null||grid.length==0)
            return 0;
       int col=grid[0].length;
       int row=grid.length;
       int[][] vis=new int[row][col];
       int count=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]=='1'){
                    island_bfs1(i,j,grid,row,col,vis);
                    count++;
                }

            }
        }
        return count;

    }
    public void island_bfs1(int i,int j,char[][] grid,int row,int col,int[][] visit){
        Queue<Pistion> queue=new LinkedList<>();
        queue.add(new Pistion(i,j));
        visit[i][j]=1;
        grid[i][j]='2';
        while (!queue.isEmpty()){
            Pistion p=queue.poll();
                for (int[] pi : pis) {
                    int ii=pi[0]+p.x;
                    int jj=pi[1]+p.y;
                    if (ii>=0&&jj<row&&ii>=0&&jj<col&&grid[ii][jj]=='1'&&visit[ii][jj]==0){
                        grid[ii][jj]='2';
                        visit[ii][jj]=1;
                        queue.add(new Pistion(ii,jj));
                }
            }
        }
    }
    public void island_bfs(int i,int j,char[][] grid,int row,int col){
       Queue<Pistion> queue=new LinkedList<>();
       queue.add(new Pistion(i,j));
       while (!queue.isEmpty()){
           Pistion p=queue.poll();
           if (p.x>=0&&p.x<row&&p.y>=0&&p.y<col&&grid[p.x][p.y]=='1'){
               grid[p.x][p.y]='2';
               for (int[] pi : pis) {
                   queue.add(new Pistion(p.x+pi[0],p.y+pi[1]));
               }
           }
       }
    }

    public boolean canFinish(int numCourses,int[][] prerequisites){
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.keySet().contains(prerequisite[0])){
                List t=map.get(prerequisite[0]);
                t.add(prerequisite[1]);
                map.put(prerequisite[0],t);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(prerequisite[1]);
                map.put(prerequisite[0],list);
            }
        }
        int[] vis=new int[numCourses];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (vis[i]==-1)
                continue;
            stack.push(i);
            int[] temp=Arrays.copyOf(vis,vis.length);
            while (!stack.isEmpty()){
                int t=stack.pop();
                if (map.containsKey(t)){
                    temp[t]=1;
                    for (Integer integer : map.get(t)) {
                        if (temp[integer]==0&&!stack.contains(integer)){
                            stack.push(integer);
                        }
                        if (temp[integer]==1){
                            return false;
                        }
                        if (temp[integer]==-1){
                            continue;
                        }
                    }
                }
                else {
                    for (int i1 = 0; i1 < temp.length; i1++) {
                        if (i1!=t){
                            temp[i1]=-1;
                        }
                    }
                }
            }
            vis=Arrays.copyOf(temp,temp.length);
        }
        return true;
    }

    public boolean canFinish1(int numCourses,int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.keySet().contains(prerequisite[0])) {
                List t = map.get(prerequisite[0]);
                t.add(prerequisite[1]);
                map.put(prerequisite[0], t);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[1]);
                map.put(prerequisite[0], list);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!map.keySet().contains(i))
                map.put(i,new ArrayList<>());
        }
        int[] flag=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
                if (courseDfs(map,flag,i))
                    return false;

        }
        return true;
    }
    public boolean courseDfs( Map<Integer, List<Integer>> map,int[] flag,int k){
       if (flag[k]==1)
           return false;
       if (flag[k]==-1)
           return true;
        flag[k]=1;
        for (Integer integer : map.get(k)) {
            if (!courseDfs(map,flag,integer))
                return false;
        }
        flag[k]=-1;
        return true;
    }

}
