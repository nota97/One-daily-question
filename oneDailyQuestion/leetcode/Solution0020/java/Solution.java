package oneDailyQuestion.Solution0020.java;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        map.put("?","?");
        //stack为空时，pop会报错，初始化入栈一个？
        Stack<String> stack = new Stack<>(){{add("?");}};
        for(int i=0;i<s.length();i++){
            String ans = String.valueOf(s.charAt(i));
            //为左括号直接入栈
            if (map.containsKey(ans)){
                stack.add(ans);
                //否则与栈顶元素匹配，不匹配则返回false
            } else if (!map.get(stack.pop()).equals(ans)) {
                return false;
            }
        }
        return stack.size()==1;
    }
}
