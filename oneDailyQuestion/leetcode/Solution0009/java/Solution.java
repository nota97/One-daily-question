package oneDailyQuestion.Solution0009.java;


/**
 * 9. 回文数
 * https://leetcode.cn/problems/palindrome-number/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    /**
     * 判断一半数字
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        } else {
            int rev = 0;
            while (x > rev) {
                int dig = x % 10;
                x = x / 10;
                rev = rev * 10 + dig;
            }
            return x == rev || x == rev / 10;
        }
    }


}
