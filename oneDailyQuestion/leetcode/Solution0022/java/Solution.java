package oneDailyQuestion.Solution0022.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 * 回溯
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        rollback(ans, new StringBuilder(), 0 ,0, n);
        return ans;
    }

    public static void rollback(List<String> ans, StringBuilder cur, int left, int right, int depth){
        if (cur.length() == depth*2){
            System.out.println(cur.toString());
            ans.add(cur.toString());
            return;
        }
        if (left < depth){
            cur.append("(");
            rollback(ans, cur, left+1, right, depth);
            cur.deleteCharAt(cur.length()-1);
        }
        if (right < left){
            cur.append(")");
            rollback(ans, cur, left, right+1, depth);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
