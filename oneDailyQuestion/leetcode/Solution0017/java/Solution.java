package oneDailyQuestion.Solution0017.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        rollback(ans, dict, digits, 0, new StringBuilder());
        return ans;
    }

    public static void rollback(List<String> ans, Map<Character, String> dict, String digits, int depth, StringBuilder tmp) {
        int n = digits.length();
        if (n == depth){
            ans.add(tmp.toString());
        }else{
            char c = digits.charAt(depth);
            String dig = dict.get(c);
            for(int i=0;i< dig.length();i++){
                tmp.append(dig.charAt(i));
                rollback(ans,dict,digits,depth+1,tmp);
                tmp.deleteCharAt(depth);
            }
        }
    }
}
