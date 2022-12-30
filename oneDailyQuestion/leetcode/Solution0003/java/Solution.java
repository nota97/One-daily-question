package oneDailyQuestion.Solution0003.java;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3.无重复字符的最长字串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcdbdsfaf");
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int n = s.length();
        int ans = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                characters.remove(s.charAt(i - 1));
            }
            while (r < n && !characters.contains(s.charAt(r))) {
                characters.add(s.charAt(r));
                r++;
            }
            System.out.println(characters);
            System.out.println(r);
            ans = Math.max(ans, r - i);
        }
        System.out.println(ans);
        return ans;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            right++;
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                windows.put(d, windows.get(d) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
