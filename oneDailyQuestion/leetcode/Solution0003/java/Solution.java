package oneDailyQuestion.Solution0003.java;


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
        for(int i=0; i<n; i++){
            if(i != 0){
                characters.remove(s.charAt(i-1));
            }
            while(r < n && !characters.contains(s.charAt(r))){
                characters.add(s.charAt(r));
                r++;
            }
            System.out.println(characters);
            System.out.println(r);
            ans = Math.max(ans, r-i);
        }
        System.out.println(ans);
        return ans;
    }
}
