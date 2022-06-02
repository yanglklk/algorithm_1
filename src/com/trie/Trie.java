package com.trie;


import java.awt.peer.WindowPeer;
import java.util.*;

public class Trie {


    public String replaceWords1(List<String> dictionary, String sentence) {
        TrieNode trieNode = new TrieNode();

        for (String root : dictionary) {
            TrieNode cur = trieNode;
            for (char c : root.toCharArray()) {
                if (cur.children[c-'a']==null){
                    cur.children[c-'a']=new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.word=root;
        }

        String[] split = sentence.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (String word : split) {
            TrieNode cur = trieNode;
            for (char c : word.toCharArray()) {
                if (cur.children[c-'a']==null || cur.word!=null){
                    break;
                }
                cur= cur.children[c-'a'];
            }
            sb.append(cur.word==null? word:cur.word);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();


    }

    Trie[] children;
    boolean isEnd;
    public Trie() {
        this.children= new Trie[26];
        isEnd= false;
    }

    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c-'a']==null){
                cur.children[c-'a']=new Trie();
            }
            cur= cur.children[c-'a'];
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        Trie cur = startsWith1(word);
        return cur!=null && cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = startsWith1(prefix);
        return cur!=null;
    }

    private Trie startsWith1(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c-'a']==null ){
               return null;
            }
            cur= cur.children[c-'a'];
        }
        return cur;
    }

    public boolean search2(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c-'a']==null){
                return false;
            }
            cur= cur.children[c-'a'];
        }
        return cur.isEnd;
    }

    public boolean startsWith2(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c-'a']==null ){
                return false;
            }
            cur= cur.children[c-'a'];
        }
        return true;
    }

    public List<Integer> lexicalOrder(int n) {

        int i =1;
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            result.add(i);
            if (i*10<=n){
                i=i*10;
            }else {
                while (i%10==9 || i+1>n){
                    i=i/10;
                }
                i++;
            }
        }

        return result;
    }


    public List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < (10); i++) {
            dfs(i,n,res);
        }
        return res;
    }
    public void dfs(int i ,int n,List<Integer> res){
        if (i>n){
            return;
        }
        res.add(i);
        for (int i1 = 0; i1 < (10); i1++) {
            dfs(i*10+i1,n,res);
        }

    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("leet");
        strings.add("code");
        new Trie().wordBreak("leetcode",strings);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] opt = new boolean[n+1];
        Set<String> set = new HashSet<>(wordDict);
        opt[0]=true;
        for (int i = 1; i < n+1; i++) {
            opt[i]=false;
            for (int j = 0; j < i; j++) {
                opt[i]=opt[j]&&set.contains(s.substring(j,i));
                if (opt[i]){
                    break;
                }
            }
        }
        return opt[n];

    }

}




