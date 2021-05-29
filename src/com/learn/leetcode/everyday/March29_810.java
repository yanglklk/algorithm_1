package com.learn.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class March29_810 {
    public static void main(String[] args) {
        new March29_810().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb");

    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> retString = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() != pattern.length()){
                continue;
            }else {
                Map<Character,Character> patternMap =new HashMap<>();
                boolean canAdd =true;
                for (int k = 0; k < word.length(); k++) {
                    Character chKey = word.charAt(k);
                    Character chVal = pattern.charAt(k);
                    if (patternMap.containsKey(chKey)){
                        if ((!patternMap.get(chKey).equals(chVal))){
                            canAdd = false;
                            break;
                        }
                    }
                    else {
                        if (patternMap.values().contains(chVal)){
                            canAdd = false;
                            break;
                        }
                        patternMap.put(chKey,chVal);
                    }
                }
                if (canAdd){
                    retString.add(word);
                }
            }
        }
        return retString;
    }
}
