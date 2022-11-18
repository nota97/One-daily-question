package oneDailyQuestion.Solution0058.java;


/**
 * 58. 最后一个单词的长度
 * https://leetcode.cn/problems/length-of-last-word/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("file"));
    }

    public static int lengthOfLastWord(String s) {
        int index = s.length()-1;
        int n = 0;
        while (s.charAt(index)==' '){
            index--;
        }
        while (index>=0 &&s.charAt(index)!= ' '){
            n++;
            index--;
        }
        return n;
    }
}
