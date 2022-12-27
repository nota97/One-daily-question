package oneDailyQuestion.Solution0123.java;


/**
 * 123. 买卖股票的最佳时机 III
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, - prices[i]);
        }
        return dp_i20;
    }
}
