package oneDailyQuestion.Solution0076.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<String, Integer> needs = new HashMap<>();
        Map<String, Integer> windows = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            String key = String.valueOf(t.charAt(i));
            needs.put(key, needs.getOrDefault(key, 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            String c = String.valueOf(s.charAt(right));
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                //更新最小窗口
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                String d = String.valueOf(s.charAt(left));
                left++;
                if (needs.containsKey(d)) {
                    if (windows.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
