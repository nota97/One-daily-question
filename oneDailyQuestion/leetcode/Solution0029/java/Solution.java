package oneDailyQuestion.Solution0029.java;


/**
 * 29. 两数相除
 * https://leetcode.cn/problems/divide-two-integers/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == divisor ? 1 : 0;
        }
        //false 正；true 负
        Boolean zf = false;
        if (dividend > 0) {
            dividend = -dividend;
            zf = !zf;
        }
        if (divisor > 0) {
            divisor = -divisor;
            zf = !zf;
        }
        int ans = div(dividend, divisor);
        return zf ? -ans : ans;
    }

    public static int div(int a, int b) {
        if (a > b) return 0;
        int count = 1;
        int sum = b;
        while (sum >= a - sum) {
            count += count;
            sum += sum;
        }
        return count + div(a - sum, b);
    }
}
