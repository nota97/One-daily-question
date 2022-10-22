package oneDailyQuestion.Solution0012.java;


import java.util.Map;

/**
 * 12. 整数转罗马数字
 * https://leetcode.cn/problems/integer-to-roman/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(9));
    }

    public static String intToRoman(int num) {
        int[] index = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            while (num >= index[i]) {
                num -= index[i];
                ans.append(symbol[i]);
            }
        }
        return ans.toString();
    }
}
