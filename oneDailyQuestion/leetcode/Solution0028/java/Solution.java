package oneDailyQuestion.Solution0028.java;


/**
 * 28. 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int a = i, b = 0;
            while (b < m && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == m) {
                return i;
            }
        }
        return -1;
    }

}
