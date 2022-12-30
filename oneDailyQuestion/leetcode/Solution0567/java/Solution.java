package oneDailyQuestion.Solution0567.java;


import java.util.HashMap;

/**
 * 567. 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))){
                    valid++;
                }
            }
            while (right -left >= s1.length()){
                if (valid == needs.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (needs.containsKey(d)){
                    if (windows.get(d).equals(needs.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return false;
    }
}