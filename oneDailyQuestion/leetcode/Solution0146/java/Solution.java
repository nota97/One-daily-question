package oneDailyQuestion.Solution0146.java;

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 */
public class Solution {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.toStr();
    }
}
