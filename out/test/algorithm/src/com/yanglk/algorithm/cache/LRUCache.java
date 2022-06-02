package com.yanglk.algorithm.cache;

import com.yanglk.algorithm.offer.Str;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRU<String,Object> lru=new LRU(3);
        for (int i = 0; i < (10); i++) {
            lru.put(i,i*i);
        }
        System.out.println(lru);

        lru.get(7);
        System.out.println(lru);
        lru.put(1,1);
        System.out.println(lru);


    }


}
class LRU<K,V> extends LinkedHashMap{
    int size;
    public LRU(int s){
        // 必须要开启accessOrder 这样节点访问后已到队尾
        super(s, (float) 0.75,true);
        this.size=s;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size()>size;
    }


}
