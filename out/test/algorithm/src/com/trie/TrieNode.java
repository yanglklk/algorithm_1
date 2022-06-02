package com.trie;


public class TrieNode {

    TrieNode[] children;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
