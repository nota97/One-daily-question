package oneDailyQuestion.Solution0438.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findAnagrams("baa", "aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        for (int i = 0; i < n; i++) {
            char key = p.charAt(i);
            needs.put(key, needs.getOrDefault(key, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))){
                    valid++;
                }
            }
            if (right - left == n){
                if (valid == needs.size()){
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (needs.containsKey(d)){
                    if (windows.get(d).equals(needs.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
            }
        }
        return res;
    }
}
