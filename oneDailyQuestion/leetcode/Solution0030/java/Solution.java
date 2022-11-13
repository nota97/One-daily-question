package oneDailyQuestion.Solution0030.java;

import java.util.*;


/**
 * 30. 串联所有单词的子串
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 */
public class Solution {
    public static void main(String[] args) {
        findSubstringHash("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good" });
    }

    //暴力查询
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = words[0].length();
        int len = words.length * n;
        for (int i = 0; i <= s.length() - len + 1; i++) {
            List<String> lst = new ArrayList<>(Arrays.asList(words));
            int a = i;
            while (a < len + i && a <= s.length() - n) {
                String part = s.substring(a, a + n);
                if (lst.contains(part)) {
                    lst.remove(part);
                } else {
                    break;
                }
                if (lst.isEmpty())
                    ans.add(i);
                a += n;
            }
        }
        System.out.println(ans);
        return ans;
    }

    //滑动窗口，哈希表
    public static List<Integer> findSubstringHash(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = words[0].length();
        int len = words.length * n;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int value = wordMap.getOrDefault(word, 0);
            wordMap.put(word, value + 1);
        }
        //遍历s子串
        for (int i = 0; i <= s.length() - len + 1; i++) {
            Map<String, Integer> hasMap = new HashMap<>();
            int a = i;
            while (a < len + i) {
                String word = s.substring(a, a + n);
                if (wordMap.containsKey(word)) {
                    int value = hasMap.getOrDefault(word, 0);
                    hasMap.put(word, value + 1);
                    if (hasMap.get(word) > wordMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                a += n;
            }
            if (a == len + i) {
                res.add(i);
            }
        }
        System.out.println(res);
        return res;
    }
}
