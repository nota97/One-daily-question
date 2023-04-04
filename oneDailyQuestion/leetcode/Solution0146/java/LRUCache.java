package oneDailyQuestion.Solution0146.java;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> linkedHashMap;

    int size;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<>(capacity, capacity , true);
        size = capacity;
    }

    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (linkedHashMap.size() < size) {
            if (linkedHashMap.containsKey(key)) {
                linkedHashMap.replace(key, value);
            } else {
                linkedHashMap.put(key, value);
            }
        } else {
            if (linkedHashMap.containsKey(key)) {
                linkedHashMap.replace(key, value);
            } else {
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
                linkedHashMap.put(key, value);
            }
        }
    }
    public void toStr(){
        System.out.println(linkedHashMap);
    }
}
