package oneDailyQuestion.Solution0005.java;


/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length()==1){
            return s;
        }
        int n = s.length();
        int left = 0, right = 0;
        int len = 1;
        int startIndex = 0;
        int strMax = 1;
        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i + 1;
            //向左寻找相同字符
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            //向右寻找相同字符
            while (right < n && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            //同时向左右寻找，左右一致则继续循环寻找
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            if (strMax < len) {
                strMax = len;
                startIndex = left;
            }
            len = 1;
        }
        //left 在while中多减了1，需要+1
        return s.substring(startIndex + 1, startIndex + strMax + 1);
    }
}
