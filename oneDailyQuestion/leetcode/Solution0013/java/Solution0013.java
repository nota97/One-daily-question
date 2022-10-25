package oneDailyQuestion.Solution0013.java;


import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 */
public class Solution0013 {
    static Map<String, Integer> map = new HashMap<>(){{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        int len = s.length();
        while (i < len) {
            String m = String.valueOf(s.charAt(i));
            if (i < len - 1 && map.get(m + s.charAt(i + 1)) != null) {
                ans += map.get(m + s.charAt(i + 1));
                i += 2;
            } else {
                ans += map.get(m);
                i++;
            }
        }
        return ans;
    }
}
